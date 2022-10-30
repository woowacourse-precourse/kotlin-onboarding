package onboarding

fun solution3(number: Int): Int {
    var result = 0
    //예외상황 처리
    if (number < 1 || number > 10000){
        return 0
    }

    //3,6,9 들어갔을 때 손뼉 치기
    for (i in 1..number){
        var numString = i.toString().split("").toMutableList()
        numString.removeAt(numString.size-1)
        numString.removeAt(0)

        for (i in (0 until numString.size)){
            if (numString[i] == "3" || numString[i] == "6" || numString[i] == "9")
                result += 1
        }
    }
    return result
}
