package onboarding

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val pobi_win = 1
val crong_win = 2
val draw = 0
val exception_point = -1

fun solution1(pobi: List<Int>, crong: List<Int>): Int {


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









  return exception_point
}



