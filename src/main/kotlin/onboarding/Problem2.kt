package onboarding

fun removeString(target: String, startIndex: Int):String {
    return target.substring(startIndex, startIndex+1)
}

fun solution2(cryptogram: String): String {
    var i: Int
    var target:Int
    var crypt:String = cryptogram
    while(true) {
        i = 0
        target = -1
        while(i < crypt.length-1) {
            if(crypt[i] == crypt[i+1]) {
                target = i
                break
            }
        }
        if(target != -1) {
            crypt = removeString(crypt,i)
        } else {
            break
        }
    }
    return crypt
}
