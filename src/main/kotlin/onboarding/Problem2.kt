package onboarding

fun solution2(cryptogram: String) {
    var cmp_crypto: String = cryptogram
    while(isDuplicate(cmp_crypto).isNullOrEmpty() == true){
        var removeList = isDuplicate(cmp_crypto)
        cmp_crypto = removeDuplicate(removeList,cmp_crypto)
    }

}
fun isDuplicate(crypto: String):List<Int>{
    var indexList = emptyList<Int>();
    for(i in crypto.indices){
        if (i<crypto.length){
            if (crypto[i] == crypto[i+1]){
                indexList += i
                indexList += i+1
                break
            }
        }

    }
    return indexList
}
fun removeDuplicate(index:List<Int>,crypto: String):String{
    var tmp_crypto: String = crypto
    tmp_crypto.substring(index[0],index[0]+1)
    return tmp_crypto

}
