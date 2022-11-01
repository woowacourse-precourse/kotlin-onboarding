package onboarding


fun solution2(cryptogram: String): String {
    // TODO("프로그램 구현")
    var count=1
    var str = cryptogram


    while(count != 0)
    {
        count=0
        for (i in 0 until str.length)
        {

            if (i+1 < str.length && str[i] == str[i + 1]) {
//                str.replace(str[i],null,false)
                //var target = str.slice(0..i)
                //var target = str.substring(i)
                //str = target[0].plus(target[1].toString())
//                str.replace(str[i],null,false)

                // slice나 replace 이용해서 해봤지만 실패함...



            }
        }
    }
    return str

}
