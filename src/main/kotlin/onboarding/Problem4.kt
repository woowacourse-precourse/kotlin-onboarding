package onboarding

fun solution4(word: String): String {
    val list = word.chunked(1).toMutableList() // 1글자씩 리스트화
    for (i : Int in 0..word.length-1) {
        if (list[i] != " ") { // 빈칸이 아닐경우
            var char = list[i].single()
            if (char.code in 65..90) {
                var ascii = (90 - (char.code - 65)).toChar() //아스키코드 값 변환후 계산
                list[i]=ascii.toString()
            } else if (char.code in 97..122) {
                var ascii = (122 - (char.code - 97)).toChar() // 아스키코드 값 변환후 계산
                list[i]=ascii.toString()
            }

        }
    }
    return list.joinToString("")
}
