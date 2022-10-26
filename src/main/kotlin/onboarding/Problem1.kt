package onboarding

import java.util.*
import kotlin.collections.ArrayList

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

/*    Problem Analysis
    배열 길이는 2 , 0번째 요소는 왼쪽페이지 1번째 요소는 오른쪽 페이지
    숫자를 string으로 형변환하는 방법이 있고, 100,10으로 나눈 몫과
    10으로 나눈 나머지를 모두 더하는 방법도 있다.*/

    val pobi_max:Int=page_calulate(pobi)
    val crong_max:Int=page_calulate(crong)
    @Suppress("ConstantConditionIf")
    if (pobi_max > crong_max){
        return 1
    }else if(pobi_max < crong_max){
        return 2
    }else if(pobi_max == crong_max){
        return 0
    }else{
        return -1
    }

}

fun page_calulate(page_list:List<Int>): Int{

    val temp_list:ArrayList<Int> = arrayListOf<Int>()
    for(page in page_list){
        var temp: Int

        temp = page/100+page/10+page%10
        temp_list.add(temp)

        temp =(page/100)*(page/10)*(page%10)
        temp_list.add(temp)
    }

    return Collections.max(temp_list)
}