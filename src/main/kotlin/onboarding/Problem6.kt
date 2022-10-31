package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var answer = arrayListOf<String>()
    var li = mutableSetOf<String>()
//    for (i in 0..forms.size-1) {
//        var str = forms[i][1]
//        for (j in 2..str.length) {
//            for (k in 0..str.length-j) {
//                li.add(str.substring(k, k+j))
//            }
//        }
//    }
    for (i in 0..forms.size-1) {
        li.add(forms[i][1])
    }
    for (i in 0..forms.size-1) {
        var str = forms[i][1]
        var email = forms[i][0]
        if (email.substring(email.length-9, email.length)=="email.com") {
            var x = false
            for (j in 2..str.length) {
                for (k in 0..str.length-j) {
                    var t = li.count() {x->x.contains(str.substring(k, k + j))}
                    if (t>=2) {
                        answer.add(email)
                        x = true
                        break
                    }
                }
                if (x == true) {
                    break
                }
            }
        }

    }


    answer.sort()
    return answer.toList()
}
