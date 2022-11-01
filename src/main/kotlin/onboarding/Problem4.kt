package onboarding

fun solution4(word: String): String {
    var result = word
    for (i in 0..result.length - 1) {
        //아스키 코드로 사용
        var wordIndex = result[i].toInt()
        //대문자일 경우의 if문 ASCII 65~90
        if (result[i].toByte().toInt() >= 65 && result[i].toByte().toInt() <= 90) {
            //변환을 할때 A-Z순으로 추가 되는 값이 25시작으로 2씩 감소한다. ex)25-23-21....-1..-25
            //이것을 식으로 구한 upperCaseDifference
            var upperCaseDifference = (77 - wordIndex) * 2 + 1
            //각자리에 위에서 구한 식을 더하여 변환
            var replaceWords = result.replace(wordIndex.toChar(), wordIndex.toChar() + upperCaseDifference)
            //각 자리 인덱스 값으로 변환
            result = result.replaceRange(i..i, replaceWords[i].toString())

        }
        //소문자일 경우 if문 ASCII 97~122
        if (result[i].toInt() >= 97 && result[i].toInt() <= 122) {
            //변환을 할때 A-Z순으로 추가 되는 값이 25시작으로 2씩 감소한다. ex)25-23-21....-1..-25
            //이것을 식으로 구한 lowerCaseDifference
            var loweCaseDifference = (109 - wordIndex) * 2 + 1
            var replaceWords = result.replace(wordIndex.toChar(), wordIndex.toChar() + loweCaseDifference)
            result = result.replaceRange(i..i, replaceWords[i].toString())
        }

    }
    return result
}