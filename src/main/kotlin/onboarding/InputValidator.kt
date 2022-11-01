package onboarding

import problem1.Verifier

class InputValidator<T>(private val verifiers: List<Verifier<T>>) {
    fun validate(input:T) {
        for (verifier in verifiers) {
            verifier.verify(input)
        }
    }
}