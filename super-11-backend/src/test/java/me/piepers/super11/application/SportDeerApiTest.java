package me.piepers.super11.application;

import io.reactivex.Observable;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;
import me.piepers.super11.domain.sportdeer.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Ignore
@RunWith(VertxUnitRunner.class)
public class SportDeerApiTest {

    private Vertx vertx;

    private final String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI1YTk4ZWZkZmE4OTdjYzdmZTk5ZmE2YjkiLCJhY2Nlc3NfbGV2ZWwiOjEsImlhdCI6MTUyMzQ3MDMyMCwiZXhwIjoxNTIzNDcyMTIwfQ.VMlz1Vl4tdJyGGYFvcBpEMa5RBRyfDXsB4I-OzkXLRQ";
    private final String apiBaseUrl = "api.sportdeer.com";
    private final String apiLeagueEndPointUrl = "/v1/leagues/";
    private final String apiSeasonEndPointUrl = "/v1/seasons/";
    private final String apiSeasonFixturesEndPointUrl = "/v1/seasons/%s/fixtures?populate=events&populate=lineups";
    private final String accessTokenParam = "access_token=";
    private final String pageParam = "page=";

    @Before
    public void before(TestContext context) {
        this.vertx = Vertx.vertx();
    }

    @After
    public void after(TestContext context) {
        this.vertx.close(context.asyncAssertSuccess());
    }

    @Ignore
    @Test
    public void test_request_new_key(TestContext context) {
        Async async = context.async();
        // Obtain the first call and the amount of pages.
        WebClient client = WebClient.create(this.vertx);
        client.get(443, "api.sportdeer.com", "/v1/seasons?access_token=" + this.accessToken)
                .ssl(true)
                .rxSend()
                .doAfterTerminate(async::complete)
                .subscribe(response -> {
                    JsonObject jsonObject = response.bodyAsJsonObject();
                    System.out.println(jsonObject.toString());
                    // Docs<Season> content = new Docs<>(jsonObject);
                    // Get the list of seasons of the first page.
                    List<Season> seasons = jsonObject.getJsonArray("docs")
                            .stream()
                            .map(o -> new Season((JsonObject) o))
                            .collect(Collectors.toList());
                    context.assertTrue(response.statusCode() == 200);
                    seasons.stream()
                            .forEach(s -> System.out.println(s.toString()));
                }, throwable -> {
                    context.fail();
                });
        client.close();
    }

    @Ignore
    @Test
    public void test_initial_request(TestContext context) {
        Async async = context.async();
        WebClient client = WebClient.create(this.vertx);
        List<Season> seasons = new ArrayList<>();
        client.get(443, "api.sportdeer.com", this.apiLeagueEndPointUrl + "?" + this.accessTokenParam + this.accessToken)
                .ssl(true)
                .rxSend()
                .map(response -> response.bodyAsJsonObject())
                .map(jsonObject -> new Docs<>(jsonObject, Season.class))
                .toObservable()
                .doAfterTerminate(() -> {
                    async.complete();
                    client.close();
                })
                .subscribe(result -> {
                    seasons.addAll(result.getData());
                }, throwable -> System.err.println("An error has occurred: " + throwable.getMessage()), () -> {

                    System.out.println("The list has now been populated with " + seasons.size() + " items.");
                    // seasons.stream()
                    // .forEach(s -> {
                    // System.out.println(s);
                    // });
                });

        // .map(new Func1<HttpResponse, String>() -> {
        // JsonObject jsonObject = httpResponse.bodyAsJsonObject();
        // if (jsonObject.containsKey("pagination")) {
        // Pagination pagination = new
        // Pagination(jsonObject.getJsonObject("pagination"));
        // }
        // })
    }

    @Test
    public void test_paginated_league_request(TestContext context) {
        Async async = context.async();

        List<League> allLeagues = new ArrayList<>();

        WebClient client = WebClient.create(this.vertx);

        // Get the first page (because we need the pagination in the first page
        this.getNextLeaguePage(client, 1)
                .flatMap(result -> {
                    allLeagues.addAll(result.getData());
                    System.out.println("Pages: " + result.getPagination().getPages());
                    return Objects.nonNull(result.getPagination()) && result.getPagination().getPages() > 1 ?
                            Observable.range(2, result.getPagination()
                                    .getPages()) : Observable.empty();
                })
                .flatMap(page -> this.getNextLeaguePage(client, page))
                .doAfterTerminate(() -> {
                    async.complete();
                    client.close();
                })
                .subscribe(docs -> {
                            context.assertNotNull(docs);
                            System.out.println("Docs has: " + docs.getData().size() + " items.");
                            allLeagues.addAll(docs.getData());
                        },
                        throwable -> System.err.println("Something went wrong in the final subscription"),
                        () -> System.out.println("Items added to allLeagues: " + allLeagues.size()));

    }

    @Test
    public void test_paginated_season_request(TestContext context) {
        Async async = context.async();

        List<Season> allSeasons = new ArrayList<>();

        WebClient client = WebClient.create(this.vertx);

        this.getNextSeasonPage(client, 1)
                .flatMap(result -> {
                    allSeasons.addAll(result.getData());
                    return Objects.nonNull(result.getPagination()) && result.getPagination().getPages() > 1 ?
                            Observable.range(2, result.getPagination()
                                    .getPages()) : Observable.empty();
                })
                .flatMap(page -> this.getNextSeasonPage(client, page))
                .doAfterTerminate(() -> {
                    async.complete();
                    client.close();
                })
                .subscribe(docs -> {
                            context.assertNotNull(docs);
                            allSeasons.addAll(docs.getData());
                        }, throwable -> System.err.println("Something went wrong in the final subcsription"),
                        () -> {
                            // Just for fun:
                            System.out.println("Items added to allSeasons: " + allSeasons.size());
                            List<Season> eredivisieSeasons = allSeasons
                                    .stream()
                                    .peek(season -> System.out.println(season.toString()))
                                    .filter(season -> season.getLeagueId().equals(LeagueId.of(145L)))
                                    .peek(season -> System.out.println(season.toString()))
                                    .collect(Collectors.toList());
                        });


    }

