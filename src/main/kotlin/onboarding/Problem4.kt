package onboarding

import java.lang.StringBuilder

fun solution4(word: String): String {
    //TODO("프로그램 구현")
    var str : StringBuilder = StringBuilder(word)
    val bigarray1: List<String> = listOf("A","B","C","D","E","F","G","H","I","J","K","L","M")
    val bigarray2: List<String> = listOf("Z","Y","X","W","V","U","T","S","R","Q","P","O","N")
    val smallarray1: List<String> = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m")
    val smallarray2: List<String> = listOf("z","y","x","w","v","u","t","s","r","q","p","o","n")
    var str2 : StringBuilder = StringBuilder()

    var count = 0
    println(str2)

    for(i in 0..str.length-1)
    {
        count=0
        for (j in 0..bigarray1.size-1)
        {
            if (str[i].toString() == bigarray1[j])
            {
                str2.append(bigarray2[j])
                count+=1
            }
            else if (str[i].toString() == bigarray2[j])
            {
                str2.append(bigarray1[j])
                count+=1
            }
            else if (str[i].toString() == smallarray1[j])
            {
                str2.append(smallarray2[j])
                count+=1
            }
            else if (str[i].toString() == smallarray2[j])
            {
                str2.append(smallarray1[j])
                count+=1
            }
        }
        if (count==0)
        {
            str2.append(str[i])
        }
    }

    return str2.toString()
}