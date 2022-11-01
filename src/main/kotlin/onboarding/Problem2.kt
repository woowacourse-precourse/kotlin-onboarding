package onboarding

fun checkString(str: String): Boolean {
    var flag = 0

    for (i in 1..str.length -1 ) {
        if (str[i-1].equals(str[i])) {
            flag = 1
        }
    }

    return if (flag == 0)
        false
    else
        true
}

fun removeDuplicate(str: String): String{
    var check: CharArray = charArrayOf()

    for (i in 0..str.length -1 ) {

        if (i>=1 && i< str.length -1){
            if (str[i-1].equals(str[i])) {
                check = check.slice(0 until i-1).toCharArray()
                        .plus(check.slice(i+1 ..str.length -1)
                                .toCharArray())
            }
        }else if (i == 0){
            continue
        }else{
            if (str[i-1].equals(str[i])) {
                check = check.slice(0 until i-1).toCharArray()
            }
        }
    }

    return check.joinToString("")
}

fun solution2(cryptogram: String): String {
    var res = cryptogram
    while (checkString(res)){
        res = removeDuplicate(res)
    }

    return res

}

