package onboarding

fun solution4(word: String): String {

    var lookupTable = Lut()

    return changeAlphabet(word,lookupTable)

}

fun Lut(): HashMap<Char, Char> { //룩업테이블을 만들어주는 함수

    var lukupTable = HashMap<Char, Char>()

    for (i in 0..25)//룩업테이블 활용

    {
        lukupTable.put('\u0061' + i, '\u007A' - i)  //a = z 부터 z = a 까지 값 저장
    }

    for (i in 0..25)//룩업테이블 활용

    {
        lukupTable.put('\u0041' + i, '\u005A' - i) //A = Z 부터 Z ==A 까지 값 저장
    }

    return lukupTable

}

fun changeAlphabet(word : String ,lookupTable :HashMap<Char,Char>): String { //문자에서 룩업테이블의 값이 있는지 확인해서 변환해주는 함수

    var result = ""

    for (i in word.indices) { //문자열 길이만큼 반복

        var char: Char = word[i]

        if (char in '\u0061'..'\u007A' || char in '\u0041'..'\u005A') { //만약 알파벳이면 룩업테이블을 활용해서 변환

            result += (lookupTable.get(char)).toString()

        }

        if (lookupTable.get(char) == null) {//만약 알파벳이 아니면 그대로 저장

            result += word[i].toString()

        }

    }

    return result

}