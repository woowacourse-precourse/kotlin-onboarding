package onboarding

fun solution4(word: String): String {
    fun convertWord(word: String): String{
        var converted = ""
        for(i in word){
            if('a'.code <= i.code && i.code <= 'z'.code){
                converted += (219-i.code).toChar()
            }
            else if ('A'.code <= i.code && i.code <= 'Z'.code){
                converted += (155-i.code).toChar()
            }
            else{
                converted += " "
            }
        }


        return converted
    }
    return convertWord(word)
}
