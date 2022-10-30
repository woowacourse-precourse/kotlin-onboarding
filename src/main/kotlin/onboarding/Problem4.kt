package onboarding

fun solution4(word: String): String {
    var result = ""
    //word 리스트로 변환
    var wordList = word.split("").toMutableList()
    wordList.removeAt(wordList.size-1)
    wordList.removeAt(0)

    for (i in (0 until wordList.size)){
        //빈칸일 때
        if (wordList[i] == " "){
            result += " "
            continue
        }

    }

    return result
}
