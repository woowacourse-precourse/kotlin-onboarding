package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for(num in 1..number){
        //num 을 String 변환
        val strNum = num.toString()
        for(j in strNum.indices){
            //각 문자가 0이 아니고 3으로 나눈 나머지가 0이면 박수 증가
            if(strNum[j]!='0'&& (strNum[j]-'0')%3==0){
                count++
            }
        }
    }
    return count
}
