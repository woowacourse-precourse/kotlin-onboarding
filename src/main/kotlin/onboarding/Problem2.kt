package onboarding

fun solution2(cryptogram: String): String {
    var temp = cryptogram
    var c = 0
    while(c < temp.length){
        if(c<temp.length-1 && temp[c] == temp[c+1]){
            var i = c
            while(i<temp.length && temp[i]==temp[c]){
                i++
            }
            temp = temp.substring(0 until c) + temp.substring(i until temp.length )
            c=0
            continue
        }
        c++
    }
    return temp
}
