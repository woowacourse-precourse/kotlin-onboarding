package onboarding

fun solution5(money: Int): List<Int> {
    var array =Array(9,{0})
    var i=money

    array[0]=i/50000
    i=i%50000
    array[1]=i/10000
    i=i%10000
    array[2]=i/5000
    i=i%5000
    array[3]=i/1000
    i=i%1000
    array[4]=i/500
    i=i%500
    array[5]=i/100
    i=i%100
    array[6]=i/50
    i=i%50
    array[7]=i/10
    i=i%10
    array[8]=i

    return array.toList()



}
