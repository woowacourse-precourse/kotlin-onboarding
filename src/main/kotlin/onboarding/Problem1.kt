package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
    var pobi = Array<Int>(2){0}
    var crong = Array<Int>(2){0}
    var point1_add=0
    var point1_multi=0
    var point2_add=0
    var point2_multi=0
    var max1=0
    var max2=0

    if(pobi[1]-pobi[0]!=1){
        return -1
    }
    else{
        for(i in 0..1){
            point1_add = add_point(pobi[i])
            max1 = compare(point1_add, max1)
            point1_multi = multi_point(pobi[i])
            max1 = compare(max1, point1_multi)
        }
        for(i in 0..1){
            var point2_add = add_point(crong[i])
            max2 = compare(point2_add, max2)
            var point2_multi = multi_point(crong[i])
            max2 = compare(max2, point2_multi)
        }
        if(max1 == max2){
            return 0
        }
        else if(compare(max1, max2) == max1){
            return 1
        }
        else if(compare(max1,max2) == max2){
            return 2
        }
        else{
            return -1
        }
    }
}
fun compare(data: Int, data2: Int):Int{
    if(data>data2){
        return data
    }
    else{
        return data2
    }
}
fun add_point(data:Int):Int{
    var max1=0
    var point1 = data
    while(true){
        max1 += point1%10
        point1/=10
        if(point1 == 0){
            break
        }
    }
    return max1
}
fun multi_point(data:Int):Int{
    var max1=1
    var point1 = data
    while(true){
        max1 *= point1%10
        point1/=10
        if(point1 == 0){
            break
        }
    }
    return max1
}