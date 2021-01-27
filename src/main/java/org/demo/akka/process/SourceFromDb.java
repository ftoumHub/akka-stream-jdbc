package org.demo.akka.process;

import akka.NotUsed;
import akka.stream.alpakka.slick.javadsl.Slick;
import akka.stream.alpakka.slick.javadsl.SlickRow;
import akka.stream.alpakka.slick.javadsl.SlickSession;
import akka.stream.javadsl.Source;

public class SourceFromDb {

    private static final SlickSession session = SlickSession.forConfig("demo-db");

    public Source<Item, NotUsed> source() {

        return Slick.source(session, "select id, name, description, price from items",
                (SlickRow row) -> new Item(row.nextInt(), row.nextString(), row.nextString(), row.nextDouble()));
    }
}
