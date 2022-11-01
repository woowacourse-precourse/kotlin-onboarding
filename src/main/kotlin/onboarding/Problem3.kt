package onboarding

fun solution3(number: Int): Int {
    var cntRes = 0

    for (i in 1 .. number){
        var Clap = i

        while (Clap != 0){
            if ((Clap%10)%3 == 0 && (Clap%10) != 0){
                cntRes++
            }
            Clap /= 10
        }

    }
    println(cntRes)

    return cntRes
}
