package onboarding
fun main(){
    println(solution3(31))
}
fun solution3(number: Int): Int {
    val number = number
    var clappingCount = 0
    for (index in 1 until number+1){ // 전달받은 숫자 만큼 for 문을 돌려
        val numberString = index.toString() // 각 숫자를 문자열로 변한하여
        for (index2 in numberString.indices){ // 그 문자열 크기만큼 반복문을 돌리고
            if (numberString[index2] == '3' || numberString[index2] == '6' || numberString[index2] == '9'){
                clappingCount += 1 // 각 숫자 자리에 3, 6, 9가 포함되어 잇으면 박수 count를 올린다.
            }
        }
    }
    return clappingCount
}
