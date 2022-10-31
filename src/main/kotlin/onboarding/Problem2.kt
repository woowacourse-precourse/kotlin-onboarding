package onboarding

fun solution2(cryptogram: String): String {
    //TODO("프로그램 구현")
    var ret = StringBuilder(cryptogram)
    var i : Int = 0;
    
    while(i < ret.length -1)
    {
        if (ret[i] == ret[i+1])
    {
            ret.deleteAt(i).toString()
            ret.deleteAt(i).toString()
            i = 0;
        }
        else
            i += 1;    
    }
    return (ret.toString());
}