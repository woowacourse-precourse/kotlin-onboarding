package onboarding
import kotlin.math.*



fun is_not_valid(left:Int,right:Int) : Boolean
{
    if(left <= 1 || right <= 1 || left >= 400 || right >= 400)
        return true
    else if(left == 1 || right == 400)
        return true
    else if(abs(left - right) > 2)
        return true
    else
        return false
}
fun check_num(left : Int, right : Int): Int {
    var l_sum :Int = 0;
    var l_mult :Int = 1;
    var r_sum :Int = 0;
    var r_mult :Int = 1;
    var left_s = left.toString()
    var right_s = right.toString()
    for (i in 0 .. (left_s.length-1))
    {
        l_sum = l_sum + left_s[i].digitToInt()
        l_mult = l_mult * left_s[i].digitToInt()
    }
    for (i in 0..(right_s.length-1))
    {
        r_sum = r_sum + right_s[i].digitToInt()
        r_mult = r_mult * right_s[i].digitToInt()
    }
    //println("l_sum = "+ l_sum)
    //println("l_mult = " +l_mult)
    //println("r_sum = "+ r_sum)
    //println("r_mult = " +r_mult)

    return(maxOf(maxOf(l_sum,l_mult),maxOf(r_sum,r_mult)))
}
fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if((is_not_valid(pobi[0], pobi[1]) || is_not_valid(crong[0], crong[1])))
        return -1
    else {
        var pobi_score: Int
        var crong_score :Int
        //println("pobi_score = " + check_num(pobi[0], pobi[1]))
        pobi_score = check_num(pobi[0], pobi[1])
        //println("crong_score = " + check_num(crong[0], crong[1]))
        crong_score = check_num(crong[0], crong[1])
        if (pobi_score > crong_score)
            return 1
        else if (pobi_score < crong_score)
            return 2
        else
            return 0
    }
}

/*fun main() {
    var intArr:Array<Int> = arrayOf(1, 2, 3, 4)
    //type 생략 가능
    var pobi:List<Int> = listOf(99,102)
    var crong:List<Int> = listOf(211,212)
    var intArr2 = arrayOfNulls<Int>(5)
    //Any는 데이터 타입의 최상위(어느 데이터든 다 들어갈 수 있음)
    var anyArr : Array<Any> = arrayOf(1, "awd", 3.2, 4)
    var ans = solution1(pobi,crong)

    println(ans)
}
*/