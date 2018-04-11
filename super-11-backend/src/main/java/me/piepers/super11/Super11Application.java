package me.piepers.super11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Completable;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.config.ConfigRetriever;
import io.vertx.reactivex.core.AbstractVerticle;
import me.piepers.super11.application.FeedVerticle;
import me.piepers.super11.application.HttpServerVerticle;
import me.piepers.super11.application.Super11CommandHandlerVerticle;

/**
 * The main entry point for the application. Used as the configuration class of
 * the application. See pom.xml file.
 *
 * @author Bas Piepers
 */
public class Super11Application extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(Super11Application.class);

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        // Register event bus services (services that send and respond to messages)

        // The configuration of the application
        final ConfigStoreOptions store = new ConfigStoreOptions().setType("file")
                .setConfig(new JsonObject().put("path", "super-11-conf.json"));
        final ConfigRetrieverOptions options = new ConfigRetrieverOptions().addStore(store);

        final ConfigRetriever configRetriever = ConfigRetriever.create(this.vertx, options);

        // Deploy verticles
        configRetriever.rxGetConfig().flatMapCompletable(configuration ->

                Completable.fromAction(() -> LOGGER.info("Deploying super 11 backend"))
                        .andThen(this.vertx.rxDeployVerticle(Super11CommandHandlerVerticle.class.getName(),
                                new DeploymentOptions().setConfig(configuration)))
                        .toCompletable()
                        .andThen(this.vertx.rxDeployVerticle(HttpServerVerticle.class.getName(),
                                new DeploymentOptions().setConfig(configuration)))
                        .toCompletable().andThen(this.vertx.rxDeployVerticle(FeedVerticle.class.getName(),
                        new DeploymentOptions().setConfig(configuration)))
                        .toCompletable()

        ).subscribe(() -> {
            LOGGER.info("Super 11 application has been deployed successfully.");
            startFuture.complete();
        }, throwable -> {
            LOGGER.error("Super 11 has not been deployed due to: ", throwable);
            startFuture.fail(throwable);
        });
    }
}
