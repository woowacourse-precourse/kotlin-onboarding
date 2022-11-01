package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobi_max :Int = 0
    var crong_max : Int = 0

    for (j in 0..1){ // 제한사항 : 리스트 크기는 2
        var pobi_page = pobi[j].toString() //페이지 리스트 문자열로 치환
        //sum, mul 선언
        var sum = 0
        var mul = 1
        //각 자리 수 더하기 & 곱하기
        for(i in 0..pobi_page.length-1){
            var n = pobi_page[i]-'0' //각 자리수 다시 숫자로 치환; 아스키코드;
            sum = sum + n
            mul = mul * n
        }
        //4번과정. 최대값 비교.
        if(pobi_max < sum){pobi_max = sum}
        if(pobi_max < mul){pobi_max = mul}
    }
    println(pobi_max)
    return 0
}
