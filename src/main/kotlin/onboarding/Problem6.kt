package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableListOf<String>()
    // 이미 포함시켰는지 여부 체크
    val checkList = arrayOfNulls<Boolean>(forms.size)
    checkList.fill(false)

    for (i in 0 until forms.size - 1) {
        val curName = forms[i][1]
        for (cmpNameIndex in i + 1 until forms.size) {
            if (checkList[cmpNameIndex] == true) {
                continue
            }

            val cmpName = forms[cmpNameIndex][1]
            for (subs in 0 until curName.length - 1) {
                if (cmpName.contains(curName.substring(subs..subs + 1))) {
                    checkList[cmpNameIndex] = true
                    checkList[i]=true
                    break
                }
            }
        }
    }

    for (ch in checkList.indices){
        if(checkList[ch]==true){
            result.add(forms[ch][0]) // 해당 사람의 이메일 리스트에 추가.
        }
    }
    result.sort() // 원본 배열을 정렬시킴. 새로운걸 만들어서 반환하는 것은 sorted임.
    return result
}
