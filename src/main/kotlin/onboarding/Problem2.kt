package onboarding

fun solution2(cryptogram: String): String {
    var cryp = cryptogram
    var check=false //0 문제없음 1 문제있음
    if(cryptogram==""){//cryptogram이 비어있을 때
        println("input cryptogram : ")
        cryp = readLine().toString()
    }

    do{//문자열 체크 및 수정
        var chka:Char? = null
        var chkb:Char? = null
        val changetext ='\t'
        check = false
        for(i: Int in 0 until cryp.length-1){
            chka=chkb
            if(chka==null){//처음(0)일 경우
                chka=cryp[i]//0번째 문자
            }
            chkb=cryp[i+1]//i+1번째 문자
            if(chka==chkb){//비교
                check=true//수정 발생
                val text = cryp.toCharArray()
                text[i]=changetext
                text[i+1]=changetext
                cryp=String(text) //양쪽다 공백을 넣는 것으로 나중에 수정
            }
        }

        if(check){
            cryp=cryp.replace("\t","")
        }


    }while(check)

    return cryp
}

