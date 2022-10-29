package onboarding

fun solution2(cryptogram: String): String {

    var Result = cryptogram
    var Removed = true

    while (Removed){

        val remove_Text = mutableListOf<Pair<Int, Int>>()

        var Start_idx = -1
        var End_idx = -1
        var Flag = false
        var Cnt = 0

        var Last_Text = ' '

        //큐 생성
        Result.forEachIndexed { idx, ch ->
            if (Last_Text == ch) {
                End_idx = idx
                Flag = true
            } else {
                if (Flag)
                    remove_Text.add(Pair(Start_idx, End_idx))
                Flag = false
                Start_idx = idx
                Last_Text = ch
            }
        }

        if (Flag)
            remove_Text.add(Pair(Start_idx, End_idx))

        remove_Text.forEach{
            //일치하는 텍스트 삭제 시작idx에서 끝 idx까지
//            for (i in it.first - Cnt..it.second - Cnt +1)
//                Result = Result.replace("") -> replace가 안먹힘

            //replaceRange 사용
            Result = Result.replaceRange(it.first - Cnt, it.second - Cnt +1,"")
            Cnt += it.second - it.first +1
        }

        //큐가 비었는지 확인
        Removed = remove_Text.isNotEmpty()

    }

    return Result
}
