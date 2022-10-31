package onboarding


fun solution1(pobi: List<Int>, crong: List<Int>): Int {

  var win = -1
  var pobi_max = 0
  var crong_max =0

  //예외처리
  if((pobi[pobi.size-1] - pobi[pobi.size-2] != 1)  or (crong[crong.size-1] - crong[crong.size-2] != 1) ){
      return win
  }
  if((pobi.size > 2) or (crong.size > 2)){
      return win
  }
  if(pobi.contains(1) or pobi.contains(400)){
      return win
  }
  if(crong.contains(1) or crong.contains(400)){
        return win
  }



    if(pobi_max > crong_max){
        win = 1
    }

    if(pobi_max == crong_max){
        win = 0
    }

    if(pobi_max < crong_max){
        win = 2
    }

    return win
}
//각 페이지 자릿수 합과 곱 계산
fun cal_page(num : Int) : List<Int>{

    var hun = num / 100
    var ten = (num % 100) / 10
    var one = (num % 100) % 10

    var sum = hun + ten + one
    var mul = 1

    if(hun >= 1){
        mul = hun * ten * one
    }
    if(hun == 0){
        mul = (num / 10) * (num % 10)
    }

    return listOf(sum, mul)
}








