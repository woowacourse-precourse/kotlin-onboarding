package onboarding

import java.util.stream.Collectors

fun solution6(forms: List<List<String>>): List<String> {
    var answer = mutableListOf<String>()
    val emails: HashSet<String> = HashSet()
    val hashMap: MutableMap<String, String> = HashMap()

    var name: String
    var email: String
    var keyword: String

    for (i in 0 until forms.size) {
        name = forms[i][1]
        for (j in 0 until name.length - 1) {
            keyword = name.substring(j, j + 2)
            if (hashMap.containsKey(keyword)) {
                email = hashMap[keyword]!!
                if (email != forms[i][0]) {
                    emails.add(email)
                    emails.add(forms[i][0])
                }
            }
            hashMap[keyword] = forms[i][0]
        }
    }
    for(i in emails){
        answer.add(i)
    }

    val list = answer.toList()
    return list

}
