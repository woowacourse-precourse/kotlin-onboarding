package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[0]%2 == 0 || pobi[1]%2 == 1 || pobi[0]+1 != pobi[1]){
        return -1
    }

    if(crong[0]%2 == 0 || crong[1]%2 == 1 || crong[0]+1 != crong[1]){
        return -1
    }

    val pob : Int = if(pobi[0]+pobi[1]>pobi[0]*pobi[1]){
        pobi[0]+pobi[1]
    }else{
        pobi[0]*pobi[1]
    }

    val cro : Int = if(crong[0]+crong[1]>crong[0]*crong[1]){
        crong[0]+crong[1]
    }else{
        crong[0]*crong[1]
    }

    return if(pob>cro){
        1
    }else if(pob < cro){
        2
    }else{
        0
    }

    


}
