package onboarding

fun solution2(cryptogram: String): String {

    var data0 = cryptogram
    var data1 = deleteDuplication(data0)

    while(data0 != data1){
        data0 = data1
        data1 = deleteDuplication(data0)

    }

    return data0
}

fun deleteDuplication(str : String): String{
    val len = str.length
    var checkDuplication = false
    val strPadding = str + '1'
    var newStr = ""

    for(i in 0 until len){
        if(strPadding[i] != strPadding[i+1]){
            if(checkDuplication)
                checkDuplication = false
            else
                newStr += strPadding[i]

        }else{
            checkDuplication = true
        }
    }

    return newStr
}

fun main() {
    val str = "browoanoommnaon"

    solution2(str)
}