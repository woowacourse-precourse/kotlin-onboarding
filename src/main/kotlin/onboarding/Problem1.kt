package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[0]%2 == 0 || pobi[1]%2 == 1 || pobi[0]+1 != pobi[1]){
        return -1
    }

    if(crong[0]%2 == 0 || crong[1]%2 == 1 || crong[0]+1 != crong[1]){
        return -1
    }

    var x: Int =0
    var y: Int = 1
    var big1 : Int = 0
    var big2 : Int = 0

    for(i: Int in 1..2){
        var input = pobi[i-1]
        while(input != 0){
            x = x+(input%10)
            input = input/10
        }
        if(big1<x){
            big1 = x
        }
        x = 0
    }
    for(i: Int in 1..2){
        var input = pobi[i-1]
        while(input != 0){
            y = y*(input%10)
            input = input/10
        }
        if(big2<y){
            big2 = y
        }
        y=1
    }

    var pob : Int = if(big1 > big2){
        big1
    }else{
        big2
    }
    
    x=0
    y=1
    big1 = 0
    big2 = 0

    for(i: Int in 1..2){
        var input = crong[i-1]
        while(input != 0){
            x = x+(input%10)
            input = input/10
        }
        if(big1<x){
            big1 = x
        }
        x=0
    }

    for(i: Int in 1..2){
        var input = crong[i-1]
        while(input != 0){
            y = y*(input%10)
            input = input/10
        }
        if(big2<y){
            big2 = y
        }
        y = 1
    }

    var cro : Int = if(big1 > big2){
        big1
    }else {
        big2
    }

    return if(pob>cro){
        1
    }else if(pob < cro){
        2
    }else{
        0
    }

    


}
