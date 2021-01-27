package org.demo.akka.process;

import akka.Done;
import akka.stream.javadsl.Sink;

import java.util.concurrent.CompletionStage;

public class SinkConsole {

    public Sink<Item, CompletionStage<Done>> sink() {
        return Sink.foreach(System.out::println);
    }
}
