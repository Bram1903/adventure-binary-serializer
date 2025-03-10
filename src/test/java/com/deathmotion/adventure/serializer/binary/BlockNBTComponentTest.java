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

import net.kyori.adventure.text.BlockNBTComponent;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Test;

class BlockNBTComponentTest extends ComponentTest {
    @Test
    void testLocal() {
        this.test(
                Component.blockNBT().nbtPath("abc").localPos(1.23d, 2.0d, 3.89d).build()
        );
    }

    @Test
    void testAbsoluteWorld() {
        this.test(
                Component.blockNBT().nbtPath("xyz").absoluteWorldPos(4, 5, 6).interpret(true).build()
        );
    }

    @Test
    void testRelativeWorld() {
        this.test(
                Component.blockNBT().nbtPath("eeee").relativeWorldPos(7, 83, 900).build()
        );
    }

    @Test
    void testMixedAbsoluteAndRelative() {
        this.test(
                Component.blockNBT().nbtPath("qwert").worldPos(
                        BlockNBTComponent.WorldPos.Coordinate.absolute(12),
                        BlockNBTComponent.WorldPos.Coordinate.relative(3),
                        BlockNBTComponent.WorldPos.Coordinate.absolute(1200)
                ).build()
        );
    }
}

