package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobiNum=0
    var crongNum=0
    var addNum: Int
    var mulNum: Int
    var tempNum: Int
    if(!(pobi[0] % 2==1 && pobi[0]+1== pobi[1] && pobi[0]>=1 && pobi[1]<=400)){
        return -1
    }
    if(!(crong[0] % 2==1 && crong[0]+1== crong[1] && crong[0]>=1 && crong[1]<=400)){
        return -1
    }
    for(i in pobi){
        addNum = addNumber(i)
        mulNum = mulNumber(i)
        tempNum= compareNumber(addNum,mulNum)
        pobiNum= compareNumber(pobiNum,tempNum)
    }
    for(i in crong){
        addNum = addNumber(i)
        mulNum = mulNumber(i)
        tempNum= compareNumber(addNum,mulNum)
        crongNum= compareNumber(crongNum,tempNum)
    }
    if(pobiNum > crongNum){
        return 1
    }
    if(pobiNum < crongNum){
        return 2
    }
    if(pobiNum == crongNum){
        return 0
    }
    return -1
}

fun compareNumber(num1: Int,num2:Int):Int{
    if(num1>num2){
        return num1
    }
    return num2
}
fun addNumber(num : Int): Int {
    var n=num
    var returnNum =0
    while(n!=0) {
        returnNum += n % 10
        n /= 10
    }
    return returnNum;
}
fun mulNumber(num : Int):Int{
    var n=num
    var returnNum=1
    while(n!=0) {
        returnNum *= n % 10
        n /= 10
    }
    return returnNum
}
