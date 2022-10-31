package onboarding


fun judgeDup(a:String,b:String):Boolean{

    for(i in 0 until a.length-1){
        val wordA="${a[i]}${a[i+1]}"
        for(j in 0 until b.length-1){
            val wordB="${b[j]}${b[j+1]}"
            if(wordA==wordB){
                return true
            }
        }
    }

    return false
}
fun delDup(forms:MutableList<List<String>>):List<String>{
    val dupList= mutableListOf<String>()
    var dupflg=false
    while(forms.isNotEmpty()){
        val now=forms.removeFirst()
        for(i in forms){
            if(judgeDup(now[1],i[1])){
                dupflg=true
                dupList.add(i[0])
            }
        }
        if(dupflg){
            dupList.add(now[0])
            dupflg=false
        }
        forms.removeAll { dupList.contains(it[0]) }
    }

    return dupList
}
fun solution6(forms: List<List<String>>): List<String> {
    return delDup(forms.toMutableList()).sorted()
}
