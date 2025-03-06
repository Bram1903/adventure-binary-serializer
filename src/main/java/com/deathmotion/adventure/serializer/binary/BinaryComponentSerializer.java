package com.deathmotion.adventure.serializer.binary;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * A serializer for converting {@link Component} objects to and from binary format.
 */
public sealed interface BinaryComponentSerializer permits BinaryComponentSerializerImpl {

    /**
     * Returns a default instance of the {@link BinaryComponentSerializer}.
     *
     * @return a {@link BinaryComponentSerializer} instance.
     */
    static @NotNull BinaryComponentSerializer binary() {
        return BinaryComponentSerializerImpl.INSTANCE;
    }

    /**
     * Serializes a {@link Component} into a byte array.
     *
     * @param component the component to serialize
     * @return a byte array containing the serialized component
     * @throws IOException if an I/O error occurs
     */
    byte @NotNull [] serialize(@NotNull Component component) throws IOException;

    /**
     * Deserializes a {@link Component} from a byte array.
     *
     * @param bytes the byte array to deserialize
     * @return the deserialized {@link Component}
     * @throws IOException if an I/O error occurs
     */
    @NotNull Component deserialize(byte @NotNull [] bytes) throws IOException;

    /**
     * Serializes a {@link Component} into a {@link DataOutputStream}.
     *
     * @param component the component to serialize
     * @param output    the output stream to write to
     * @throws IOException if an I/O error occurs
     */
    void serialize(@NotNull Component component, @NotNull DataOutputStream output) throws IOException;

    /**
     * Deserializes a {@link Component} from a {@link DataInputStream}.
     *
     * @param input the input stream to read from
     * @return the deserialized {@link Component}
     * @throws IOException if an I/O error occurs
     */
    @NotNull Component deserialize(@NotNull DataInputStream input) throws IOException;
}
