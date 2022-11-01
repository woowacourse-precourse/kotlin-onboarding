package onboarding

fun isSameAlphabet(a1 : Char,a2 : Char) : Boolean = (a1==a2)

fun removeAlphabet(s : String,i : Int) : String{
    var answer : String =""
    if(s.length>=i+2){
        answer=s.slice(0..i-1)+s.slice(i+2..s.length-1)
    }
    else answer=s.slice(0..i-1)
    return answer
}
fun removeSameAlphabet(cryptogram: String) : String{
    var i : Int = 0 //check point index
    var answer=cryptogram
    while(i<answer.length-1){
        if(isSameAlphabet(answer[i],answer[i+1])){
            answer=removeAlphabet(answer,i)
        }
        else i++
    }
    return answer
}
fun solution2(cryptogram: String): String {
    //암호문 구하기
    var answer : String = cryptogram
    while(true){
        temp=removeSameAlphabet(answer)
        if(temp==answer) break // 종료 조건
        answer=temp
    }
    return answer
}
