package onboarding

fun solution4(word: String): String {
    var words=word.split(' ');
    var frogWord= ArrayList<Char>();

    for(i in words){
        for(j in i){
            if(j.isUpperCase()){
                frogWord.add((155-j.code).toChar());
            }else{
                frogWord.add((219-j.code).toChar());
            }
        }
        if(words[words.size-1]!=i){
            frogWord.add(' ');
        }
    }
    var result:String=frogWord.joinToString("");
    return result;
}
