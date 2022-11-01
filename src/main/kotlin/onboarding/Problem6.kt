package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    //TODO("프로그램 구현")

    val wordlist = ArrayList<String>();
    val overlapindex = ArrayList<Int>();
    var newwordlist = ArrayList<String>()
    val email = ArrayList<String>();

    for (i in forms.indices)
    {
        for (j in 0..forms[i][1].length-2) {
            wordlist.add(forms[i][1].substring(j,j+2))
        }
    }

    for (g in 0 until wordlist.size)
    {
        for (h in g+1 until wordlist.size)
        {
            if (wordlist[g] == wordlist[h])
            {
                newwordlist.add(wordlist[g])
            }
        }
    }

    val nwl = newwordlist.distinct()

    for (o in forms.indices)
    {
        for(element in nwl)
        {
            if(forms[o][1].contains(element))
            {
                email.add(forms[o][0])
            }
        }

    }
    val sortemail = email.sorted()
    val dse = sortemail.distinct()

    return dse
}
