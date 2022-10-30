package onboarding
import kotlin.math.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if((pobi.size!=2)||(crong.size!=2)){
        return -1 //list의 사이즈가 2가 아님
    }
    if((pobi[0]%2!=1)||(crong[0]%2!=1)){
        return -1 //시작 페이지가 홀수가 아님
    }
    if((pobi[1]-pobi[0]!=1)||(crong[1]-crong[0]!=1)){
        return -1 // 페이지 번호가 순서대로 정렬되지 않았음
    }
    if((pobi[0]<=1)||(crong[0]<=1)||(pobi[1]>=400)||(crong[1]>=400)){
        return -1 //첫 페이지 혹은 마지막 페이지를 펼칠 수는 없고 페이지의 범위가1부터400이여야함
    }


    var pobiScore:Int=max(maxPlus(pobi), maxMultify(pobi)) //포비의 점수
    var crongScore:Int=max(maxPlus(crong), maxMultify(crong)) // 크롱의 점수

    if(pobiScore>crongScore){
        return 1
    }
    else if (pobiScore<crongScore){
        return 2
    }
    else if(pobiScore==crongScore){
        return 0
    }
    else return -1

}

fun maxPlus(list:List<Int>):Int{  //  자릿수별 합 중 최대값 반환
    var leftSum:Int=0
    var rightSum:Int=0

    var left=list[0]
    var right=list[1]


    while(left!=0){
        leftSum+=left%10
        left/=10
    }
    while (right!=0){
        rightSum+=right%10
        right/=10
    }
    return max(leftSum,rightSum)
}

fun maxMultify(list:List<Int>):Int{ // 자릿수별 곱 중 최대값 반환
    var leftMul:Int=1
    var rightMul:Int=1

    var left:Int=list[0]
    var right:Int=list[1]

    while(left!=0){
        leftMul*=left%10
        left/=10
    }
    while (right!=0){
        rightMul*=right%10
        right/=10
    }
    return max(leftMul,rightMul)
}
