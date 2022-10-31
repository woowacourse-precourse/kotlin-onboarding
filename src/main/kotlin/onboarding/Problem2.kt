package onboarding

fun solution2(cryptogram: String): String {
    var answer = ""
    var flag = true
    var char_list= mutableListOf<Char>()
    var count=0
    //리스트에 문자 채워주기
    for (i in 0 until cryptogram.length){
        char_list= char_list.plus(cryptogram[i]) as MutableList<Char>
    }
    // 최초 리스트 모습 확인
//    println(char_list)

    while (flag){
        //종료조건 끝까지 돌았는데 제거할게 없다면 or 아무것도 남지 않았다면
        if (count ==1000 || char_list.size==0){ // 문자 길이 1000이므로
            flag=false
        }
        for (j in 0 until char_list.size){
            if (j+1>=char_list.size){
                break
            }
            if (char_list[j]==char_list[j+1]){
                char_list.removeAt(j)
                char_list.removeAt(j)
            }
        }
        count+=1
    }
    for (k in 0 until char_list.size){
        answer+=char_list[k]
    }

    return "\"${answer}\""
}
