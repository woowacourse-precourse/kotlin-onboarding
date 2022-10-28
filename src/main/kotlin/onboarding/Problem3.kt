package onboarding

fun solution3(number: Int): Int {
    var Result = 0

    for (i in 1..number){
        var Clap = i

//        var Class_1000 = Clap /1000 % 10
//        var Class_100 = Clap /100 % 10
//        var Class_10 = Clap /10 % 10
//        var Class_1 = Clap % 10

        while (Clap != 0){
            //10,1자리 따로 생각하기
            if ((Clap % 10) % 3 == 0 && (Clap % 10) != 0){
                Result++
            }
            Clap /= 10
        }
    }

    return Result
}
