package onboarding

fun main(){
    solution2("browoanoommnaon")
}


//암호문. 연속되는 중복 알파벳 제거
fun solution2(cryptogram: String): String {
    var decryption :String = cryptogram
    // 중복 글자 없을때까지 무한 반복
    while (true){
        for (i in 0..decryption.length){
            if(decryption[i] == decryption[i+1])
                println(decryption[i])
                //중복된값 삭제
                println(decryption)

        }
    //    if() { //중복글자 없음
            return decryption //해독문 리턴
    //    }
    }
}
