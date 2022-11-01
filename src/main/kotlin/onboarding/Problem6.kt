package onboarding

fun checkName(elem: String, temp: String):Int{
    /*
    var a=0
    var b=0

    for(e in elem){
        var count = 0

        for(t in temp){
            if(e==t){
                if(temp.length != b + 1 && elem.length != a + 1 && elem[a+1]==temp[b+1])
                    return 1
            }
            b++
        }
        a++
    }
     */

    for( a in elem.indices){
        for( b in temp.indices){
            if ( elem[a] == temp[b] && a < elem.length - 1 && b < temp.length - 1){
                if(elem[a+1]==temp[b+1]){
                    return 1
                }
            }
        }
    }
    return 0
}
fun solution6(forms: List<List<String>>): List<String> {
    var answer = mutableListOf<String>()
    var tempName = arrayListOf("","","","","")
    var tempEmail = arrayListOf("","","","","")

    var count = 0
    var check = 0

    for(elem in forms){
        for(a in 0 until count ) {   //하나씩 중복검사
            if (checkName(elem[1], tempName[a]) == 1) {
                if(check == 0){
                    answer.add(tempEmail[a])
                    check = 1
                }
                answer.add(elem[0])         //중복이니까 answer에 이메일 입력해주기
                break
            }
        }

        tempEmail[count] = elem[0]
        tempName[count] = elem[1]
        count++
    }

    val temp = answer.sorted()
    return temp
}