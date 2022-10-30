package onboarding
fun main(){

    val forms = listOf(
        listOf("jm@email.com", "제이엠"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니"),
        listOf("mj@email.com", "엠제이"),
        listOf("nowm@email.com", "이제엠")
    )
    solution6(forms)
}


fun solution6(forms: List<List<String>>): List<String>{
    val forms = forms

    var twoWordsArray = ArrayList<String>() //두 개의 단어 단위로 저장하는 배열
    var countArray = ArrayList<Int>() // 두 개의 단어를 포함하는 개수를 저장하는 배열
    var lengthArray = ArrayList<Int>() // 각 닉네임의 길이를 저장한 배열
    var result = ArrayList<String>() // 결과 배열

    /** 전달 받은 배열에서 각 닉네임을 두 글자씩 쪼개어 배열에 저장하는 반복문 */
    for (index in forms.indices){
        for (index2 in 1 until forms[index][1].length){
            twoWordsArray.add("${forms[index][1][index2-1]}${forms[index][1][index2]}")
        }
    }

    /**
     * 각 닉네임들이 저장했던 각각의 두 단어를 포함할 때의 횟수와,
     * 각 닉네임들의 글자수를 저장하는 반복문
     */
    for (index3 in forms.indices){
        var count = 0
        for (index4 in twoWordsArray.indices){
            if (forms[index3][1].contains(twoWordsArray[index4])){
                count ++
            }
        }
        lengthArray.add(forms[index3][1].length)
        countArray.add(count)
    }

    /**
     * 저장했던 글자수와 중복 횟수 배열을 비교하여 글자수가 중복된 횟수보다 적으면
     * 그 글자는 연속된 중복 글자를 가지고 있다는 뜻이므로
     * 그 글자에 해당하는 이메일을 결과 배열에 추가해준다.
     */
    for (index in countArray.indices){
        if (lengthArray[index] <= countArray[index]){
            result.add(forms[index][0])
        }
    }

    return result.sorted()
}
