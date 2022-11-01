package onboarding

fun solution5(money: Int): List<Int> {
    var inter : Int
    var List = mutableListOf<Int>()
    List[0]=money/50000
    inter=money-(50000*List[0])
    List[1]=inter/10000
    inter=inter-(10000*List[1])
    List[2]=inter/5000
    inter=inter-(5000*List[2])
    List[3]=inter/1000
    inter=inter-(1000*List[3])
    List[4]=inter/500
    inter=inter-(500*List[4])
    List[5]=inter/100
    inter=inter-(100*List[5])
    List[6]=inter/50
    inter=inter-(50*List[6])
    List[7]=inter/10
    List[8]=inter%10

}
