package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var answer = mutableSetOf <String> ()
    var i:Int
    var j:Int
    for(index1 in forms.indices) {
        val myName:String = forms[index1][1]
        val myNameLength:Int = myName.length
        for(index2 in forms.indices) {
            if(index1 >= index2) {
                continue
            }

            val targetName:String = forms[index2][1]
            val targetNameLength:Int = targetName.length

            i = 0
            while(i < myNameLength - 1) {
                j=0
                while(j < targetNameLength - 1) {
                    if(myName.substring(i,i+2) == targetName.substring(j, j+2)) {
                        answer.add(forms[index1][0])
                        answer.add(forms[index2][0])
                    }
                    j++
                }
                i++
            }
        }
    }
    return answer.sorted().toList()
}
