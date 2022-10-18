package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobi1: Int = pobi.get(0)
    var crong1: Int = crong.get(0)

    var pobilist: Array<Int> = arrayOf(0,0,0)
    var pobimax1 : Int = 0
    var pobimax2 : Int = 1
    var pobimax : Int

    var cronglist : Array<Int> = arrayOf(0,0,0)
    var crongmax1 : Int = 0
    var crongmax2 : Int = 1
    var crongmax : Int

    var count : Int = 0

    if(pobi.get(1) - pobi.get(0) != 1)
        return -1
    if(crong.get(1) - crong.get(0) != 1)
        return -1
    ///////////////////////////////////
    while(true){
        pobilist[count] = pobi1%10
        pobi1 = pobi1/10
        if(pobi1 == 0)
            break
        count++
    }
    for (i: Int in 0..count)
        pobimax1 += pobilist[i]
    for (i: Int in 0..count)
        pobimax2 *= pobilist[i]

    if(pobimax1 < pobimax2)
        pobimax = pobimax2
    else
        pobimax = pobimax1

    pobimax1 = 0
    pobimax2 = 1
    count = 0

    pobi1 = pobi.get(1)
    while(true){
        pobilist[count] = pobi1%10
        pobi1 = pobi1/10
        if(pobi1 == 0)
            break
        count++
    }
    for (i in 0..count)
        pobimax1 += pobilist[i]
    for (i in 0..count)
        pobimax2 *= pobilist[i]

    if(pobimax1<=pobimax2){
        if(pobimax < pobimax2)
            pobimax = pobimax2
    }
    else{
        if(pobimax < pobimax1)
            pobimax = pobimax1
    }

    count = 0
    ///////////////////////////////
    while(true){

        cronglist[count] = crong1%10
        crong1 = crong1/10
        if(crong1 == 0)
            break
        count++
    }
    for (i in 0..count)
        crongmax1 += cronglist[i]
    for (i in 0..count)
        crongmax2 *= cronglist[i]

    if(crongmax1 < crongmax2)
        crongmax = crongmax2
    else
        crongmax = crongmax1

    crongmax1 = 0
    crongmax2 = 1
    count = 0

    crong1 = crong.get(1)
    while(true){

        cronglist[count] = crong1%10
        crong1 = crong1/10
        if(crong1 == 0)
            break
        count++
    }
    for (i in 0..count)
        crongmax1 += cronglist[i]
    for (i in 0..count)
        crongmax2 *= cronglist[i]

    if(crongmax1 < crongmax2){
        if(crongmax < crongmax2)
            crongmax = crongmax2
    }
    else{
        if(crongmax < crongmax1)
            crongmax = crongmax1
    }
    ///////////////////////////////
    if(pobimax < crongmax)
        return 2
    else if(pobimax > crongmax)
        return 1
    else
        return 0

}