package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1] || pobi[0] <= 0 || pobi[0] >=400 || crong[0]<=0 || crong[0]>=400){
        return -1
    }
    var input:Array<Int> = arrayOf(pobi[0], pobi[1], crong[0], crong[1])
    var temp:Array<Int> = arrayOf(0, 1, 0, 1, 0, 1, 0, 1)
    while(input[0]>0 || input[1] >0 || input[2] > 0 || input[3] > 0){
        if(input[0]>0){
            var t = input[0]%10
            temp[0] += t
            temp[1] *= t
            input[0]/=10
        }
        if(input[1]>0){
            var t = input[1]%10
            temp[2] += t
            temp[3] *= t
            input[1]/=10
        }
        if(input[2]>0){
            var t = input[2]%10
            temp[4] += t
            temp[5] *= t
            input[2]/=10
        }
        if(input[3]>0){
            var t = input[3]%10
            temp[6] += t
            temp[7] *= t
            input[3]/=10
        }
    }
    var max_index = -1
    var max = -1
    var draw = false
    for(i in 0 until temp.count()){
        if(max<temp[i]){
            max = temp[i]
            max_index= i
            draw = false
        }
        if(max == temp[i] && max_index<=3 && i>3){
            draw = true
        }
    }
    if(draw){
        return 0
    }
    if(max_index<=3){
        return 1
    }
    else{
        return 2
    }

}
