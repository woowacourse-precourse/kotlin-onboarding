package onboarding

import problem1.*
import java.lang.RuntimeException

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    try {
        val leftPageValidator = InputValidator(
            listOf(
                RangeVerifier(1, 400),
                OddVerifier(),
                NotOneVerifier()
            )
        )

        val rightPageValidator = InputValidator(
            listOf(
                NotLastVerifier(400)
            )
        )

        val pagesValidator = TwoInputValidator(
            listOf(
                ConsecutiveNumberVerifier()
            )
        )

        leftPageValidator.validate(pobi[0])
        leftPageValidator.validate(crong[0])
        rightPageValidator.validate(pobi[1])
        rightPageValidator.validate(crong[1])
        pagesValidator.validate(pobi[0], pobi[1])
        pagesValidator.validate(crong[0], crong[1])
    } catch (e:RuntimeException) {
        return Exception().printError()
    }

    val scoreCalculator = ScoreCalculator()
    val pobiScore = scoreCalculator.calculate(pobi[0], pobi[1])
    val crongScore = scoreCalculator.calculate(crong[0], crong[1])

    return WinnerCalculator().calculate(pobiScore, crongScore)
}
