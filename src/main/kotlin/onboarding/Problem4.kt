package onboarding

fun solution4(word: String): String {
    var result = ""
    word.forEach {
        result+= reverse(it)
    }
    return result
}
fun main(){
    println(solution4("I love you"))
}
fun reverse(c:Char):Char{
    if(c.code>=65 && c.code<=122){
        if(c.isLowerCase()){
            return (122- (c.code-97)).toChar()
        }else{
            return(90-(c.code-65)).toChar()
        }
    }

    return c
}