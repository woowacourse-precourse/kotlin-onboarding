package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
    val Result = mutableListOf<String>()

    val CrewInfo = mutableMapOf<String, String>()
    val NickName = mutableSetOf<String>()

   forms.forEach {Crew_Mail ->
       CrewInfo.keys.forEach { name->
           for (i in 0..Crew_Mail[1].length -1){
               if (name.contains(name.substring(i, i +2))){
                   NickName.add(name)
                   NickName.add(Crew_Mail[1])
               }else
                   break
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
