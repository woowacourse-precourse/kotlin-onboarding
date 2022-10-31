package onboarding

import java.lang.StringBuilder

fun solution4(word: String): String {
    return "${convertWord(word)}"
}

fun convertWord(word: String): StringBuilder{

    val newWord = StringBuilder(word)

    val azList: List<Char> =
        listOf('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
    val zaList: List<Char> =
        listOf('z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a',
        'Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C','B','A')

    for(i in word.indices){
        val index = azList.indexOf(word[i])
        if(index == -1){
            continue
        }
        newWord[i] = zaList[index]
    }
    return  newWord
}