package onboarding

const val cr=25

fun solution4(word: String): String {
    var newWord=""
    var aA=' '

    for(i in word){
        if(i in 'a'..'z'){
            aA='a'
        }else if( i in 'A'..'Z'){
            aA='A'
        }else{
            newWord+=i
            continue
        }

        newWord+=i+cr-(i-aA)*2
    }
    return newWord
}
