package onboarding
import kotlin.math.*

fun sum(x_: Int): Int{
    var ret=0
    var x=x_
    while(x!=0){
        ret+=x%10
        x/=10
    }

    return ret
}

fun multi(x_: Int): Int{
    var ret=1
    var x=x_
    while(x!=0){
        ret*=x%10
        x/=10
    }

    return ret
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobi_score=0
    var crong_score=0

    // 예외처리
        // 첫페이지나 마지막 페이지일 경우
    for(i in 0..1){
        if(pobi[i]<=2 || 399<=pobi[i]) return -1
        if(crong[i]<=2 || 399<=crong[i]) return -1
    }
        // 두 페이지가 연속되지 않을 경우
    if(pobi[0]+1!=pobi[1]) return -1
    if(crong[0]+1!=crong[1]) return -1

    // 승자 가리기
    for(i in 0..1){
        var tmp1= max(sum(pobi[i]), multi(pobi[i]))
        var tmp2= max(sum(crong[i]), multi(crong[i]))
        if(pobi_score<tmp1) pobi_score=tmp1
        if(crong_score<tmp2) crong_score=tmp2
    }

    if(pobi_score>crong_score) return 1
    else if(pobi_score<crong_score) return 2
    else return 0
}
