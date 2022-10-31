package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    var overlapNames = mutableListOf<String>()

    for (i in 0 until (forms.size)){

        var nowName = forms[i][1]

        for (j in 0 until (forms.size)){

            if (j!=i){
                for (k in 0 until (nowName.length-1)){

                    if ((forms[j][1]).contains (nowName.substring(k..(k+1)))){

                        overlapNames.add(forms[j][0])

                    }

                }
            }

        }

    }


    return (overlapNames.distinct()).sorted()
}
