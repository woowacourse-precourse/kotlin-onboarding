package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")

    var Result = cryptogram

    var Start_idx = -1
    var End_idx = -1
    var Flag = false
    var Last_Char = ' '
    var Remove = 0

    while (true){
        val remove_text = mutableListOf<Pair<Int, Int>>()
        Result.forEachIndexed { idx, ch ->
            if (Last_Char == ch) {
                End_idx = idx
                Flag = true
            } else if (Flag) {
                remove_text.add(Pair(Start_idx, End_idx))
                Flag = false
                Start_idx = idx
                Last_Char = ch
            }
        }
        if (Flag) {
            remove_text.add(Pair(Start_idx, End_idx))
        }

        remove_text.forEach{
            Result = Result.replaceRange(it.first - Remove, it.second - Remove +1,"")
            Result += it.second -it.second +1
        }

       if (remove_text.isEmpty())
           break
    }

    return Result
}
