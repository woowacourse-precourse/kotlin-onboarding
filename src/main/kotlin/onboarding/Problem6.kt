package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var a = arrayListOf<String>()
    var c = arrayListOf<String>()
    var d = arrayListOf<Int>(forms.size - 1,0)
    var k = 0
    for (i in forms){
        for (j in 0..i[1].length - 1){
            var b = i[1].substring(j, j + 1)
            if(b in a){
                if (i == forms.last()) c.add(i[0])
                else continue
            }
            a.add(b)
        }
        d[k] = a.size
        k++
    }
    for (i in 0..d.size){
        if (d[i] != 0) c.add(forms[i][0])
    }
    c.sort()
    return c
}
