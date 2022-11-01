package onboarding


fun solution2(cryptogram: String): String {

    // cryptogram의 길이가 1이라면 바로 cryptogram을 return 해준다
    if (cryptogram.length == 1){
        return cryptogram
    }

    else{
        // string을 리스트로 변환
        val cList: List<Char> = cryptogram.toList()
        val cryptoList = cList.toMutableList()

        // 인덱스 변수 생성
        var start = 0
        while (start < cryptoList.size) {
            var end = start + 1

            if (end >= cryptoList.size){
                break
            }
            // 현재 알파벳이 이웃과 중복이라면
            if ( cryptoList[start] == cryptoList[end] ){
                for (i in end .. cryptoList.size - 1){
                    // 중복이 어디까지인지 확인
                    if (cryptoList[start] == cryptoList[i]){
                        // end 인덱스를 마지막 중복까지 업데이트
                        end = i
                        continue
                    }else{
                        break
                    }
                }
                // 중복된 알파벳을 삭제시킨다
                for (i in end downTo start){
                    cryptoList.removeAt(i)
                }
                start = 0
            }
            // 중복되지 않는다면 다음 알파벳 확인
            else{
                start += 1
            }
        }
        return cryptoList.joinToString(separator = "")
    }//end of else
}
