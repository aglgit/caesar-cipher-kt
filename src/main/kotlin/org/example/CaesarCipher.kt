package org.example

class CaesarCipher(val cipher: Int) {

    val numAlphabet: Int = 29
    val lowerAlphabet = "abcdefghijklmnopqrstuvwxyzæøå"
    val lowerNorwegianMap: HashMap<Char, Int>
    val lowerNorwegianInvMap: HashMap<Int, Char>
    val upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ"
    val upperNorwegianMap: HashMap<Char, Int>
    val upperNorwegianInvMap: HashMap<Int, Char>

    init {
        var counter = 0
        lowerNorwegianMap = lowerAlphabet.toCharArray()
            .associateWith { counter++ } as HashMap<Char, Int>
        lowerNorwegianInvMap = lowerNorwegianMap.entries
            .associate { (k, v) -> v to k } as HashMap<Int, Char>

        counter = 0
        upperNorwegianMap = upperAlphabet.toCharArray()
            .associateWith { counter++ } as HashMap<Char, Int>
        upperNorwegianInvMap = upperNorwegianMap.entries
            .associate { (k, v) -> v to k } as HashMap<Int, Char>
    }

    fun encode(text: String): String {
        return text.toCharArray()
            .map { shiftChar(it, this.cipher) }
            .joinToString("")
    }

    fun decode(text: String): String {
        return text.toCharArray()
            .map { shiftChar(it, -this.cipher) }
            .joinToString("")
    }

    fun shiftChar(char: Char, shift: Int): Char? {
        lowerNorwegianMap[char]?.let {
            val index = shiftIndex(it, shift)
            return lowerNorwegianInvMap[index]
        }
        upperNorwegianMap[char]?.let {
            val index = shiftIndex(it, shift)
            return upperNorwegianInvMap[index]
        }
        return char
    }

    fun shiftIndex(index: Int, shift: Int): Int {
        return (index + shift).mod(numAlphabet)
    }

}
