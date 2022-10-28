package onboarding
/*
1. 이름에서 2글자로 조합할 수 있는 연속된 문자열들을 사전으로 만든다
사전은 hashmap으로 문자열, 등장횟수로 구성되어 있다.
제이제이와 같이 같은 문자열이 반복해서 등장할 경우 등장횟수를 1로 한다
2. 등장횟수가 2 이상인 것들만 사전에서 가져와 forms에 있는 이름들과 비교한다
3. 조건에 맞는 것들을 answer에 담아준 후 sort한다.
*/
fun solution6(forms: List<List<String>>): List<String> {
    val hm = makeDictionary(forms)

    val visit = check(forms, hm)

    val answer = ArrayList<String>()
    for (i in forms.indices) {
        if (visit[i]) {
            answer.add(forms[i][0])
        }
    }

    answer.sort()

    return answer.toList()
}

private fun makeDictionary(forms: List<List<String>>): HashMap<String, Int> {
    val hm = HashMap<String, Int>()

    for (i in forms.indices) {
        val name = forms[i][1]
        val set = HashSet<String>()
        for (a in 0 until name.length - 1) {
            val tmp = name.substring(a, a + 2)
            if(set.contains(tmp)){
                continue
            } else {
                set.add(tmp)
                hm[tmp] = hm.getOrDefault(tmp, 0) + 1
            }
        }
    }

    return hm
}

private fun check(forms: List<List<String>>, hm: HashMap<String, Int>): BooleanArray {
    val visit = BooleanArray(forms.size)

    for (i in forms.indices) {
        val name = forms[i][1]
        for (key in hm.keys) {
            if (hm[key]!! >= 2 && name.contains(key)) {
                visit[i] = true
                break
            }
        }
    }
    return visit
}