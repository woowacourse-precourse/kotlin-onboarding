package onboarding

fun solution4(word: String): String {// A=65~90 a=97~122 26문자
    var changedtext=word.toCharArray()


    for(i: Int in 0 until word.length){
       changedtext[i]=change(changedtext[i])
    }

    var CtS = String(changedtext)

    return CtS
}



fun change(a:Char):Char {
    var i=a.toInt()
    if(i<=90&&i>=65){//대문자일경우
            i-=65
            i=25-i
            i+=65

            return i.toChar()
    }
    if(i>=97&&i<=122){//소문자일경우
        i-=97
        i=25-i
        i+=97


        return i.toChar()
    }

    return i.toChar()//그 외는 그대로 반환
    
}
