package org.demo.akka;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import org.demo.akka.process.Item;
import org.demo.akka.process.SinkConsole;
import org.demo.akka.process.SourceFromDb;

import java.util.concurrent.CompletionStage;

public class StreamJdbcApp {

    public static void main( String[] args ) {

        ActorSystem system = ActorSystem.create("akka-stream-db");

        Source<Item, NotUsed> itemsrc = new SourceFromDb().source();

        Sink<Item, CompletionStage<Done>> sink = new SinkConsole().sink();

        RunnableGraph<NotUsed> runnable = itemsrc.to(sink);

        ActorMaterializer materializer = ActorMaterializer.create(system);

        runnable.run(materializer);
    }
}

// Source fetch value DB - Alpakka
// Sink print value in console