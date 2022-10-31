package onboarding

/**
 * Solution Algorithm
 *
 * 1. 이전 문자열과 현재 문자열이 같지 않을 때까지 반복
 * 2. 문자열을 끝까지 순회하면서 중복되는 문자의 인덱스를 저장
 * 3. 중복 문자 인덱스 삭제
 * 4. 1~3 과정 반복
 * 5. 리스트를 문자열로 변경, 반환
 *
 * @author @ponopono0322
 * @param cryptogram 변경할 문자열
 * @return 추천 사용자 목록
 */
fun solution2(cryptogram: String): String {
    // 문자열을 배열로 변경해서 사용
    val answer = cryptogram.split("").toMutableList()
    var changed = true      // 문자열이 변경되었는지 확인하는 용도

    while (changed) {
        var before:String? = null   // 이전 문자
        changed = false             // 초기화 해주기
        val tmpList = mutableListOf<Int>()      // 동일한 문자 인덱스 저장 배열
        val indexList = mutableListOf<Int>()    // 2개 이상의 동일 문자 인덱스 임시 저장 배열

        for (i in 0 until answer.size) {
            if (before == answer[i]) {
                indexList.add(i)        // 동일한 경우 리스트에 추가
            }
            else {
                if (indexList.size > 1) // 동일 문자가 생겼으므로
                    tmpList.addAll(indexList)
                indexList.clear()       // 배열 초기화
                indexList.add(i)        // 추가
            }

            before = answer[i]          // 이전 문자로 변경
        }
        // 중복된 문자가 있다면 리스트 비워주면서 없애주기
        while (tmpList.isNotEmpty()) {
            val t = tmpList[tmpList.size-1]
            answer.removeAt(t)
            tmpList.removeAt(tmpList.size-1)
            changed = true
        }

    }

    return answer.joinToString(separator = "")
}
