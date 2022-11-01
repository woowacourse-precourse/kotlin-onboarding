package onboarding
//기능 1: 금액을 큰 수로부터 나눠서 0이 아니면 나눈 몫을 배열에 두고 해당 수만큼 mon에서 빼준다

fun solution5(money: Int): List<Int> {
   val list:MutableList<Int> = mutableListOf<Int>(0,0,0,0,0,0,0,0,0)


    var mon = money
    if(mon /50000 != 0){
        list[0] = (mon/50000)
        mon -= list[0]*50000
    }
    if(mon /10000 != 0){
        list[1] = (mon/10000)
        mon -= list[1]*10000
    }
    if(mon /5000 != 0){
        list[2] = (mon/5000)
        mon -= list[2]*5000
    }
    if(mon /1000 != 0){
        list[3] = (mon/1000)
        mon -= list[3]*1000
    }
    if(mon /50000 != 0){
        list[4] = (mon/50000)
        mon -= list[4]*50000
    }
    if(mon /500 != 0){
        list[5] = (mon/500)
        mon -= list[5]*500
    }
    if(mon /100 != 0){
        list[6] = (mon/100)
        mon -= list[6]*100
    }
    if(mon /10 != 0){
        list[7] = (mon/10)
        mon -= list[7]*10
    }
    if(mon /1 != 0){
        list[8] = (mon/1)
        mon -= list[8]*1
    }

    return list
}
