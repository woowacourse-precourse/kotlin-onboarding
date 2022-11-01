package onboarding

fun main(){
    solution2("browoanoommnaon")
}


//암호문. 연속되는 중복 알파벳 제거
fun solution2(cryptogram: String): String {
    //var decryption :String = cryptogram
    var list = mutableListOf<Char>()
    var list2 = mutableListOf<Char>()
    for (i in 0..cryptogram.length-1){
        list.add(cryptogram[i].toChar())
    }

    while(true){                        //무한반복
        var len = list.size-1
        for(i in 1..len){
            //연속하는 중복 숫자 제거
            if(list[i].toChar() != list[i-1]){
                list.removeAt(i+1)
                list.removeAt(i)
                len -= 2
                //break
            }
        }
    }
    //println(list)
    return list.toString()

}
