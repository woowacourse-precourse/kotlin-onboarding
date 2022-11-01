package onboarding

fun solution2(cryptogram: String): String {

    var key = 1
    var problem = cryptogram

    var afterLength: Int


    while (key == 1) {
        val beforeLength = problem.length
        problem = problem.replace("aa", "")
        problem = problem.replace("bb", "")
        problem = problem.replace("cc", "")
        problem = problem.replace("dd", "")
        problem = problem.replace("ee", "")
        problem = problem.replace("ff", "")
        problem = problem.replace("gg", "")
        problem = problem.replace("hh", "")
        problem = problem.replace("ii", "")
        problem = problem.replace("jj", "")
        problem = problem.replace("kk", "")
        problem = problem.replace("ll", "")
        problem = problem.replace("mm", "")
        problem = problem.replace("nn", "")
        problem = problem.replace("oo", "")
        problem = problem.replace("pp", "")
        problem = problem.replace("qq", "")
        problem = problem.replace("rr", "")
        problem = problem.replace("ss", "")
        problem = problem.replace("tt", "")
        problem = problem.replace("uu", "")
        problem = problem.replace("vv", "")
        problem = problem.replace("ww", "")
        problem = problem.replace("xx", "")
        problem = problem.replace("yy", "")
        problem = problem.replace("zz", "")
        afterLength = problem.length
        if (beforeLength == afterLength) {
            key = 0
        }
    }

    return problem
}
