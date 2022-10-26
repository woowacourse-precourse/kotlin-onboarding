package onboarding

fun solution3(number: Int): Int {
    var clapCount=0
    for(eachNum in 1..number){
        clapCount+=eachNum.toString().count{c -> c=='3'}+
                eachNum.toString().count{c->c=='6'}+
                eachNum.toString().count{c->c=='9'}
    }

    return clapCount

}
