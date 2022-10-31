package onboarding

fun solution2(cryptogram: String): String {
    var password = cryptogram

    while(true) {
        if(password.isEmpty()) return password

        var check = true
        val pwSplit = password.toCharArray()

        var nextPassword = pwSplit[0].toString()
        var prevWord = pwSplit[0]
        var alreadyDelete = false

        for(i in 1 until pwSplit.size) {
            if(pwSplit[i] == prevWord) {
                if(!alreadyDelete) {
                    alreadyDelete = true
                    nextPassword = nextPassword.substring(0, nextPassword.length-1)
                    check = false
                }
            }
            else {
                alreadyDelete = false
                prevWord = pwSplit[i]
                nextPassword += pwSplit[i]
            }
        }

        if(check) return password
        else password = nextPassword
    }
}