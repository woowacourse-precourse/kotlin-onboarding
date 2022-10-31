package onboarding


fun check_digits(new_number :String):Int
{
    var clap = 0

    for(j in new_number.indices)
        if (new_number[j] == '3' ||new_number[j] == '6' ||new_number[j] == '9')
            clap++
    return clap
}
fun solution3(number: Int): Int {
    var new_number : String
    var clap = 0
    for(i in 1..number)
    {
        new_number = i.toString()
        clap += check_digits(new_number)
    }
    return clap
}

/*
fun main()
{
    val number = 13
    //val result = 4
    println( solution3(number))
}
*/