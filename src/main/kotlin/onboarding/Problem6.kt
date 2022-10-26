package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    // 2글자씩 포함된 원소가 있는 지 비교하는 기능
    // 비교해야할 문자 만드는 기능
    forms.forEach {
        for (i in 1 until it[1].length) {
            val str = it[1].getStr(i)
        }
    }
    // 출력하는 기능
    TODO("프로그램 구현")
}

private fun String.getStr(index: Int) = "${this[index - 1]}${this[index]}"


