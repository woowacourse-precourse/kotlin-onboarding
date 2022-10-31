package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
    var pobi_mul: Int
    var pobi_num: Array<Int> = arrayOf(0,0,0,0)
    pobi_num[0] = ( (pobi[0] / 100) + (pobi[0]/10)%10 + (pobi[0] % 10) )
    pobi_num[1] = ( (pobi[1] / 100) + (pobi[1]/10)%10 + (pobi[1] % 10) )
    if (pobi[0]/100 == 0){
        pobi_mul = (pobi[0]/10)%10 * (pobi[0] % 10)
    }else{
        pobi_mul = (pobi[0] / 100) * (pobi[0]/10)%10 * (pobi[0] % 10)
    }
    pobi_num[2] = pobi_mul
    if (pobi[1]/100 == 0){
        pobi_mul = (pobi[1]/10)%10 * (pobi[1] % 10)
    }else{
        pobi_mul = (pobi[1] / 100) * (pobi[1]/10)%10 * (pobi[1] % 10)
    }
    pobi_num[3] = pobi_mul
    // pobi 가장 큰 수
    val result_pobi = pobi_num.maxOrNull()

    // crong 수 구하기
    var crong_mul: Int
    var crong_num: Array<Int> = arrayOf(0,0,0,0)
    crong_num[0] = ( (crong[0] / 100) + (crong[0]/10)%10 + (crong[0] % 10) )
    crong_num[1] = ( (crong[1] / 100) + (crong[1]/10)%10 + (crong[1] % 10) )
    if (crong[0]/100 == 0){
        crong_mul = (crong[0]/10)%10 * (crong[0] % 10)
    }else{
        crong_mul = (crong[0] / 100) * (crong[0]/10)%10 * (crong[0] % 10)
    }
    crong_num[2] = crong_mul
    if (crong[1]/100 == 0){
        crong_mul = (crong[1]/10)%10 * (crong[1] % 10)
    }else{
        crong_mul = (crong[1] / 100) * (crong[1]/10)%10 * (crong[1] % 10)
    }
    crong_num[3] = crong_mul
    // crong 가장 큰 수
    var result_crong = crong_num.maxOrNull()

    // 결과 계산
    var result : Int
    if(result_pobi!! > result_crong!!) result = 1
    else if(result_pobi == result_crong) result = 0
    else if(result_pobi < result_crong) result = 2
    else result = -1

    return result
}