package onboarding

fun solution2(cryptogram: String): String {
    var cryptogramResult = cryptogram
    var decodeResult: String


    while(true){
        decodeResult = decodeString(cryptogramResult)

        if (!cryptogramResult.equals(decodeResult)){
            cryptogramResult = decodeResult
            continue
        }
        if (cryptogramResult.equals(decodeResult)){
            break
        }

    }

    return cryptogramResult
}

fun decodeString(cryptogram:String) : String{
    var cryptogramResult  = ""
    var count = 0

    for ( i in 1.. cryptogram.length-1){
        if(cryptogram[i-1] != cryptogram[i]){
            if (count > 0 ){
                cryptogramResult += cryptogram.substring(i,cryptogram.length)
                break
            }
            cryptogramResult += cryptogram[i-1].toString()
        }
        if(cryptogram[i - 1] == cryptogram[i]){
               count++
        }
    }

    if(count == 0){
        return cryptogram
    }

    return cryptogramResult
}


