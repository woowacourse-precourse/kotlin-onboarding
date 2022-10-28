package onboarding

import kotlin.math.max

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun exception6(forms: List<List<String>>) {
    if(forms.size < 1 || forms.size > 10000) {
        throw IllegalArgumentException("크루는 1명이상 10000명 이하여야 합니다.")
    }
}

fun exception_name(nickName : String) {

    if(nickName.length < 1 || nickName.length >= 20) {
        throw IllegalArgumentException("닉네임은 1자 이상 20자 미만이어야 합니다.")
    }

    if(!nickName.matches("^[가-]*$".toRegex())) {
        throw IllegalArgumentException("닉네임은 한글만 가능합니다.")
    }
}

fun exception_email(email : String) {

    if(email.length < 11 || email.length >= 20) {
        throw IllegalArgumentException("이메일은 11자 이상 20자 미만이어야 합니다.")
    }

    if(!email.matches("^([a-zA-Z0-9._%-]+@email.com)*$".toRegex())) {
        throw IllegalArgumentException("이메일의 도메인은 @email.com이어야 합니다.")
    }
}

fun find_subset(nickName: String) : Set<String> {

    val result = mutableSetOf<String>()

    for(i in 0 until nickName.length) {
        add_subset(nickName, i, result)
    }
    return result
}

fun add_subset(nickName: String, num : Int, set: MutableSet<String>) {
    for(i in 0 until nickName.length - num) {
        set.add(nickName.substring(i, i + num + 1))
    }
}

fun find_intersect_str(str1 : String, str2 : String) : Set<String> {

    val result = mutableSetOf<String>()
    val set1 = find_subset(str1)
    val set2 = find_subset(str2)

    for(element in set1) {
        if(set2.contains(element)) {
            result.add(element)
        }
    }
    return result
}