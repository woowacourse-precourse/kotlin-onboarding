package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
    var str_list =  ArrayList<String>();
    var str_list1 =  ArrayList<String>();
    var crypto1: String = ""
    var s2: String = ""
    for (i in cryptogram){
        var s = i
        str_list.add(s.toString())
    }
    for(j in 0 .. str_list.size-1 step (1)){
        var s1 = str_list.get(j)
        if(j != 0){
            s2 = crypto1.substring(crypto1.length-1,crypto1.length)
            //println("crypto1의 마지막 문자 S2는 : " + s2)
        }
        crypto1 += s1
        //print(crypto1)
        //println(" 길이: " + crypto1.length)
        if(j != 0){
            if(str_list.get(j) == s2){
                //print("삭제 ->")
                crypto1 = crypto1.substring(0,crypto1.length-2)
                //println(crypto1)
                continue;
            }
        }

    }
    return crypto1
}
