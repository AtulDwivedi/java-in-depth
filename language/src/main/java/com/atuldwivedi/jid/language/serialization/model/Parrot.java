package com.atuldwivedi.jid.language.serialization.model;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Parrot extends Bird {
    String sound;

    public Parrot(int averageAge, String sound) {
        super(averageAge);
        this.sound = sound;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException();
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new NotSerializableException();
    }
}
