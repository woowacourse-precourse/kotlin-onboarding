package onboarding

fun solution3(number: Int): Int {
    var check:Int = 0
    var scan:Int

    if(number<1 || number >10000)
        return -1

    for(i: Int in 1 until number+1){
        scan=0
        var a=(i%10000)/1000//천의 자리수 추출
        if(a!=0 && a%3==0)//3 6 9 확인
            scan=1
        a=(i%1000)/100//백의 자리수 추출
        if(a!=0 && a%3==0 && scan!=1)
            scan=1
        a=(i%100)/10//십의 자리수
        if(a!=0 && a%3==0 && scan!=1)
            scan=1
        a=i%10//일의 자리수
        if(a!=0 && a%3==0 && scan!=1)
            scan=1
        
        if(scan==1)//법칙에 적합하면 check증가
            check++
    }

    return check

}
