package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {


    var ok = 1;

    fun ok(now : List<Int>){
        if(now[0] != now[1]-1) ok = 0;
        if(now[0]<=0||now[1]>=400) ok = 0;
    }
    ok(pobi)
    ok(crong)
    if(ok == 0) return -1

    var pobih = 0
    var pobig = 1

    ///포비
    if(pobi[0]/100!=0) {
        pobih +=pobi[0]/100
        pobig *=pobi[0]/100

        pobih += (pobi[0] - pobi[0]/100*100)/10
        pobig *= (pobi[0] - pobi[0]/100*100)/10

        pobih += pobi[0]%10
        pobig *= pobi[0]%10


    }else if(pobi[0]/10!=0){
        pobih+=pobi[0]/10
        pobig*=pobi[0]/10

        pobih+=pobi[0]%10
        pobig*=pobi[0]%10

    }else{
        pobih+=pobi[0]
        pobig*=pobi[0]
    }
    var pobil = 0
    if(pobih>=pobig) pobil = pobih
    else pobil = pobig

    pobih = 0
    pobig = 1

  //포비오른쪽
    if(pobi[1]/100!=0) {
        pobih +=pobi[1]/100
        pobig *=pobi[1]/100

        pobih += (pobi[1] - pobi[1]/100*100)/10
        pobig *= (pobi[1] - pobi[1]/100*100)/10

        pobih += pobi[1]%10
        pobig *= pobi[1]%10


    }else if(pobi[1]/10!=0){
        pobih+=pobi[1]/10
        pobig*=pobi[1]/10

        pobih+=pobi[1]%10
        pobig*=pobi[1]%10

    }else{
        pobih+=pobi[1]
        pobig*=pobi[1]
    }
    var pobir = 0
    if(pobih>=pobig) pobir = pobih
    else pobir = pobig

    var pobimax = 0

    if(pobil > pobir)  pobimax = pobil
    else pobimax = pobir



    //크롱
    var crongh = 0
    var crongg = 1

    if(crong[0]/100!=0) {
        crongh +=crong[0]/100
        crongg *=crong[0]/100

        crongh += (crong[0] - crong[0]/100*100)/10
        crongg *= (crong[0] - crong[0]/100*100)/10

        crongh += crong[0]%10
        crongg *= crong[0]%10


    }else if(crong[0]/10!=0){
        crongh+=crong[0]/10
        crongg*=crong[0]/10

        crongh+=crong[0]%10
        crongg*=crong[0]%10

    }else{
        crongh+=crong[0]
        crongg*=crong[0]
    }

    var crongl = 0
    if(crongh>crongg) crongl = crongh
    else crongl = crongg

    crongh = 0
    crongg = 1

    if(crong[1]/100!=0) {
        crongh +=crong[1]/100
        crongg *=crong[1]/100

        crongh += (crong[1] - crong[1]/100*100)/10
        crongg *= (crong[1] - crong[1]/100*100)/10

        crongh += crong[1]%10
        crongg *= crong[1]%10


    }else if(crong[1]/10!=0){
        crongh+=crong[1]/10
        crongg*=crong[1]/10

        crongh+=crong[1]%10
        crongg*=crong[1]%10

    }else{
        crongh+=crong[1]
        crongg*=crong[1]
    }

    var crongr = 0
    if(crongg>crongh) crongr = crongg
    else crongr = crongh

    var crongmax = 0;
    if(crongr >crongl) crongmax = crongr
    else crongmax = crongl

    if(crongmax > pobimax) return 2
    else if(crongmax == pobimax) return 0
    else return 1


}
