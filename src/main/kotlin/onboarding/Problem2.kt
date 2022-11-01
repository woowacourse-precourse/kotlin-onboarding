package onboarding

fun main(){
    solution2("browoanoommnaon")
}


//암호문. 연속되는 중복 알파벳 제거
fun solution2(cryptogram: String): String {
    //var decryption :String = cryptogram
    var list = mutableListOf<Char>()
    for (i in 0..cryptogram.length-1){
        list.add(cryptogram[i].toChar())
    }
    println(list.size)
    for(i in 1..list.size){
        if(list[i] == list[i-1]){
            list.removeAt(i)
            break
        }
    }
    println(list.size)
    return "---"

}
