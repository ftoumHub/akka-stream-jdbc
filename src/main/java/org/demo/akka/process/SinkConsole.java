package org.demo.akka.process;

import akka.Done;
import akka.stream.javadsl.Sink;

import java.util.concurrent.CompletionStage;

public class SinkConsole {

    public Sink<Card, CompletionStage<Done>> sink() {
        return Sink.foreach(System.out::println);
    }
}
