package onboarding
fun solution2(cryptogram: String): String {
    //TODO("프로그램 구현")
    var word = cryptogram;
    var hasDuplicate = true;

    while(hasDuplicate){
        var len = word.length
        for(i in 1 until len){
            if(word[i-1]==word[i]){
                var preWord = word.substring(0,i-1);
                var nextWord = word.substring(i+1,len);
                word = preWord + nextWord;
                if (word == "")
                    return word
                break
            }
            if(i==len-1) {
                if(word[i-1]!=word[i]){
                    hasDuplicate=false
                }
            }
        }
    }
    return word
}
