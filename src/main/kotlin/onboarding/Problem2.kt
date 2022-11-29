package onboarding

fun solution2(cryptogram: String): String {
    var mList = cryptogram.split("").filter { it != "" } //String을 개별 문자별로 비교하기 편하도록 List로 변환하며, 맨 앞 뒤 항목들 역시 공백의 배열로 추가되므로, filter 사용하여 제거했다.
    while (!checkSame(mList).first) { //연달아서 있는 중복값이 있는 동안 실행
        mList = reduceSame(mList, checkSame(mList).second) //연달아서 있는 중복값 제거하는 함수
    }
    return mList.joinToString().replace(",", "").replace(" ", "") //배열값으로 변환했으므로, 다시 String으로 변환하고, 그 과정에서 생기는 , 그리고 " " 값을 제거한다.
}

/**
 * 연달아서 있는 중복 값이 있는지 검사하는 함수
 */
private fun checkSame(list: List<String>): Pair<Boolean, Int> {
    var last = "" //최초 실행시에도 1번 항목이 공백일 수는 없으므로, 공백으로 설정
    for (i in list.indices) {
        if (list[i] == last) { //현재 값이, 이전 값과 같을 시, 즉 연달아 있는 중복값이 있을 시 if문 내부 실행
            return Pair(false, i)
        }
        last = list[i] //if문이 돌지 않았다는 뜻은 현재 값이 연달아 있는 중복값이 아니므로, 다음 아이템 체크를 위해 last 값 변경
    }
    return Pair(true, 1000) //전부 돌았음에도 중복값이 없어야 도달할 수 있으므로 최종적으로 true 반환
}

/**
 * 연달아서 있는 중복 값을 제거하는 함수
 */
 /* private fun reduceSame(list: List<String>): List<String> {
    val mList = list.toMutableList() //값의 변경이 있으므로, 새로 지정해주었고 (파라미터로 들어오는 값은 val이므로), 제거를 위해 removeAt을 사용하기 위해 mutableList로 변환해주었다.
    var last = ""
    for (i in mList.indices) {
        if (mList[i] == last) {
            mList.removeAt(i) //이 if문이 동작한다는 말은 현재 값과 이전 값이 중복이라는 말이므로, 현재 값과 이전 값을 List에서 제거 후 반환한다.
            mList.removeAt(i)
            return mList
        }
        last = mList[i]
    }
    return mList
} */

private fun reduceSame (list : List<String>, startIdx : Int) : List<String> {
    val mList = list.toMutableList()
    var last = list[startIdx - 1]
    var mCurIdx = startIdx
    while(mCurIdx < list.size && list[mCurIdx] == last) {
        last = list[mCurIdx]
        mCurIdx++
    }
    return returnReducedList(startIdx, mCurIdx, mList)
}

private fun returnReducedList(startIdx: Int, curIdx : Int, list : MutableList<String>) : MutableList<String> {
    return list.apply {
        for (i in startIdx - 1 until curIdx) {
            this.removeAt(startIdx - 1)
        }
    }
}