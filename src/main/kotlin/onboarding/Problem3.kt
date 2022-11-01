package onboarding

// 기능 1 : 수를 받으면 각 자릿수의 숫자 추출하기
// 기능 2 : 추출한 숫자에서 3,6,9가 들어가면 cnt에 1을 더해주기
fun solution3(number: Int): Int {
var cnt = 0
    fun ok(num:Int){
        var num2 = num
        var a = num2/1000 //천의자리
        num2 -=  a*1000
        if(a == 3 || a == 6|| a == 9) cnt++
        var b = num2/100 //백의자리
        num2 -= b*100
        if(b == 3 || b == 6|| b == 9) cnt++
        var c = num2/10 //십의자리
        num2 -= c*10
        if(c == 3 || c == 6|| c == 9) cnt++
        var d = num%10//일의자리
        if(d == 3 || d == 6|| d == 9) cnt++


    }

    for(i in 1 until number+1){
        ok(i)
    }
    return cnt

}
