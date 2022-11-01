package onboarding

import java.lang.Integer.max
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) {
        return -1;
    }
    var pobi_max:Int = max(calculate_max(pobi[0]),calculate_max(pobi[1]))
    var crong_max:Int = max(calculate_max(crong[0]),calculate_max(crong[1]));
    if(pobi_max > crong_max){
        return 1;
    }else if(pobi_max < crong_max){
        return 2;
    }else if(pobi_max == crong_max){
        return 0;
    }else{
        return -1;
    }
}
fun calculate_max(tmp: Int):Int{
    var tmp_list = emptyList<Int>();
    var cmp:Int = tmp;
    while(cmp > 0){
        tmp_list += tmp % 10;
        cmp /= 10;
    }
    var tmp_multiple = 1
    var tmp_add = 0
    for(i in tmp_list) {
        tmp_multiple *= i
        tmp_add += i
    }
    return max(tmp_add,tmp_multiple);
}