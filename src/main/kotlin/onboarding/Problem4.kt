package onboarding

fun solution4(word: String): String {
    var result = ""
    for(i in word){
        if(i.isUpperCase()){
            result=result.plus((27-((i
                .uppercaseChar().code)-64)+64)
                .toChar().toString())
        }
        else if(i.isLowerCase()){
            result=result.plus((27-((i.lowercaseChar().code)-96)+96).toChar().toString())
        }
        else if(!i.isLowerCase() && !i.isUpperCase()){
            result=result.plus(i)
        }
    }
    return result
}
