package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
//    TODO("프로그램 구현")

    if (pobi[0]%2 != 1 || pobi[1]%2 != 0 || pobi[0]+1 != pobi[1] || pobi[0]==1 || pobi[1] == 400)
    {
        return -1
    }

    var pobileftplus = 0
    var pobileftmul = 1
    var pobirightplus = 0
    var pobirightmul = 1
    var pobiresult = 0
    var pobiresult2 = 0
    var pobiresult3 = 0
    var crongleftplus = 0
    var crongleftmul = 1
    var crongrightplus = 0
    var crongrightmul = 1
    var crongresult = 0
    var crongresult2 = 0
    var crongresult3 = 0
    // 저장할 변수 선언

    var input = pobi[0]
    while ( input > 0)
    {
        pobileftplus += input % 10
        input /= 10
    }


    var input2 = pobi[0]
    while ( input2 >= 1)
    {
        pobileftmul = pobileftmul * (input2 % 10)
        input2 = input2 / 10
    }

    var input3 = pobi[1]
    while (input3 > 0)
    {
        pobirightplus += input3 % 10
        input3 /= 10
    }
    var input4 = pobi[1]
    while (input4 >= 1)
    {
        pobirightmul *= input4 % 10
        input4 /= 10
    }

    if (pobileftmul > pobileftplus)
    {
        pobiresult = pobileftmul
    }
    else if(pobileftplus > pobileftmul)
    {
        pobiresult = pobileftplus
    }
    else if (pobileftplus == pobileftmul)
    {
        pobiresult = pobileftplus
    }

    if (pobirightmul > pobirightplus)
    {
        pobiresult2 = pobirightmul
    }
    else if(pobirightplus > pobirightmul)
    {
        pobiresult2 = pobirightplus
    }
    else if(pobirightplus == pobirightmul)
    {
        pobiresult2 = pobirightmul
    }

    if (pobiresult > pobiresult2)
    {
        pobiresult3 = pobiresult
    }
    else if (pobiresult2 > pobiresult)
    {
        pobiresult3 = pobiresult2
    }
    else if (pobiresult == pobiresult2)
    {
        pobiresult3 == pobiresult
    }

    var input5 = crong[0]
    while ( input5 > 0)
    {
        crongleftplus += input5 % 10
        input5 /= 10
    }


    var input6 = crong[0]
    while ( input6 >= 1)
    {
        crongleftmul = crongleftmul * (input6 % 10)
        input6 = input6 / 10
    }

    var input7 = crong[1]
    while (input7 > 0)
    {
        crongrightplus += input7 % 10
        input7 /= 10
    }
    var input8 = crong[1]
    while (input8 >= 1)
    {
        crongrightmul *= input8 % 10
        input8 /= 10
    }

    // 각 변수별로 계산값 저장

    if (crongleftmul > crongleftplus)
    {
        crongresult = crongleftmul
    }
    else if(crongleftplus > crongleftmul)
    {
        crongresult = crongleftplus
    }
    else if(crongleftmul == crongleftplus)
    {
        crongresult = crongleftmul
    }

    if (crongrightmul > crongrightplus)
    {
        crongresult2 = crongrightmul
    }
    else if(crongrightplus > crongrightmul)
    {
        crongresult2 = crongrightplus
    }
    else if (crongrightplus == crongrightmul)
    {
        crongresult2 = crongrightmul
    }

    if (crongresult > crongresult2)
    {
        crongresult3 = crongresult
    }
    else if (crongresult2 > crongresult)
    {
        crongresult3 = crongresult2
    }
    else if (crongresult == crongresult2)
    {
        crongresult3 = crongresult2
    }

    if (crongresult3 > pobiresult3)
    {
        return 2
    }
    else if (pobiresult3 > crongresult3)
    {
        return 1
    }
    else if (pobiresult3 == crongresult3)
    {
        return 0
    }
    else
    {
        return -1
    }

    //비교후 return값 설정
}