package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
var first:Int
var second:Int
var third:Int
var sum:Int
var pro:Int
var p_score:Int
var c_score:Int

    if (pobi[1]>pobi[0]){
        first= pobi[1]/100
        second= (pobi[1]-first)/10
        third= pobi[1]-(first+second)
        sum=first+second+third
        pro=first*second*third
        if (sum>=pro){
            p_score=sum
        }else{
            p_score=pro
        }


    }else{
        first = pobi[0]/100
        second= (pobi[0]-first)/10
        third= pobi[0]-(first+second)
        sum=first+second+third
        pro=first*second*third
        if (sum>=pro){
            p_score=sum
        }else{
            p_score=pro
        }
    }

    if (crong[1]>crong[0]){
        first= crong[1]/100
        second= (crong[1]-first)/10
        third= crong[1]-(first+second)
        sum=first+second+third
        pro=first*second*third
        if (sum>=pro){
            c_score=sum
        }else{
            c_score=pro
        }


    }else{
        first = crong[0]/100
        second= (crong[0]-first)/10
        third= crong[0]-(first+second)
        sum=first+second+third
        pro=first*second*third
        if (sum>=pro){
            c_score=sum
        }else{
            c_score=pro
        }
    }
  if (pobi[1]-pobi[0]!=1||pobi[0]-pobi[1]!=1||crong[1]-crong[0]!=1||crong[0]-crong[1]!=1
  ||pobi[0]==1||pobi[1]==1||crong[0]==1||crong[1]==1||pobi[0]==400||pobi[1]==400||crong[0]==400||crong[1]==400){
    return -1
  }else{
    if (p_score>c_score){
        return 1
    }else if(p_score<c_score){
        return 2
    }else{
        return 0
    }}
}

