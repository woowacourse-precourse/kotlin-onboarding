package onboarding

fun solution2(cryptogram: String):String {

    var processedCryptogram = cryptogram


    for (i:Int in processedCryptogram.indices){
        var duplicateCount = 0
        for (j:Char in processedCryptogram.substring(i+1)){
            if(processedCryptogram[i] == j){
                duplicateCount += 1
            }else break
        }
        if (duplicateCount > 0){
            processedCryptogram.removeRange(i,i+duplicateCount+1)
        }
    }
}
