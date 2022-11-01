package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for (i in 1..number){
        var j = i
        while(j > 0){
            if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9){
                count++
                break
            }
            j = (j / 10).toInt()
        }
    }
    return count
}
