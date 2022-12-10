package onboarding

fun solution2(cryptogram: String): String {
    var mList = cryptogram.splitToList()
    while (!checkSame(mList).first) { //연달아서 있는 중복값이 있는 동안 실행
        mList.reduceSame(checkSame(mList).second) //연달아서 있는 중복값 제거하는 함수
    }
    return mList.joinToString("") //배열값으로 변환했으므로, 다시 String으로 변환하고, 그 과정에서 생기는 , 그리고 " " 값을 제거한다.
}

private fun String.splitToList() : MutableList<String> = split("").filter { it != "" }.toMutableList()

/**
 * 연달아서 있는 중복 값이 있는지 검사하는 함수
 */
private fun checkSame(list: MutableList<String>): Pair<Boolean, Int> {
    var last = "" //최초 실행시에도 1번 항목이 공백일 수는 없으므로, 공백으로 설정
    for (i in list.indices) {
        if (list[i] == last) { //현재 값이, 이전 값과 같을 시, 즉 연달아 있는 중복값이 있을 시 if문 내부 실행
            return Pair(false, i)
        }
        last = list[i] //if문이 돌지 않았다는 뜻은 현재 값이 연달아 있는 중복값이 아니므로, 다음 아이템 체크를 위해 last 값 변경
    }
    return Pair(true, 1000) //전부 돌았음에도 중복값이 없어야 도달할 수 있으므로 최종적으로 true 반환
}


private fun MutableList<String>.reduceSame (startIdx : Int) : MutableList<String> {
    var last = this[startIdx - 1]
    var mCurIdx = startIdx
    while(mCurIdx < this.size && this[mCurIdx] == last) {
        last = this[mCurIdx]
        mCurIdx++
    }
    return this.returnReducedList(startIdx, mCurIdx)
}

private fun MutableList<String>.returnReducedList(startIdx: Int, curIdx : Int) : MutableList<String> {
    return this.apply {
        for (i in startIdx - 1 until curIdx) {
            this.removeAt(startIdx - 1)
        }
    }
}