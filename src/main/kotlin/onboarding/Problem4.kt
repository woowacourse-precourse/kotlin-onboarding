package onboarding

fun solution4(word: String): String {
    //각 문자에 대응하는 문자를 map 구조로 저장
    val smallLetterMap:Map<Char,Char> = mapOf('a' to 'z','b' to 'y','c' to 'x','d' to 'w','e' to 'v',
            'f' to 'u','g' to 't','h' to 's','i' to 'r','j' to 'q', 'k' to 'p','l' to 'o','m' to 'n','n' to 'm','o' to 'l','p' to 'k',
            'q' to 'j','r' to 'i','s' to 'h','t' to 'g','u' to 'f','v' to 'e','w' to 'd','x' to 'c',
            'y' to 'b','z' to 'a')
    val bigLetterMap:Map<Char,Char> = mapOf('A' to 'Z','B' to 'Y','C' to 'X','D' to 'W','E' to 'V',
            'F' to 'U','G' to 'T','H' to 'S','I' to 'R','J' to 'Q', 'K' to 'P','L' to 'O','M' to 'N','N' to 'M','O' to 'L','P' to 'K',
            'Q' to 'J','R' to 'I','S' to 'H','T' to 'G','U' to 'F','V' to 'E','W' to 'D','X' to 'C',
            'Y' to 'B','Z' to 'A')

    var answer:String=""
    if(word.length==0){ //문자가 공백이라면 "" 리턴
        return ""
    }


    for(i in 0 until word.length){
        if(word[i].isUpperCase()){ //대문자일 경우
            answer+=bigLetterMap.get(word[i]) //key 값에 맞는 value
        }
        else if(word[i].isLowerCase()){ //소문자일 경우
            answer+=smallLetterMap.get(word[i])
        }
        else{ //그 외의 경우는 그대로 출력
            answer+=word[i]
        }
    }
    return answer
}
