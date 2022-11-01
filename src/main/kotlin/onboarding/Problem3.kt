package onboarding



fun solution3(number: Int): Int {


   return count_369(number)




}
//3 6 9가 들어간 숫자를 계산하는 함수
fun count_369(number: Int) : Int{
    var count = 0

    for(i in 1..number){

        var current = i

        while( current != 0){

            if(  (current % 10 == 3 || current % 10 == 6 || current % 10 == 9) ){
                count++
            }
            current /= 10
        }
    }

    return count
}