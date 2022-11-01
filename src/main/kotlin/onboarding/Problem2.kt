package onboarding

import com.sun.jdi.connect.Connector.IntegerArgument

fun solution2(cryptogram: String): String {
    val crypto = cryptogram.chunked(1) // 1글자씩 리스트화
    val list  = crypto.toMutableList()
    fun execute(list: List<String>) {

    }
    var i = 0
    while (i<list.size-1){
        if (list[i] == list[i+1]){ //  2개연속 같은 글자
            var k = i+1
            var cnt = 0
            while (k<list.size-1) { // 3개연속 같은 글자일경우
                if (list[k] == list[k + 1]){
                    cnt++
                    k++
                }
                else{ break }
            }
            for (j in 0..cnt+1) { list.removeAt(i) } //삭제
        }
        else{ i++ }
    }

    val ans = list.joinToString("")
    return ans

}
