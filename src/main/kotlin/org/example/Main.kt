package org.example

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.types.int
import java.io.File

fun readFile(filename: String): String = File(filename)
    .inputStream()
    .readBytes()
    .toString(Charsets.UTF_8)

class Cli : CliktCommand() {
    val filename by option("-f", "--filename", help = "Path to input file)").required()
    val cipher by option("-c", "--cipher", help = "Cipher to shift characters by").int().required()
    val decode by option("-d", "--decode", help = "Whether to decode").flag(default = false)

    override fun run() {
        val text = readFile(filename)
        val encoder = CaesarCipher(cipher)
        if (!decode) {
            val enc = encoder.encode(text)
            println(enc)
        } else {
            val dec = encoder.decode(text)
            println(dec)
        }
    }
}

fun main(args: Array<String>) = Cli().main(args)
