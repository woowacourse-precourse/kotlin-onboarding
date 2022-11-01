package onboarding

fun solution2(cryptogram: String): String {
    val list = mutableListOf<Char>()
    list.add(cryptogram[0])
    for(i in 1 until cryptogram.length){
        if(cryptogram[i] != cryptogram[i-1]){
            list.add(cryptogram[i])
        }else{
            list.removeLast()
        }
    }
    var newStr = ""
    for(item in list){
        newStr += item
    }

    return if(cryptogram.length == newStr.length || newStr.isEmpty()){
        newStr
    }else{
        solution2(newStr)
    }
}