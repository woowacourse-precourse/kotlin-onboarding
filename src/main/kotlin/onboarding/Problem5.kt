package onboarding

fun solution5(money: Int): List<Int> {
    val loop = 9

    var coin = money
    var result = mutableListOf<Int>()
    var divQuint = 50000
    var divDeca = 10000

    for(i in 0 until loop){
        if(i == 8){
            result.add(coin)
        }
        else if(i % 2 == 0) {
            result.add(coin / divQuint)
            coin %= divQuint
            divQuint /= 10
        }
        else if(i % 2 == 1){
            result.add(coin / divDeca)
            coin %= divDeca
            divDeca /= 10
        }

    }

    return result
}
