package onboarding

/*
    기능 목록
    1. 암호 해독 함수 decode
 */

fun solution2(cryptogram: String): String {
    var before = cryptogram
    var after = decode(before)
    // 암호 해독
    while (before != after) {
        before = after
        after = decode(before)
    }
    return after
}