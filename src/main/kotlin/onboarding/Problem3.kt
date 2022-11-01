package onboarding

//369게임
fun solution3(number: Int): Int {
    //number는 1 이상 10,000 이하인 자연수이다.
    if(number < 1 || number > 10000){return -1}

    var clap_cnt :Int = 0 //박수 카운터
    for (i in 1..number){
        //숫자 문자열로 분리
        val num_to_str = i.toString()
        //자리수마다 3,6,9 확인
        for (j in 0..num_to_str.length-1){
            var n = num_to_str[j]
            if( n == '3' || n == '6' || n == '9'){
                clap_cnt += 1
            }
        }
    }
    return clap_cnt
}
