/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2022 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.deathmotion.adventure.serializer.binary;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.nbt.CompoundBinaryTag;
import net.kyori.adventure.nbt.StringBinaryTag;
import net.kyori.adventure.nbt.TagStringIO;
import net.kyori.adventure.nbt.api.BinaryTagHolder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.kyori.adventure.text.format.Style;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ShowItemSerializerTest extends ComponentTest {
    private static final Key item = Key.key("minecraft", "diamond");

    @Test
    void testDeserializeWithPopulatedTag() throws IOException {
        CompoundBinaryTag compound = CompoundBinaryTag.builder()
                .put("display", CompoundBinaryTag.builder()
                        .put("Name", StringBinaryTag.stringBinaryTag("A test!"))
                        .build())
                .build();

        BinaryTagHolder tag = BinaryTagHolder.binaryTagHolder(TagStringIO.get().asString(compound));

        HoverEventSource<?> hoverEvent = HoverEvent.showItem(item, 1, tag);

        this.test(
                Component.text("ajshd").style(Style.style().hoverEvent(hoverEvent).build())
        );
    }

    @Test
    void testDeserializeWithNullTag() {
        HoverEventSource<?> hoverEvent = HoverEvent.showItem(item, 1);

        this.test(
                Component.text("jhas9").style(Style.style().hoverEvent(hoverEvent).build())
        );
    }
}

