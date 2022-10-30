package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}

fun deleteDuplication(cryptogram: String): String {
    var st = Stack<Char>()
    var check = false
    st.push(cryptogram[0])
    var preChar = cryptogram[0]
    for (i in 1 until cryptogram.length) {
        if (preChar == cryptogram[i]) {
            preChar = cryptogram[i]
            check = true
        }
        if (preChar == cryptogram[i] && i == (cryptogram.length - 1)) {
            st.pop()
        }
        if (preChar != cryptogram[i]) {
            preChar = cryptogram[i]
            if (!check) {
                st.push(cryptogram[i])
            }
            if (check) {
                st.pop()
                st.push(preChar)
                check = false
            }
        }
    }
    TODO()
}