    @Test
    public void test_paginated_season_fixture_request(TestContext context) {
        Async async = context.async();

        List<FixtureEventsLineUps> allFixtureEvents = new ArrayList<>();

        WebClient client = WebClient.create(this.vertx);
        this.getNextFixtureEventsPage(client, 1)
                .flatMap(result -> {
                    allFixtureEvents.addAll(result.getData());
                    return Objects.nonNull(result.getPagination()) && result.getPagination().getPages() > 1 ?
                            Observable.range(2, result.getPagination()
                                    .getPages()) : Observable.empty();
                })
                .flatMap(page -> this.getNextFixtureEventsPage(client, page))
                .doAfterTerminate(() -> {
                    async.complete();
                    client.close();
                })
                .subscribe(docs -> {
                            context.assertNotNull(docs);
                            allFixtureEvents.addAll(docs.getData());
                        }, throwable -> {
                            System.err.println("Something went wrong in the final subcsription");
                            throwable.printStackTrace();
                        },
                        () -> {
                            // Just for fun:
                            System.out.println("Items added to all fixture-events: " + allFixtureEvents.size());
                            allFixtureEvents
                                    .stream()
                                    .peek(fixtureEventsLineUps -> System.out.println("Fixture: "+ fixtureEventsLineUps))
                                    .forEach(fixtureEventsLineUps -> {
                                        fixtureEventsLineUps.getEvents().stream().forEach(event -> System.out.println("Event: "+ event));
                                        fixtureEventsLineUps.getLineUps().stream().forEach(lineUp -> System.out.println("Lineup: "+ lineUp));
                                    });
                        });

    }

    private Observable<Docs<FixtureEventsLineUps>> getNextFixtureEventsPage(WebClient client, int pageNumber) {
        String url = String.format(this.apiSeasonFixturesEndPointUrl + "&" + this.pageParam + pageNumber + "&" + this.accessTokenParam
                + this.accessToken, "287");
        return client
                .get(443, this.apiBaseUrl,
                        url)
                .ssl(true)
                .rxSend()
                .map(response -> response.bodyAsJsonObject())
                .map(jsonObject -> new Docs<>(jsonObject, FixtureEventsLineUps.class))
                .toObservable();
    }

    private Observable<Docs<Season>> getNextSeasonPage(WebClient client, int pageNumber) {
        return client
                .get(443, this.apiBaseUrl,
                        this.apiSeasonEndPointUrl + "?" + this.pageParam + pageNumber + "&" + this.accessTokenParam
                                + this.accessToken)
                .ssl(true)
                .rxSend()
                .map(response -> response.bodyAsJsonObject())
                .map(jsonObject -> new Docs<>(jsonObject, Season.class))
                .toObservable();
    }

    private Observable<Docs<League>> getNextLeaguePage(WebClient client, int pageNumber) {
        return client
                .get(443, this.apiBaseUrl,
                        this.apiLeagueEndPointUrl + "?" + this.pageParam + pageNumber + "&" + this.accessTokenParam
                                + this.accessToken)
                .ssl(true)
                .rxSend()
                .map(response -> response.bodyAsJsonObject())
                .map(jsonObject -> new Docs<>(jsonObject, League.class))
                .toObservable();
    }

    // private Observable<List<Season>> getNextPage(WebClient client, Integer
    // pageNumber) {
    // return Observable.create(subscriber -> {
    // client.get(443, this.apiBaseUrl,
    // this.apiLeagueEndPointUrl + "?" + this.accessTokenParam + this.accessToken + "&" +
    // this.pageParam
    // + pageNumber)
    // .ssl(true)
    // .rxSend();
    // });
    // }

    // Just experimenting. See:
    // https://stackoverflow.com/questions/42877978/how-to-concatwith-using-information-from-previous-observable-for-pagination/42892287#42892287
    // List<Integer> service(int index) {
    // System.out.println("Reading " + index);
    // List<Integer> list = new ArrayList<>();
    // for (int i = index; i < index + 20; i++) {
    // list.add(i);
    // }
    // return list;
    // }
    //
    // Flowable<List<Integer>> getPage(int index) {
    // FlowableProcessor<Integer> pager =
    // UnicastProcessor.<Integer>create().toSerialized();
    // pager.onNext(index);
    //
    // return pager.observeOn(Schedulers.trampoline(), true, 1).map(v -> {
    // List<Integer> list = this.service(v);
    // pager.onNext(list.get(list.size() - 1) + 1);
    // return list;
    // });
    // }

    @Ignore
    @Test
    public void testPager() {
        // this.getPage(0).take(20).subscribe(System.out::println,
        // Throwable::printStackTrace);

    }

    // Creates an Observable that retrieves all the seasons from the Sportdeer Api.
    public Observable<Season> getSeasons() {

        return Observable.<Season>create(subscriber -> {
            WebClient client = WebClient.create(this.vertx);
            // Read the API to get the initial request with the pagination.
            client.get(443, this.apiBaseUrl, this.apiLeagueEndPointUrl + this.accessToken)
                    .ssl(true)
                    .rxSend();

            // If we have a pagination and if it is not yet the last page:

            // Or complete
            client.close();
            subscriber.onComplete();
        });
    }
}
