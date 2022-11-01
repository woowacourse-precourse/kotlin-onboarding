package onboarding

fun solution2(cryptogram: String): String {
    for(i in cryptogram.indices){
        if(!isLowerCase(cryptogram[i]))
            throw IllegalArgumentException("invalid input found!")
    }

    var currCrypto = cryptogram
    while (currCrypto != removeDuplication(currCrypto))
        currCrypto = removeDuplication(currCrypto)

    return currCrypto
}

fun removeDuplication(cryptogram: String): String {
    val regax = Regex("(\\w)\\1+")
    return regax.replace(cryptogram, "")
}

fun isLowerCase(char: Char): Boolean{
    return char.isLowerCase()
}
