package onboarding



fun solution6(forms: List<List<String>>): List<String> {
    var stringList=StringList()
    stringList.loopForms(forms)
    for(i in forms){
        stringList.isDuplication(i)
    }
    stringList.sortResult()
    return stringList.resultList
}
class StringList(){
    var tempList = mutableListOf<String>()
    var stringList = mutableListOf<String>()
    var resultList = mutableListOf<String>()

    fun sortResult(){
        resultList.sort();
    }
    fun addResult(s:String, stu:List<String>){
        if(s in stu[1]) {
            resultList.add(stu[0])
        }
    }

    fun isDuplication(stu:List<String>){
        for(i in stringList){
            addResult(i,stu)
        }
    }
    fun loopForms(forms: List<List<String>>){
        for(i in forms){
            makeStringList(i[1])
        }
        stringList= stringList.distinct().toMutableList()
    }
    fun makeStringList(s : String) {
        for(i in 0..s.length-2){
            addString(s.substring(i,i+2))
        }
    }
    fun addString(s:String) {
        if(s in tempList){
            stringList.add(s)
        }
        if(!(s in tempList)){
            tempList.add(s)
        }
    }

}
