package onboarding

fun solution2(cryptogram: String): String {
    //TODO("프로그램 구현")
   // var temp :arrayOf<Char?> = cryptogram.toCharArray()
    var char = arrayOfNulls<Char>(cryptogram.length)
    for( i in cryptogram.indices)
        char[i] = cryptogram[i]
    var check : Boolean = false
    var howmanytimes : Int = char.size-2

    while(!check){
        check = true
        for(i : Int in 0..howmanytimes){
            if(char[i] == char[i+1]){
                check = false
                for(j : Int in i+2..howmanytimes+1){
                    char[j-2] = char[j]
                }
                var newchar = arrayOfNulls<Char>(howmanytimes)
                for(j : Int in 0..howmanytimes-1){
                    newchar[j] = char[j]
                }

                char = newchar
                howmanytimes = howmanytimes - 2
                break
            }
        }
    }
    val answer = char.joinToString("")

    return answer
}

