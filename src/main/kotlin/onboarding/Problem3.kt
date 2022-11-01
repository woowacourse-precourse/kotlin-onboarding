package onboarding

fun solution3(number: Int): Int {

    lateinit var num:String
    var count:Int=0
    if(number<=0){ //음수가 들어오면 0 반환
        return 0
    }
    for(i in 1 ..number){ //입력받은 수만큼 실행
        num=i.toString() //숫자를 문자열로 변환
        for(i in 0 until num.length){ //자릿수만큼 실행
            if((num[i]=='3')||(num[i]=='6')||(num[i]=='9')){ //각 자리수에서 3 6 9 발견시 카운트 증가
                count++
            }
        }
    }
    return count
}
