package org.example

fun main() {
    val text = "abcdefghijklmnopqrstuvwxyzæøå randomTEXT RANDOMtext ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ"
    println("Text: \n" + text)
    val encoder = CaesarCipher(3)
    val encoded_text = encoder.encode(text)
    val decoded_text = encoder.decode(encoded_text)
    println("Encoded text: \n" + encoded_text)
    println("Decoded text: \n" + decoded_text)
}
