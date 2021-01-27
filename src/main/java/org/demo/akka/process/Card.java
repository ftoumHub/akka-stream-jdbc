package org.demo.akka.process;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Card {

    private String name;
    private String artist;
    private String text;

}
