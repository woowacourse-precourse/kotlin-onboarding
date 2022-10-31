package onboarding

fun solution2(cryptogram: String): String {
    var inputString = cryptogram
    var resultString = deleteRepeat(inputString)
    while(inputString!=resultString && resultString!=""){
        inputString=resultString
        resultString= deleteRepeat(inputString)
    }
    return resultString
}
fun deleteRepeat(s:String): String {
    var inputString=s
    var length = inputString.length
    if(length==1){
        return inputString
    }
    var result=""
    if(inputString[0]!=inputString[1]){
        result+=inputString[0]
    }
    for(i in 1..length-2){
        result+= repeatString(inputString,i)
    }
    if(inputString[length-1]!=inputString[length-2]){
        result+=inputString[length-1]
    }
    return result
}
fun repeatString(s:String, idx:Int): String {
    if(s[idx]!=s[idx-1] && s[idx]!=s[idx+1]){
        return s[idx].toString()
    }
    return ""
}
