package problem1

abstract class CompareVerifier<T> {
    abstract fun verify(input1:T, input2:T)
}