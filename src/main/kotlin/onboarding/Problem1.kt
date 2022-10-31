package onboarding
import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiMax = getMaxPageByList(pobi) // pobi's max page
    val crongMax = getMaxPageByList(crong) // crong's max page

    // return value
    var result = 0 // undecided match
    if (pobiMax > crongMax) result = 1 // pobi win
    if (pobiMax < crongMax) result = 2 // crong win
    if (!(isValid(pobi) && isValid(crong))) result = -1 // exception case

    return result
}
fun getMaxPageByList(mylist: List<Int>): Int{
    // max(maxLeftPage, maxRightPage)
    return max(getMaxPage(mylist[0]), getMaxPage(mylist[1]))
}

fun getMaxPage(pageNum: Int = 0): Int{
    // add all digits
    var plusNum = 0
    var page = pageNum
    while (page > 0){
        plusNum += page%10
        page /= 10
    }

    // multiply all digits
    var multiNum = 1
    page = pageNum
    while (page > 0) {
        multiNum *= page%10
        page /= 10
    }
    // get max of plus and multiply of digits
    return max(plusNum, multiNum)
}

fun isValid(pageList: List<Int>): Boolean{
    // check if the page is valid
    val diffCheck = (pageList[1] - pageList[0] == 1)
    var pageCheck = (pageList[0]%2 == 1 && pageList[1]%2 == 0)
    var rangeCheck = (pageList[0] in 1..400 && pageList[1] in 1..400)
    return (diffCheck && pageCheck && rangeCheck)
}