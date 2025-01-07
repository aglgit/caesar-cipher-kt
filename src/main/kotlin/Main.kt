package org.example

// TODO: Complete CLI using Clikt
// https://github.com/ajalt/clikt/tree/master
// read in filename, cipher, decode flag
fun main() {
    val text = "abcdefghijklmnopqrstuvwxyzæøå randomTEXT RANDOM%&/(#text ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ"
    println("Text: \n" + text)
    val encoder = CaesarCipher(3)
    val encoded_text = encoder.encode(text)
    val decoded_text = encoder.decode(encoded_text)
    println("Encoded text: \n" + encoded_text)
    println("Decoded text: \n" + decoded_text)
}
