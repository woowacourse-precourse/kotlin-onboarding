package onboarding

fun solution3(number: Int): Int {
    var count:Int = 0
    var clap:Int

    for(i in (1..number)){
        clap = i
        //각 숫자의 자리수 별로 3,6,9의 숫자를 검사하여 count를 올려준다
        while(clap!= 0){
            if(((clap%10)%3 ==0) && (clap%10!= 0)) count++
            clap /= 10 
        }
    }

    return count
}
