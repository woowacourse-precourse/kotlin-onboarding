package onboarding



fun compare(a:Int,b:Int):Int{
    return if(a>b){
        a;
    }else{
        b;
    }

}


fun calcSum(n:Int,s:Int):Int{
    var sum=s;
    if(n<=0){
        return sum;
    }
    sum+=n%10;
    return calcSum(n/10,sum);

}
fun calcMul(n:Int,m:Int):Int{
    var mul=m;
    if(n<=0){
        return mul;
    }
    mul*=n%10;
    return calcMul(n/10,mul);
}
fun isValid(a:Int,b:Int):Boolean{
    return b==a+1
}


fun solution1(pobi: List<Int>, crong: List<Int>): Int {


    if(!(isValid(pobi[0],pobi[1])&&isValid(crong[0],crong[1]))){
        return -1;
    }


    var left=compare(calcSum(pobi[0],0),calcMul(pobi[0],1));//왼쪽
    var right=compare(calcSum(pobi[1],0),calcMul(pobi[1],1));//오른쪽큰수찾기
    val p=compare(left,right);

    left=compare(calcSum(crong[0],0),calcMul(crong[0],1));//왼쪽큰수찾기
    right=compare(calcSum(crong[1],0),calcMul(crong[1],1));//오른쪽큰수찾기
    val c=compare(left,right);


    return if(p>c){
        1;
    }else if(p<c) {
        2;
    }else{
        0;
    }


}
