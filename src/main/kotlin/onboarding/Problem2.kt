package onboarding

fun solution2(cryptogram: String): String {
    var inputstr: String = cryptogram
    var flag:Boolean = true

    while (flag) {
        var word = inputstr.chunked(1).toMutableList()
        for (i in 0..word.size - 2) {
            if (word[i] == word[i + 1]) {
                if (i != word.size - 2) {
                    if (word[i + 1] != word[i + 2]) {
                        word[i] = "*"
                        word[i + 1] = "*"

                    } else {
                        word[i] = "*"
                        word[i + 1] = "*"
                        word[i + 2] = "*"
                    }
                } else {
                    word[i] = "*"
                    word[i + 1] = "*"
                }
            }
        }
        inputstr = word.joinToString("").replace("*", "")
        for (i in 0..inputstr.length-2){
            if (inputstr[i]==inputstr[i+1]){
                flag = true
                break;
            }
            flag=false
        }
        if(inputstr.length==0 || inputstr.length == 1)
            flag=false
    }
    return inputstr
}
