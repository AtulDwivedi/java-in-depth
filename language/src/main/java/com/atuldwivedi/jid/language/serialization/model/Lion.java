package com.atuldwivedi.jid.language.serialization.model;

import java.io.Serializable;

public class Lion extends Animal implements Serializable {
    String sound;

    public Lion(int averageAge, String sound) {
        super(averageAge);
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Lion{" +
                "sound='" + sound + '\'' +
                ", averageAge=" + averageAge +
                '}';
    }
}
