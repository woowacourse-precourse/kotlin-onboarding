package onboarding

fun solution3(number: Int): Int {

    var claps = 0

    for (i in 1..number)
    {
        var next = i

        while (next>=1){
            if ((next%10==3) or (next%10==6) or (next%10==9)){
                claps += 1
            }
            next /= 10
        }

    }

    return claps
}
