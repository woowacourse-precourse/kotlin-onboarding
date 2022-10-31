package onboarding

import problem1.CompareVerifier

class TwoInputValidator<T>(private val verifiers: List<CompareVerifier<T>>) {
    fun validate(input1:T, input2:T) {
        for (verifier in verifiers) {
            verifier.verify(input1, input2)
        }
    }
}