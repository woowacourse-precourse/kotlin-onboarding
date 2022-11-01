package onboarding


fun calc(n:Int,clap:Int):Int{
    var cnt=clap;
    if(n<=0){
        return cnt;
    }
    val temp=n%10;
    if((temp==3)||(temp==6)||(temp==9)){
        cnt+=1;
    }
    return calc(n/10,cnt);

}
fun solution3(number: Int): Int {
    var sum=0;

    for(i:Int in 1..number){
        var result=calc(i,0);
        sum+=result;
    }
    return sum;

}
