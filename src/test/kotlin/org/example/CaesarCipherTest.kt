package org.example

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
class CaesarCipherTest {

    @Test
    fun encode_givenCipher_encodesCorrectly() {
        val cipher = CaesarCipher(3)
        val text = "abcdefxyzæøåABCDEFXYZÆØÅ"
        assertEquals("defghiæøåabcDEFGHIÆØÅABC", cipher.encode(text))
    }

    @Test
    fun encode_givenCipherLargerThanNumAlphabet_encodesCorrectly() {
        val cipher = CaesarCipher(5*29+3)
        val text = "abcdefxyzæøåABCDEFXYZÆØÅ"
        assertEquals("defghiæøåabcDEFGHIÆØÅABC", cipher.encode(text))
    }

    @Test
    fun decode_givenCipher_decodesCorrectly() {
        val cipher = CaesarCipher(3)
        val text = "defghiæøåabcDEFGHIÆØÅABC"
        assertEquals("abcdefxyzæøåABCDEFXYZÆØÅ", cipher.decode(text))
    }

    @Test
    fun decode_givenCipherLargerThanNumAlphabet_decodesCorrectly() {
        val cipher = CaesarCipher(5*29+3)
        val text = "defghiæøåabcDEFGHIÆØÅABC"
        assertEquals("abcdefxyzæøåABCDEFXYZÆØÅ", cipher.decode(text))
    }

    @Test
    fun encode_thenDecode_producesCorrectText() {
        val cipher = CaesarCipher(3)
        val text = "abcdefxyzæøåABCDEFXYZÆØÅ"
        assertEquals(text, cipher.decode(cipher.encode(text)))
    }

}