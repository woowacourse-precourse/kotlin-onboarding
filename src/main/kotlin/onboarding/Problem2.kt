package onboarding

fun solution2(cryptogram: String): String {
    // 포문을 써서 중복을 확인하세요.
    // 1. string을 돌면서 안에 있는 원소 하나씩 뽑기
    // 2. 뽑은 것을 기존 것과 비교하기
    // 3. 같다면, 둘을 없애서 새로운 리스트에 append하기

    var result = duplicateErase(cryptogram)
    while(duplicateCheck(result)){
        result = duplicateErase(result)
    }
    return result

}

fun duplicateErase(cryptogram: String): String{
    println(cryptogram)
    var resArray = arrayListOf<String>()
    var k = 0
    for (j in cryptogram.indices) {
        print("j:$j ")
        print("k:$k ")

        if (k == cryptogram.lastIndex) {
            resArray.add(cryptogram[k].toString())
            println(resArray)
            break
        }
        if (cryptogram[k].toString() == cryptogram[k+1].toString()) {
            var a = cryptogram[k].toString()
            var b = cryptogram[k+1].toString()
            println("cryptogram[k].toString(): $a")
            println("cryptogram[k+1].toString(): $b")
            if (cryptogram.length > 2) {
                k += 2
            }
            else {
                return ""
            }
            continue
        }
        resArray.add(cryptogram[k].toString())
        k++
        println(resArray)
    }
    var duplicateEraseResult = resArray.toString()
    println("duplicateEraseResult: $duplicateEraseResult")
    return resArray.joinToString("").replace("\\s".toRegex(), "")
}

fun duplicateCheck(cryptogram: String): Boolean{
    for ((k, j) in cryptogram.withIndex()) {
        if (k == cryptogram.lastIndex) {
            break
        }
        if (cryptogram[k].toString() == cryptogram[k+1].toString()) {
            return true
        }
    }
    return false
}