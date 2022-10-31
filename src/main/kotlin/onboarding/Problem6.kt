package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val name= mutableListOf<String>()

    for(i in 0..forms.size-1){
        name.add(forms[i][1])
    }

    val name_split=ArrayList<ArrayList<String>>()

    for(i in 0..name.size-1){
        val temp=ArrayList<String>()
        for(j in 0..name[i].length-2){
            temp.add(name[i].substring(j,j+2))
        }
        name_split.add(temp)
    }

    val repeat_name= mutableSetOf<String>()
    for(i in 0..name_split.size-2){
        for(j in i+1..name_split.size-1){
            val split1=name_split[i].toSet()
            val split2=name_split[j].toSet()
            if (split1.intersect(split2).size!=0){
                repeat_name.add(name[i])
                repeat_name.add(name[j])
            }
        }
    }
    val repeat_name_list=repeat_name.toList()

    val forms_dict= mutableMapOf<String,String>()
    for(i in 0..forms.size-1){
        forms_dict.put(forms[i][1],forms[i][0])
    }

    val email= mutableListOf<String>()
    for(i in 0..repeat_name_list.size-1){
        email.add(forms_dict.getValue(repeat_name_list[i]))
    }
    return email.sorted()
}

