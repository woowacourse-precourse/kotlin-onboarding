package onboarding

fun solution2(cryptogram: String): String {
    val cryptoList = cryptogram.chunked(1)
    var mutableList = mutableListOf(cryptoList[0])  //list의 0번 값을 갖는 가변리스트 생성

    //cryptoList의 원소 값을 가변 리스트의 마지막 값과 비교
    for (i in 1 until cryptoList.size)
    {
        //마지막 값과 같으면 가변 리스트 removeLast
        if (mutableList.last() == cryptoList[i]) {
            mutableList.removeLast()
            continue
        }

        //그렇지 않으면 추가
        mutableList.add(cryptoList[i])
    }

    return mutableList.joinToString("")
}
