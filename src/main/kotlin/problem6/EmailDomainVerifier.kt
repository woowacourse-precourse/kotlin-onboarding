package problem6

import problem1.Verifier

class EmailDomainVerifier(private val validDomain:String) : Verifier<String>() {
    override fun verify(input: String) {
        val atIdx = input.indexOf('@')
        val domain = input.substring(atIdx + 1)
        if(domain != validDomain) {
            throw RuntimeException("Domain address is not valid")
        }
    }
}