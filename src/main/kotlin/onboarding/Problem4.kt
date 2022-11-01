package onboarding

fun solution4(word: String): String {

    var list = ArrayList<String>()

    reverse_string(word, list)

    var result =""

    list.forEach {
        result += it
    }

    return result



}
// 문자를 사전순서로 반대로 계산하여 배열에 저장하는 함수
fun reverse_string(word: String, list: ArrayList<String>){


    for(i in 0 until word.length) {

        if (word[i].isUpperCase()) {
            var a = word[i] - 'A'
            list.add(('A' + 25 - a).toString())
            continue
        }
        if(word[i].isLowerCase()){
            var b = word[i] - 'a'
            list.add(('a' + 25 - b).toString())
            continue
        }

        list.add(word[i].toString())


    }

}


