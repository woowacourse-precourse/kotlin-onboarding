package onboarding

fun solution2(cryptogram: String): String {
    var word=cryptogram;
    var condition=true;
    while(condition){
        var len=word.length
        if(len==0 || len==1){
            break
        }
        for(i in 1..len-1){
            if(word[i-1]==word[i]){
                var sub1=word.substring(0,i-1);
                var sub2=word.substring(i+1,len);
                word=sub1+sub2;
                break
            }
            if(i==len-1){
                if(word[i-1]!=word[i]){
                    condition=false
                }
            }
        }
    }
    return word
}
