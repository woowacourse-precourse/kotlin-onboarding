package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    //연속 되는 값인지 체크
    var c=pobi[0]+1
    if(c!=pobi[1])
        return -1

    c=crong[0]+1
    if(c!=crong[1])
        return -1
    
    //시작값이 홀수 맞는지 체크
    c=pobi[0]%2
    var d=crong[0]%2
    if(c==0 || d==0)
        return -1

    //1~400을 벗어나지 않는지 체크
    if(pobi[0]<1||crong[0]<1||pobi[0]>=400||crong[0]>=400)
        return -1



    //pobi 계산

    val a = solsub1(pobi)
    val b = solsub1(crong)

    if(a>b)//pobi win
        return 1
    if(a<b)//crong win
        return 2    

    return 0//draw


}


fun solsub1(sol: List<Int>): Int{
    var a = 1//곱
    var b = 0//덧

    //곱셈 먼저
    if(sol[0]>=100){//100의 자리수
        a= a*sol[0]/100
        a= a*sol[1]/100
    }
    if(sol[0]>=10){//10의 자리수
        a= a * ((sol[0]%10)/10)
        a= a * ((sol[1]%10)/10)
    }
    a=a*(sol[0]%10)//1의 자리수
    a=a*(sol[1]%10)

    //덧셈
    if(sol[0]>=100){//100의 자리수
        b=b+sol[0]/100
        b=b+sol[1]/100
    }
    if(sol[0]>=10){//10의자리수
        b=b+((sol[0]%10)/10)
        b=b+((sol[1]%10)/10)
        if(sol[0]==99){//sol[0]== 99 sol[1]==100 일때
            b+=1
        }
    }
    b=b+sol[0]%10
    b=b+sol[1]%10
    if(sol[0]==9){
        b+=1
    }
    
    if(a>b)
        return a

    return b

}
