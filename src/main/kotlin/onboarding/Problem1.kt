package onboarding

fun digit_sum(num: Int): Int { // 각 자리수 합 return
    var sum = 0
    var n = num
    while (n > 0) {
        sum += n % 10
        n /= 10
    }
    return sum
}

fun digit_multiple(num: Int): Int { // 각 자리수 곱 return
    var multiple = 1
    var n = num
    while (n > 0) {
        multiple *= n % 10
        n /= 10
    }
    return multiple
}

fun max(a: Int, b: Int): Int { // a와 b중 큰 값 return
    return if (a > b){
        a
    } else {
        b
    }
}

fun exception(lst: List<Int>): Boolean { // 예외 사항, 문제 발생 시 true return
    if (lst.size != 2) return true // 입력된 배열의 크기가 2가 아닌 경우
    if (lst.first() % 2 == 0 || lst.last() % 2 == 1) return true // 왼쪽 페이지가 짝수거나 오른쪽 페이지가 홀수인 경우
    if (lst.first() + 1 != lst.last()) return true // 왼쪽 페이지와 오른쪽 페이지의 순서가 다르거나 차이가 1이 아닌 경우
    if (lst.first() < 1 || lst.last() > 400) return true // 페이지가 1보다 작거나, 400보다 큰 경우와 시작면과 마지막 면인 경우
    // 시작면과 마지막면을 책의 표지라 생각하
    return false
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (exception(pobi) || exception(crong)) return -1

    val pobi_score = max(max(digit_sum(pobi.first()), digit_multiple(pobi.first())), max(digit_sum(pobi.last()), digit_multiple(pobi.last())))
    val crong_score = max(max(digit_sum(crong.first()), digit_multiple(crong.first())), max(digit_sum(crong.last()), digit_multiple(crong.last())))

    return if(pobi_score>crong_score) 1 else if(pobi_score<crong_score) 2 else 0
}
