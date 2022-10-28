package onboarding

fun solution3(number: Int): Int {
    var answer : String = ""

    answer = oneToNumSum(number)

    return 0

}
// 1부터 number까지 숫자를 문자열로 더하는 기능
fun oneToNumSum(num : Int) : String{
    var cnt : String = ""
    for (i in 1 .. num){
        cnt += i.toString()
    }
    return cnt

}