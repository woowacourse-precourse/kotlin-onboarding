package onboarding

fun solution4(word: String): String {
    var temp = word
    for(i in 0 until temp.length){
        if(temp[i]>='a' && temp[i]<='z'){
            var num:Int = 'z' - temp[i]
            val char = ('a' + num).toChar()
            temp = temp.substring(0,i) + char + temp.substring(i+1)
        }
        else if(temp[i]>='A' && temp[i]<='Z'){
            var num:Int = 'Z' - temp[i]
            val char = ('A'+ num).toChar()
            temp = temp.substring(0,i) + char + temp.substring(i+1)
        }
    }
    return temp
}
