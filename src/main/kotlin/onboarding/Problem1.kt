package onboarding

import java.lang.Integer.max

fun calcMaxValue(num:Int):Int{
    val numString=num.toString()
    var plus=numString[0].digitToInt()
    var mult=numString[0].digitToInt()

    for(i in 1 until numString.length){
        plus+=numString[i].digitToInt()
        mult*=numString[i].digitToInt()
    }

    return max(plus,mult)
}
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiLeft=pobi[0]
    val pobiRight=pobi[1]
    val crongLeft=crong[0]
    val crongRight=crong[1]

    if(pobiRight-pobiLeft!=1 || crongRight-crongLeft!=1){
        return -1
    }

    val pobiMax=max(calcMaxValue(pobiLeft), calcMaxValue(pobiRight))
    val crongMax=max(calcMaxValue(crongLeft), calcMaxValue(crongRight))

    return if(pobiMax>crongMax){
        1
    }else if(pobiMax==crongMax){
        0
    }
    else{
        2
    }


}

