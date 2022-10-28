package onboarding

//연속하는 중복 문자 삭제 함수
fun dec(cryptogram: String): String{
    var str = cryptogram
    var size = str.length
    while(true){
        var i = 0
        var check = false
        while(i < size-1)
        {
            if(str[i]==str[i+1]){
                check = true
                if(i==size-2)
                    str = str.substring(0..size-3)
                else
                    str = str.substring(0..i-1) + str.substring(i+2..size-1)
                size = str.length
                i-=2
            }
            i++
        }
        if(!check)
            break
    }
    return str
}
fun solution2(cryptogram: String): String {
    return dec(cryptogram)
}
