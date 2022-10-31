package onboarding
val arr=arrayOf('3','6','9')

fun solution3(number: Int): Int {
    var count=0

    for(i in 3 .. number){
        for(j in i.toString()){
            if(arr.contains(j)){
                count++
            }
        }
    }

    return count

}

