package onboarding

fun solution2(cryptogram: String): String {
    var answer = cryptogram
    while (answer.length>1) {
        var next = ""
        for (i in 0..(answer.length)-1) {
            if (0<i&&i<answer.length-1) {
                if (answer[i]==answer[i-1]||answer[i]==answer[i+1]) {
                    continue
                } else {
                    next = next.plus(answer[i])
                }
            } else if (i==0){
                if (answer[i]==answer[i+1]) {
                    continue
                } else {
                    next = next.plus(answer[i])
                }
            } else if (i==answer.length-1){
                if (answer[i]==answer[i-1]) {
                    continue
                } else {
                    next = next.plus(answer[i])
                }
            }
        }

        if (answer==next) {
            break
        }
        else if (next.length==0) {
            answer = ""
            break
        }
        else {answer = next}
    }
    return answer
}
