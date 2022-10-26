package onboarding

fun solution2(cryptogram: String): String {
    var flag:Int = 1
    var str:String = cryptogram

    while(flag > 0){
        flag = 0
        for (i in 1..str.length-1) {
            if (str[i - 1] == str[i]) {
                flag++
                str = str.replaceRange(i-1..i, "  ")
            }
        }
        str = str.replace(" ", "")
    }
    return str
}
