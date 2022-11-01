package onboarding


fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //TODO("프로그램 구현")
    
    if((is_not_val(pobi[0], pobi[1]) || is_not_val(crong[0], crong[1])))
        return -1
    
    var pobi_r  : Int = comparepage(multipage(pobi[0]), sumpage(pobi[0]));
    var crong_r : Int = comparepage(multipage(crong[0]), sumpage(crong[0]));

    when {
        pobi_r > crong_r -> return 1;
        pobi_r < crong_r -> return 2;
        pobi_r == crong_r -> return 0;
    }
}


fun is_not_val(left:Int,right:Int) : Boolean
{
    if(left <= 1 || right <= 1 || left >= 400 || right >= 400)
        return true
    else if(left == 1 || right == 400)
        return true
    else if((left - right) > 2)
        return true
    else
        return false
}

fun sumpage(left:Int): Int
{
    var sum : Int = 0;
    var sum_r : Int = 0;
    var t_left : Int = left;
    var t_right :Int = left + 1;
    while(t_left != 0)
    {
    sum += left % 10
    t_left /= 10
    sum_r += t_right % 10
    t_right /= 10
    }
    
}

fun multipage(left : Int) : Int
{
    var multi : Int = 1;
    var multi_r : Int = 1;
    var t_left : Int = left;
    var t_right : Int = left + 1;
    while( t_left !=0)
    {
        multi *= left % 10
        t_left /= 10
        multi_r *= t_right % 10
        t_right /= 10
    }
}

fun comparepage(multi_p : Int, sum_p : Int): Int
{
    if(multi_p < sum_p)
        return (sum_p)
    else
        return (multi_p)
}