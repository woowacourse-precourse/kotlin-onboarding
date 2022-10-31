package problem6

import problem1.Verifier

class EmailFormatVerifier : Verifier<String>() {
    override fun verify(input: String) {
        val regex = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        if(!regex.matches(input)) {
            throw RuntimeException("Input is not in email format")
        }
    }
}