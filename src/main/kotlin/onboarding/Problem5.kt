package onboarding

fun solution5(money: Int): List<Int> {
    /*
    [기능 목록]
    1. 오만 원권부터 일원 동전까지 각 몇 개로 반환되는지 저장
    2. money를 돈의 액수로 나눈 몫과 나머지 구하기
        a) 몫은 변환되는 개수
        b) 나머지는 다시 변환활 money
     */
    var m = money
    val amount = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
    var map = LinkedHashMap<Int,Int>()

    for (i in amount){
        map.put(i, 0)
    }
    for (i in map.keys){
        map[i] = m / i
        m %= i
    }

    return map.values.toList()
}
