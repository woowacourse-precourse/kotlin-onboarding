package onboarding

fun solution3(number: Int): Int {
//    TODO("프로그램 구현")

//    갯수를 세아릴 변수 지정
    var answer = 0

//    1부터 문자를 스트링 값으로 바꿔서 배열에 쪼개서 넣기
//    숫자가 들어있다면 카운트 + 1
    for(i in 1..number){
        var tmp = i.toString()
        var number_list = tmp.chunked(1)
        if(isIncluded369(number_list)){
            answer += counting369(number_list)
        }
    }

    return answer
}

fun counting369(number_list : List<String>) : Int{
    var count = 0
    count += number_list.count{it == "3"}
    count += number_list.count{it == "6"}
    count += number_list.count{it == "9"}
    return count
}

fun isIncluded369(number_list : List<String>) : Boolean{
    var tmp = false
    if("3" in number_list || "6" in number_list || "9" in number_list){
        tmp = true
    }
    return tmp
}

