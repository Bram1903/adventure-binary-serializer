package com.deathmotion.adventure.serializer.binary;

import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class ComponentTest {

    public void test(Component component) {
        try {
            byte[] serialized = BinaryComponentSerializer.binary().serialize(component);
            Component result = BinaryComponentSerializer.binary().deserialize(serialized);

            Assertions.assertEquals(component, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
