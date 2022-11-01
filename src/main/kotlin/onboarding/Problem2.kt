package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    var len=cryptogram.length //crytogram의 길이
    var answer:String=""
    var stack = Stack<Char>() //crytogram의 문자 하나하나를 stack에 삽입 후 top과 비교하여 중복 문자 제거해 나가는 구조
    if(cryptogram==""){ //빈 문자열이 들어왔을 때
        return cryptogram
    }


    stack.push(cryptogram[0])//처음 문자는 stack에 삽입
    var idx=1
    var top=stack.peek() //stack의 top
    while (idx<len){ //index가 cryptogram의 사이즈와 같아지거나 커지면 반복문 종료

        if(cryptogram[idx]==top){ //중복이 발생했을 때
            while(cryptogram[idx]==top){ //같은 문자열이 끝날 때까지 index 이동
                if(idx>=len-1){ //string out of index 에러 방지
                    idx++
                    break
                }
                idx++
            }
            stack.pop() //중복발생한 스택 상단 제거
            if(stack.isNotEmpty()){ //스택이 empty가 아니라면
                top=stack.peek() //top에 stack 최상단값 저장
            }

        }
        else{ //중복이 아니라면
            stack.push(cryptogram[idx]) //스택에 문자열 저장
            top=stack.peek() //top에 stack 최상단값 저장
            idx++
        }


    }
    if(stack.isNotEmpty()){ //stack이 empty가 아닐 때
        for(i in 0 until stack.size){
            answer=answer + stack.pop()
        }
        answer=answer.reversed()
        return answer
    }
    else{
        return "" //stack이 비었을 때
    }


}
