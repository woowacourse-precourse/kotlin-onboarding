package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var checklist : MutableList<MutableList<String>>  = ArrayList()
    var answer = mutableListOf<String>() // email for answer


    var email : String
    var nickname :String
    var patterncheck : String // string of two char from nickname for patterncheck

    var nicklist : List<Char>
    var check :Int // if email is already added
    var check2 :Int // is this pattern to add


    //한 닉네임에 관한 check과정
    for(x : Int in 0..forms.size-1){
        email = forms[x][0]
        nickname = forms[x][1]
        nicklist = nickname.toList()
        check = 0
        for(i : Int in 0..nicklist.size-2){
            var new = mutableListOf<String>()
            check2 = 0
            patterncheck = nicklist[i].toString()+nicklist[i+1].toString()
            if(checklist.isEmpty()){
                var temp = mutableListOf<String>()
                temp.add(patterncheck)
                temp.add(email)
                checklist.add(temp)
            }else{
                for(j : Int in 0..checklist.size-1){
                    if(patterncheck.equals(checklist[j][0])){
                        if(check == 0){
                            if(!checklist[j][1].equals("")){
                                answer.add(checklist[j][1])
                                checklist[j][1] = ""
                            }
                            answer.add(email)
                            check++
                            check2++
                            break
                        }
                    }
                }
                if(check2 == 0){
                    new = mutableListOf<String>()
                    new.add(patterncheck)
                    new.add(email)
                    checklist.add(new)
                }

            }

        }
    }
    var answer2 = answer.sorted()

    return answer2

}
