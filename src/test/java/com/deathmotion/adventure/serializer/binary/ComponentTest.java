package com.deathmotion.adventure.serializer.binary;

import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Assertions;

public class ComponentTest {

    public void test(Component component) {
        byte[] serialized = BinaryComponentSerializer.binary().serialize(component);
        Component result = BinaryComponentSerializer.binary().deserialize(serialized);

        Assertions.assertEquals(component, result);
    }

}
