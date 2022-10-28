package onboarding

// 숫자에 포함된 3, 6, 9의 개수를 리턴하는 함수
fun tsn_check(num: Int): Int{
    var number = num
    var arraylist = arrayListOf<Int>()
    while(number!=0){
        arraylist.add(number%10)
        number/=10
    }
    return arraylist.count(){it==3||it==6||it==9}
}

fun solution3(number: Int): Int {
    var result = 0
    for(i in 1..number){
        result += tsn_check(i)
    }
    return result
}
