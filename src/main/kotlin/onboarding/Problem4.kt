package onboarding

import java.lang.StringBuilder

fun solution4(word: String): String {
    //TODO("프로그램 구현")
    var str : StringBuilder = StringBuilder(word)


    for (j in 1..word.length)
    {
        if ( (word[j].code >= 65 && word[j].code <= 77) || (word[j].code >= 97 && word[j].code <= 109) )
        {
            for (i in 25 downTo 1 step(2) ) {
                if (word[j].code ==65+i)
                {
                    str[j] = str[j + i]
                }
            }
        }
        else if ( (word[j].code >= 78 && word[j].code <= 90 ) || (word[j].code >= 110 || word[j].code <= 122))
        {
            for (i in 1..25 step(2))
            {
                if (word[j].code ==78-i)
                {
                    str[j] = str[j - i]
                }
            }
        }
    }
 return str
}