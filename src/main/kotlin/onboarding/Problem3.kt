package onboarding

/*
* 배달이가 좋아하는 369게임을 하고자 한다.
* 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.
* 숫자 number가 매개변수로 주어질 때,
* 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 함수를 완성하라.
* */

// number 1 .. 10000

fun find(num: Int): Int { // 해당 숫자의 3, 6, 9 개수 return해주는 함수
    var many = 0
    var n = num
    while (n > 0){
        if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) many += 1
        n /= 10
    }
    return many
}

fun solution3(number: Int): Int {

    var result = 0
    for(num in 1..number){
        result += find(num)
    }
    return result
}