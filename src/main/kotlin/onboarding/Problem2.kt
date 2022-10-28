package onboarding

fun solution2(cryptogram: String): String {
    var cryptogramResult = cryptogram
    var decodeResult=decodeString(cryptogram)

    while(true){
        if (cryptogramResult != decodeResult){
            cryptogramResult = decodeResult
        }else{
            break
        }
        decodeResult = decodeString(decodeResult)
    }
    return decodeResult

}
fun decodeString(cryptogram:String) : String{
    var cryptogramResult = cryptogram
    var count=0

    for (i in 0..cryptogram.length - 2 step (1)){
        if (cryptogram[i] == cryptogram[i+1]){
            ++count
        }

        if(count>0){

            val subString= cryptogram.substring(i until i+count+1)
            cryptogramResult=cryptogramResult.replace(subString,"")
            break
        }
    }

    return cryptogramResult
}

