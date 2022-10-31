package onboarding

fun solution2(cryptogram: String): String {
    var now = cryptogram
    while (true) {
        var new = ""
        for (i in 0..cryptogram.length) {
            if (new.length==0) {new += cryptogram[i]}
            else if(new[-1]!=cryptogram[i]) {new += cryptogram[i]}
        }
        if (now==new) break
        else {now = new}
    }
    return now
}
