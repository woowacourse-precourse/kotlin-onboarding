package onboarding

fun solution2(cryptogram: String): String {
    var cryp = cryptogram
    var check:Int? //0 문제없음 1 문제있음
    if(cryptogram==""){//cryptogram이 비어있을 때
        println("input cryptogram : ")
        cryp = readLine().toString()
    }

    do{//문자열 체크 및 수정
        check = 0
        var chka:Char? = null
        var chkb:Char? = null
        val changetext ='\t'
        for(i: Int in 0 until cryp.length-1){
            if(chka==null){//처음(0)일 경우
                chka=cryp[i]//0번째 문자
            }
            else{
                chka=chkb//아니면 기존 chkb이어받음
            }
            chkb=cryp[i+1]//i+1번째 문자
            if(chka==chkb){//비교
                check=1//수정 발생
                val text = cryp.toCharArray()
                text[i]=changetext
                text[i+1]=changetext
                cryp=String(text) //양쪽다 \t를 넣는 것으로 나중에 수정
            }
        }

        if(check==1){
            cryp.trimMargin("\t")
        }


    }while(check==1)

    return cryp
}
