package onboarding

/**
 * 기능목록
 * (1) 문자열을 한 자리씩 나누기
 * (2) 문자 하나씩 양 옆 문자와 겹치는 지 확인 후, 겹치지 않는 문자들을 조합한다
 * (3) 중복된 문자를 제거한 문자열이 검증 전 문자열과 일치할 때까지 (기능 1~2) 반복
 * **/
fun solution2(cryptogram: String): String {
    var prevWord = cryptogram //변환 전 단어
   var resultWord: String  //변환 후 단어

   resultWord = getRedundantWordRemoved(cryptogram)

   for(i in cryptogram.indices){
       if(prevWord==resultWord){ //변화 없을 때 => 종료
           break
       }
       prevWord = resultWord
       resultWord = getRedundantWordRemoved(prevWord)
   }

   return resultWord
}

private fun getRedundantWordRemoved(cryptogram: String): String{ //중복단어 제거
    val cryptoPiece = cryptogram.toList() //(1) 한 글자씩 분리
    var removedResult = "" //중복된 문자를 제외한 문자열
    for(i in 0..cryptoPiece.size-1){
        if((i == 0) && (cryptoPiece[i] != cryptoPiece[i+1])){ //첫번째 글자
            removedResult += cryptoPiece[i]
            continue
        }
        if((i==cryptoPiece.size-1) && cryptoPiece[i]!=cryptoPiece[i-1]){ //마지막 글자
            removedResult += cryptoPiece[i]
            continue
        }
        if(i>0 && i<cryptoPiece.size-1) {
            if ((cryptoPiece[i] != cryptoPiece[i+1]) && (cryptoPiece[i] != cryptoPiece[i-1])) {
                removedResult += cryptoPiece[i]
                continue
            }
        }
    }

    return removedResult
}
