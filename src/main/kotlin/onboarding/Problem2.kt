package onboarding

import java.util.*


fun solution2(cryptogram: String): String {

    var st = Stack<Char>()
    var answer = ""

    comapre_char(cryptogram , st)


    for(i in 0 until st.size){
        answer = st.pop() + answer
    }

    return answer



}
fun comapre_char(cryptogram: String , st : Stack<Char>)  {

    for(i in 0 until cryptogram.length) {

        //스택이 비었으면 문자 저장
        if(st.isEmpty()){
            st.push(cryptogram[i])
        }

        //스택의 윗 부분과 다음 저장할 문자 비교
        if (st.isNotEmpty() && i >= 1) {
            if (st.peek() == cryptogram[i]) {
                st.pop()
                continue
            }

            if (st.peek() != cryptogram[i]) {
                st.push(cryptogram[i])
            }
        }


    }
}
