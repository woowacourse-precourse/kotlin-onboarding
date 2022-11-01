package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
    var count = 0
    var j = 0
    for (i in 1..number){
        j=i
        if(j == 3 || j==6 || j==9){
            count++
        }
        else{
            while(j>0){
                if(j%10 == 3 || j%10==6 || j%10==9){
                    count++
                }
                j/=10
            }
        }
    }
    return count
}
