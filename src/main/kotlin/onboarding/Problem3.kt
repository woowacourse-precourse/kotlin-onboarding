package onboarding

fun solution3(number: Int): Int {
    var result=0
    for(i in 1 .. number){
        result+= countCrap(i)
    }
    return result
}
fun countCrap(num : Int): Int {
    var n=num
    var crapNum =0
    while(n!=0) {
        crapNum += isCrap(n % 10)
        n /= 10
    }
    return crapNum
}
fun isCrap(n : Int): Int{
    if(n==3 || n==6 || n==9){
        return 1
    }
    return 0
}
