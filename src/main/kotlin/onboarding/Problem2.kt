package onboarding

fun solution2(cryptogram: String): String {

    return cryp(cryptogram)
}

fun cryp(word:String):String{
    var change=false
    var result = ""
    var i=0
    var s = ""
    var count=0
    while(i<=word.length-1){

        s = word.substring(i,i+1)
//        println(s)
        var j = i+1
        count = 0
        while(j<word.length && word.substring(j,j+1).equals(s)){
//            println(count)
            j++
            count++
            change=true
        }
        i+=count
        if(count==0){
            result+=s
//            println(result)
        }
        i++
    }
//    if(count==0) result += s
    if(change) return cryp(result)
    return result
}

fun main(){
    println(cryp("cbabbcabba"))
}
