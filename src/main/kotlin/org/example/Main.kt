package org.example

import java.io.File

// TODO: Complete CLI using Clikt
// https://github.com/ajalt/clikt/tree/master
// read in filename, cipher, decode flag
fun main() {
    val text = readFile("input/input.txt")
    println("Text: \n$text")
    val encoder = CaesarCipher(3)
    val encodedText = encoder.encode(text)
    val decodedText = encoder.decode(encodedText)
    println("Encoded text: \n$encodedText")
    println("Decoded text: \n$decodedText")
}

fun readFile(filename: String): String = File(filename)
    .inputStream()
    .readBytes()
    .toString(Charsets.UTF_8)
