package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val Result = mutableListOf<String>()

    val CrewInfo = mutableMapOf<String, String>()
    val NickName = mutableSetOf<String>()

    forms.forEach {Crew_Mail ->
        //특정값을 가져오기 위해서는 keys 필요
        CrewInfo.keys.forEach { name->
            //print(Crew_Mail[1].length)
            //""까지 length로 치나벼..?
            for (i in 0..Crew_Mail[1].length -2)
            //substring으로 닉네임 나누기 0,2는 되는데 20자이상까지 커버해야함
            //i +1까지로 하면 예외 상황 행김
                if (name.contains(Crew_Mail[1].substring(i, i+2))){
                    NickName.add(name)
                    NickName.add(Crew_Mail[1])
                }
        }
        CrewInfo[Crew_Mail[1]] = Crew_Mail[0]
    }

    Result.run {
        addAll(NickName.mapNotNull { name -> CrewInfo[name] })
        sort()
    }

    return Result.toList()
}
