package onboarding

fun solution4(word: String): String {

    return flipTheAlphabet(word)
}
private fun flipTheAlphabet(word:String):String{
    var result = ""
    word.map {
        var count = 'z'.code - 'a'.code
        when(it) {
            in 'a'..'z' ->{
                for(i in 'a' ..'z') {
                    if(it==i){
                        result+= Char(it.code+count)
                    }
                    count-=2
                }
            }
            in 'A'..'Z'-> {
                for(i in 'A' ..'Z') {
                    if(it==i){
                        result+= Char(it.code+count)
                    }
                    count-=2
                }
            }
            else-> result+=" "
        }
    }
    return result
}
