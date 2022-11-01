package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var arrOfRepeat = Array(forms.size) { 0 }
    var formsHash = twoLetters(forms)
    return checkRepeat(forms,formsHash,arrOfRepeat)
}

//두 글자 리스트로 만드는 함수
fun twoLetters(forms:List<List<String>>):HashMap<Int, List<String>>{
    var formsHash = hashMapOf<Int, List<String>>()

    for (i in forms.indices) {
        //닉네임을 두 글자씩 나누어 저장
        var mutableList = mutableListOf<String>()
        for (j in 0..forms[i][1].length - 2) {
            mutableList.add(forms[i][1].substring(j, j + 2))
        }
        formsHash[i] = mutableList.toSet().toList()
    }
    return formsHash
}

//닉네임 중복 검사 함수
fun checkRepeat(forms:List<List<String>>,formsHash:HashMap<Int, List<String>>,arrOfRepeat:Array<Int>):MutableList<String>{
    var repeatName = mutableListOf<String>()

    for (i in 0 until formsHash.size - 1) {
        val listI = formsHash[i]
        for (j in i + 1 until formsHash.size)
        {
            //불필요한 연산 삭제
            if(arrOfRepeat[i]==1 && arrOfRepeat[j]==1) {
                continue
            }

            //같으면 arrOfRepeat 의 해당 index 증가
            val listJ = formsHash[j]
            for (k in listI!!.indices)
                for (l in listJ!!.indices)
                    if (listI[k] == listJ[l]) {
                        arrOfRepeat[i]=1
                        arrOfRepeat[j]=1
                    }
        }
    }

    for (i in forms.indices)
        if (arrOfRepeat[i] != 0)
            repeatName.add(forms[i][0])

    repeatName = repeatName.distinct() as MutableList<String>
    repeatName.sort()
    return repeatName
}