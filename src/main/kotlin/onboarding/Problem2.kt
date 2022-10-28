package onboarding

fun solution2(cryptogram: String): String {
    var mutableList = mutableListOf<Char>()//수정 가능하고 스택처럼 쓸수있는 mutableList 사용
    var answer : String//리턴하기위해 선언
    for (i in 0..cryptogram.length - 1) {
        if (!mutableList.isEmpty() && mutableList.last() == cryptogram[i]) {//리스트가 비어있지않고 마지막 문자와 cryptogram[i] 같으면
            mutableList.removeLast()//pop
        } else if(mutableList.isEmpty() || mutableList.last() != cryptogram[i]){//리스트가 비어있거나 마지막 문자와 cryptogram[i] 같지않으면 push 한다.
            mutableList.add(cryptogram[i])//push
        }
    }
    answer = mutableList.toString()
    return answer
}