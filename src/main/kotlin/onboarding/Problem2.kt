package onboarding

/* Remove consecutive duplicates from the string*/
fun solution2(cryptogram: String): String {
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
    return ret.toString()
}