package org.demo.akka.process;

import akka.NotUsed;
import akka.stream.alpakka.slick.javadsl.Slick;
import akka.stream.alpakka.slick.javadsl.SlickRow;
import akka.stream.alpakka.slick.javadsl.SlickSession;
import akka.stream.javadsl.Source;

public class SourceFromDb {

    private static final SlickSession session = SlickSession.forConfig("demo-db");

    public Source<Card, NotUsed> source() {
        return Slick.source(session, "select name, artist, text from card_fts.card",
                (SlickRow row) -> new Card(row.nextString(), row.nextString(), row.nextString()));
    }
}
