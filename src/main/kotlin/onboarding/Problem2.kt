package onboarding

fun solution2(cryptogram: String): String {
    var C_list = cryptogram.chunked(1)
    var middle : Int = C_list.indices
    for (j in C_list.indices){
        if (C_list.indices ==  middle){
            for (i in C_list.indices){
                middle = C_list.indices
                if (C_list[i-1]==C_list[i]){
                    C_list.removeAt(i)
                    C_list.removeAt(i-1)
                }
                else{
                    break
                }
                i++
            }
            j++
        }
        else{
            break
        }
    }
    C_list.toString(cryptogram)
    return cryptogram

}
