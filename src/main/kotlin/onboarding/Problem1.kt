package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1]-pobi[0]!=1){
        return -1
    }

    if (crong[1]-crong[0]!=1){
        return -1
    }

    if (pobi[0]==1 || crong[0]==1 || pobi[1]==400 || crong[1]==400){
        return -1
    }

    var pobi_left_sum=0
    var pobi_temp_1=pobi[0]

    while(pobi_temp_1!=0){
        pobi_left_sum+=pobi_temp_1%10
        pobi_temp_1/=10
    }
    var pobi_left_mul=1
    var pobi_temp_2=pobi[0]

    while(pobi_temp_2!=0){
        pobi_left_mul*=pobi_temp_2%10
        pobi_temp_2/=10
    }

    var pobi_right_sum=0
    var pobi_temp_3=pobi[1]

    while(pobi_temp_3!=0){
        pobi_right_sum+=pobi_temp_3%10
        pobi_temp_3/=10
    }

    var pobi_right_mul=1
    var pobi_temp_4=pobi[1]

    while(pobi_temp_4!=0){
        pobi_right_mul*=pobi_temp_4%10
        pobi_temp_4/=10
    }

    var crong_left_sum=0
    var crong_temp_1=crong[0]

    while(crong_temp_1!=0){
        crong_left_sum+=crong_temp_1%10
        crong_temp_1/=10
    }
    var crong_left_mul=1
    var crong_temp_2=crong[0]

    while(crong_temp_2!=0){
        crong_left_mul*=crong_temp_2%10
        crong_temp_2/=10
    }

    var crong_right_sum=0
    var crong_temp_3=crong[1]

    while(crong_temp_3!=0){
        crong_right_sum+=crong_temp_3%10
        crong_temp_3/=10
    }

    var crong_right_mul=1
    var crong_temp_4=crong[1]

    while(crong_temp_4!=0){
        crong_right_mul*=crong_temp_4%10
        crong_temp_4/=10
    }

    var pobi_data=listOf<Int>(pobi_left_sum,pobi_left_mul,pobi_right_sum,pobi_right_mul)
    var pobi_data2=pobi_data.sorted().toMutableList()

    var crong_data=listOf<Int>(crong_left_sum,crong_left_mul,crong_right_sum,crong_right_mul)
    var crong_data2=crong_data.sorted().toMutableList()

    if(pobi_data2[3]>crong_data2[3]){
        return 1
    }
    else if(pobi_data2[3]<crong_data2[3]){
        return 2
    }
    else{
        return 0
    }
}


