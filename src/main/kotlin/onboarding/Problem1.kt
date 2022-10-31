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

    pobi_max = compare_max(pobi[0],pobi[1])
    crong_max = compare_max(crong[0],crong[1])


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
//왼쪽과 오른쪽의 페이지 크기 비교
fun compare_max(left : Int, right : Int) : Int{

    var list_left = cal_page(left)
    var list_right = cal_page(right)

    var left_max  =  list_left[0]
    var right_max =  list_right[0]

    if(list_left[0] < list_left[1]){
        left_max = list_left[1]
    }

    if(list_right[0] < list_right[1]){
        right_max = list_right[1]
    }

    var max = 0

    if(left_max > right_max){
        max = left_max
    }

    if(left_max <= right_max){
        max = right_max
    }
        return max
}







