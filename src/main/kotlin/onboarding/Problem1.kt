package onboarding

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.io.path.createTempDirectory

val pobi_win = 1
val crong_win = 2
val draw = 0
val exception_point = -1

fun solution1(pobi: List<Int>, crong: List<Int>): Int {


  if((pobi[pobi.size-1] - pobi[pobi.size-2] != 1)  or (crong[crong.size-1] - crong[crong.size-2] != 1) ){
      return exception_point
  }

  if((pobi.size > 2) or (crong.size > 2)){
      return exception_point
  }

  if(pobi.contains(1) or pobi.contains(400)){
      return exception_point
  }

    if(crong.contains(1) or crong.contains(400)){
        return exception_point
    }


  var pobi_max_sum = 0
  var pobi_max_mul = 1
  var pobi_sum = 0
  var pobi_mul = 1
  var pobi_max = 0

  for(i in 0 until 2){
     pobi_sum = (pobi[i] / 100) + (pobi[i] % 100 / 10) + (pobi[i] % 100 % 10)
     if(pobi_sum > pobi_max_sum){
        pobi_max_sum = pobi_sum
     }

     if( pobi[i] >= 100){
        pobi_mul = (pobi[i] / 100) * (pobi[i] % 100 / 10) * (pobi[i] % 100 % 10)
     }
     if( pobi[i] < 100){
        pobi_mul = (pobi[i] / 10) * (pobi[i] % 10)
     }

     if(pobi_mul > pobi_max_mul){
        pobi_max_mul = pobi_mul
     }
  }

   if(pobi_max_mul > pobi_max_sum){
      pobi_max = pobi_max_mul
   }
   if (pobi_max_sum >= pobi_max_mul){
      pobi_max = pobi_max_sum
   }


    var crong_max_sum = 0
    var crong_max_mul = 1
    var crong_sum = 0
    var crong_mul = 1
    var crong_max = 0

    for(i in 0 until 2){
        crong_sum = (crong[i] / 100) + (crong[i] % 100 / 10) + (crong[i] % 100 % 10)
        if(crong_sum > crong_max_sum){
            crong_max_sum = crong_sum
        }

        if( crong[i] >= 100){
            crong_mul = (crong[i] / 100) * (crong[i] % 100 / 10) * (crong[i] % 100 % 10)
        }
        if( crong[i] < 100){
            crong_mul = (crong[i] / 10) * (crong[i] % 10)
        }

        if(crong_mul > crong_max_mul){
            crong_max_mul = crong_mul
        }
    }

    if(crong_max_mul > crong_max_sum){
        crong_max = crong_max_mul
    }
    if (crong_max_sum >= crong_max_mul){
        crong_max = crong_max_sum
    }


    if(pobi_max > crong_max){
        return pobi_win
    }

    if(pobi_max == crong_max){
        return draw
    }

    if(pobi_max < crong_max){
        return crong_win
    }


    return exception_point
}



