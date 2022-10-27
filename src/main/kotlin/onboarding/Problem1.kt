package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[1] - pobi[0] != 1)
        return -1;
    if(crong[1] - crong[0] != 1)
        return -1;
    if(pobi[0]+pobi[1] <= pobi[0] * pobi[1]){
        if(crong[0]+crong[1]<crong[0]*crong[1]){
            if(crong[0]*crong[1] < pobi[0]*pobi[1])
                return 1;
            else if(crong[0]*crong[1] > pobi[0]*pobi)
                return 2;
            else
                return 0;
        }
        else{
                if(crong[0]+crong[1] < pobi[0]*pobi[1])
                    return 1;
                else if(crong[0]+crong[1] > pobi[0]*pobi[1] )
                    return 2;
                else
                    return 0;
            }

        }
    else{
        if(crong[0]+crong[1]<crong[0]*crong[1]){
            if(crong[0]*crong[1] < pobi[0]+pobi[1])
                return 1;
            else if(crong[0]*crong[1] > pobi[0]+pobi)
                return 2;
            else
                return 0;
            }
        else{
            if(crong[0]+crong[1] < pobi[0]+pobi[1])
                return 1;
            else if(crong[0]+crong[1] > pobi[0]+pobi[1] )
                return 2;
            else
                return 0;
            }

        }

    }