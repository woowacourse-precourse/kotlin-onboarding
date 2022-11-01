package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobi_max :Int = 0
    var crong_max : Int = 0

    //예외 사항 제외
    if (pobi[0] % 2 != 1 || crong[0] % 2 != 1){return -1} //왼쪽페이지가 홀수가 아닐때
    if (pobi[0] < 3 || pobi[1] > 398){return -1} //포비가 범위 밖의 페이지를 펼칠 경우
    if (crong[0] < 3 || crong[1] > 398){return -1} //크롱이 범위 밖의 페이지를 펼칠 경우
    if (pobi[1] != pobi[0]+1 || crong[1] != crong[0] +1){return -1} //왼쪽페이지랑 오른쪽페이지가 매칭 안될때

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
    //크롱 최대값 구하기, 양쪽페이지->0,1
    for (j in 0..1){
        var crong_page = crong[j].toString()
        var sum = 0
        var mul = 1
        //각 자리 수 더하기 & 곱하기
        for(i in 0..crong_page.length-1){
            var n = crong_page[i]-'0' //아스키코드 빼주기
            sum = sum + n
            mul = mul * n
        }
        //4번과정. 최대값 비교.
        if(crong_max < sum){crong_max = sum}
        if(crong_max < mul){crong_max = mul}
    }
    //println(pobi_max)
    //println(crong_max)

    if (pobi_max > crong_max){
        return 1
    }else if(pobi_max < crong_max){
        return 2
    }else if(pobi_max == crong_max){
        return 0
    }else{
        return -1
    }
}