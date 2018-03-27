package me.piepers.super11.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.schedulers.Schedulers;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;
import me.piepers.super11.domain.sportdeer.Season;

@Ignore
@RunWith(VertxUnitRunner.class)
public class SportDeerApiTest {

	private Vertx vertx;

	private final String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI1YTk4ZWZkZmE4OTdjYzdmZTk5ZmE2YjkiLCJhY2Nlc3NfbGV2ZWwiOjEsImlhdCI6MTUyMjE3MTAxNywiZXhwIjoxNTIyMTcyODE3fQ.Q85XU6VRW1gG-TdrHIPgVztsdnFPp3mI-WRQ_uIImgY";

	@Before
	public void before(TestContext context) {
		this.vertx = Vertx.vertx();
	}

	@After
	public void after(TestContext context) {
		this.vertx.close(context.asyncAssertSuccess());
	}

	@Test
	public void test_request_new_key(TestContext context) {
		Async async = context.async();
		// Obtain the first call and the amount of pages.
		WebClient client = WebClient.create(this.vertx);
		client.get(443, "api.sportdeer.com", "/v1/seasons?access_token=" + this.accessToken).ssl(true).rxSend()
				.doAfterTerminate(async::complete).subscribe(response -> {
					JsonObject jsonObject = response.bodyAsJsonObject();
					System.out.println(jsonObject.toString());
					// Docs<Season> content = new Docs<>(jsonObject);

					List<Season> seasons = jsonObject.getJsonArray("docs").stream().map(o -> new Season((JsonObject) o))
							.collect(Collectors.toList());
					context.assertTrue(response.statusCode() == 200);
					seasons.stream().forEach(s -> System.out.println(s.toString()));
				}, throwable -> {
					context.fail();
				});
	}

	List<Integer> service(int index) {
		System.out.println("Reading " + index);
		List<Integer> list = new ArrayList<>();
		for (int i = index; i < index + 20; i++) {
			list.add(i);
		}
		return list;
	}

	Flowable<List<Integer>> getPage(int index) {
		FlowableProcessor<Integer> pager = UnicastProcessor.<Integer>create().toSerialized();
		pager.onNext(index);

		return pager.observeOn(Schedulers.trampoline(), true, 1).map(v -> {
			List<Integer> list = this.service(v);
			pager.onNext(list.get(list.size() - 1) + 1);
			return list;
		});
	}

	@Test
	public void testPager() {
		this.getPage(0).take(20).subscribe(System.out::println, Throwable::printStackTrace);
	}
}
