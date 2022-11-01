package onboarding

fun solution3(number: Int): Int {
    //TODO("프로그램 구현")
    var ret = 0
    for (i in 1..number)
    {
        var num_s = i.toString()
        for (k in 0..(num_s.length-1))
            if (num_s[k].digitToInt() % 3 == 0 && num_s[k].digitToInt() != 0)
                ret++
    }
    return(ret)
}
