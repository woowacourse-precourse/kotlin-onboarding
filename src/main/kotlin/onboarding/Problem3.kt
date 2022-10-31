package onboarding

fun find(num: Int): Int { // 해당 숫자의 3, 6, 9 개수 return
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
