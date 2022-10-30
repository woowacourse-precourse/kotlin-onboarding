package onboarding

//기능별 목록
//1.변환한 돈을 저장한 리스트를 만든다.
//2.주어진 돈을 주어진 화폐의 큰 단위부터 변환한다.
fun solution5(money: Int): List<Int> {

    return changemoney(money)
}

fun changemoney(money: Int): MutableList<Int>{
    val solutionList:MutableList<Int> = mutableListOf(0,0,0,0,0,0,0,0,0)   //변환한 돈을 저장한 리스트를 만든다.
    var change:Int= money

    if(money>=50000){   //주어진 돈을 주어진 화폐의 큰 단위부터 변환한다.
        solutionList[0]=money/50000
        change = money-(50000*solutionList[0])
    }
    if(change>=10000){
        solutionList[1]=change/10000
        change -= (10000 * solutionList[1])
    }
    if(change>=5000){
        solutionList[2]=change/5000
        change -= (5000 * solutionList[2])
    }
    if(change>=1000){
        solutionList[3]=change/1000
        change -= (1000 * solutionList[3])
    }
    if(change>=500){
        solutionList[4]=change/500
        change -= (500 * solutionList[4])
    }
    if(change>=100){
        solutionList[5]=change/100
        change -= (100 * solutionList[5])
    }
    if(change>=50){
        solutionList[6]=change/50
        change -= (50 * solutionList[6])
    }
    if(change>=10){
        solutionList[7]=change/10
        change -= (10 * solutionList[7])
    }
    if(change>=1){
        solutionList[8]=change
    }

    return solutionList
}
