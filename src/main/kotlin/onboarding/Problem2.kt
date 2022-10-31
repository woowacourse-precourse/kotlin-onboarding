package onboarding

import java.util.*


fun solution2(cryptogram: String): String {

    var st = Stack<Char>()
    var answer = ""

    for(i in 0 until cryptogram.length) {

        if(st.isEmpty()){
            st.push(cryptogram[i])
        }

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


    for(i in 0 until st.size){
        answer = st.pop() + answer
    }

    return answer



}
