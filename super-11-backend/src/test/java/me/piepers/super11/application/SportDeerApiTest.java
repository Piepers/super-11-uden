package me.piepers.super11.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Observable;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;
import me.piepers.super11.domain.sportdeer.Docs;
import me.piepers.super11.domain.sportdeer.Season;

@Ignore
@RunWith(VertxUnitRunner.class)
public class SportDeerApiTest {

	private Vertx vertx;

	private final String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI1YTk4ZWZkZmE4OTdjYzdmZTk5ZmE2YjkiLCJhY2Nlc3NfbGV2ZWwiOjEsImlhdCI6MTUyMjY4OTM4MiwiZXhwIjoxNTIyNjkxMTgyfQ.xg9FuM5TZ-jJttY1CiQbma9Hkohp5kHCZ-Z0afQWv-0";
	private final String apiBaseUrl = "api.sportdeer.com";
	private final String apiEndPointUrl = "/v1/seasons/";
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
		client.get(443, "api.sportdeer.com", this.apiEndPointUrl + "?" + this.accessTokenParam + this.accessToken)
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
	public void test_paginated_request(TestContext context) {
		Async async = context.async();
		// WebClient client = WebClient.create(this.vertx);
		// All the seasons ever
		// List<Season> totalSeasons = new ArrayList<>();
		// int page = 1;
		// client.get(443, this.apiBaseUrl, this.apiEndPointUrl + "?" +
		// this.accessToken)
		// .ssl(true)
		// .rxSend()
		// .map(response -> response.bodyAsJsonObject())
		// .map(jsonObject -> new Docs<>(jsonObject, Season.class))
		// .repeat()
		// .takeUntil(result -> result.getPagination() != null)

		List<Season> allSeasons = new ArrayList<>();

		WebClient client = WebClient.create(this.vertx);

		// Get the first page (because we need the pagination in the first page
		this.getNextPage(client, 1)
				.flatMap(result -> {
					allSeasons.addAll(result.getData());
					return Observable.range(2, result.getPagination()
							.getPages());
				})
				.flatMap(page -> this.getNextPage(client, page))
				.doAfterTerminate(() -> {
					async.complete();
					client.close();
				})
				.subscribe(docs -> allSeasons.addAll(docs.getData()),
						throwable -> System.err.println("Something went wrong in the final subscription"),
						() -> System.out.println("Items added to allSeasons: " + allSeasons.size()));

		// this.getNextPage(client, 1)
		// .doAfterTerminate(() -> {
		// client.close();
		// async.complete();
		// })
		// .subscribe(result -> {
		// // Add all the elements to the list of seasons.
		// allSeasons.addAll(result.getData());
		// // If the first page contained pagination and has more pages then create a
		// new
		// // Observable and subscribe to that
		// Pagination pagination = result.getPagination();
		//
		// if (pagination.getPages() > 1) {
		//
		// Observable.range(1, pagination.getPages())
		// .flatMap(page -> this.getNextPage(client, page))
		// .subscribe(iterationResult -> allSeasons.addAll(iterationResult.getData()),
		// throwable -> {
		// throwable.printStackTrace(System.err);
		// System.err.println("Something went wrong while paginating ("
		// + throwable.getMessage() + ").");
		// });
		// }
		//
		// }, throwable -> System.err.println("Something went wrong"), () -> {
		// System.out.println("Items that have been added to the list: " +
		// allSeasons.size());
		// });
		// int page = 1;
		// Get initial page and then, with a second obervable, the subsequent pages?
		// this.getNextPage(client, page)
		// .repeat(5)
		// .doOnNext(docs -> page += 1)
		// .doAfterTerminate(() -> {
		// async.complete();
		// client.close();
		// })
		// .subscribe(docs -> System.out.println("Amount of items retrieved: " +
		// docs.getData()
		// .size()), throwable -> {
		// System.err.println("Something went wrong.");
		// throwable.printStackTrace();
		// });

		// Observable.fromArray(1, 2, 3, 4, 5, 6)
		// .takeUntil(number -> number > 3)
		// .doOnTerminate(async::complete)
		// .subscribe(result -> System.out.println(result),
		// throwable -> System.err.println(throwable.getMessage()));

		// .takeUntil(result ->
		// result.getPagination().getPage().equals(result.getPagination().getPage()))

		// .map(response -> response.bodyAsJsonObject())
		// .flatMap(jsonObject -> new Docs<>(jsonObject, Season.class))
		// .takeUntil(other)

	}

	private Observable<Docs<Season>> getNextPage(WebClient client, int pageNumber) {
		return client
				.get(443, this.apiBaseUrl,
						this.apiEndPointUrl + "?" + this.pageParam + pageNumber + "&" + this.accessTokenParam
								+ this.accessToken)
				.ssl(true)
				.rxSend()
				.map(response -> response.bodyAsJsonObject())
				.map(jsonObject -> new Docs<>(jsonObject, Season.class))
				.toObservable();
	}

	// private Observable<List<Season>> getNextPage(WebClient client, Integer
	// pageNumber) {
	// return Observable.create(subscriber -> {
	// client.get(443, this.apiBaseUrl,
	// this.apiEndPointUrl + "?" + this.accessTokenParam + this.accessToken + "&" +
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
			client.get(443, this.apiBaseUrl, this.apiEndPointUrl + this.accessToken)
					.ssl(true)
					.rxSend();

			// If we have a pagination and if it is not yet the last page:

			// Or complete
			client.close();
			subscriber.onComplete();
		});
	}
}
