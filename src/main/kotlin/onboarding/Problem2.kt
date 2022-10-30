package onboarding

private var result = ""
private var restartFlag = false
private var removeIndex = 0
private var index=0
fun solution2(cryptogram: String): String {
    result = cryptogram
    if(cryptogram.length==1){
        return cryptogram
    }
    else{
        index=0
        restartFlag =false
        findOverlapString()
    }
    return result
}

private fun findOverlapString(){
    while(true){
        if (findStopPoint()){
            break
        }
        else if(findRepeatFirstPoint()){
            repeatFirstChar()
        }
        else if(result.length-1>index){
            findRemoveIndex()
        }
    }
}

private fun findStopPoint() : Boolean{
    var flag = false
    if(result.length-1<=index && !restartFlag){
        flag= true
    }
    return  flag

}

private fun findRepeatFirstPoint() : Boolean{
    var flag = false
    if(result.length-1<=index && restartFlag){
        flag=true
    }
    return flag
}

private fun findRemoveIndex(){
    if(result[index]==result[index+1]){
        getRemoveIndex()
    }
    else if(result[index]!=result[index+1]){
        index++
    }
}

private fun getRemoveIndex(){
    removeIndex = index
    for(i in index until result.length){
        if(result[i]==result[index]){
            removeIndex=i
        }
        else{
            break
        }
    }
    removeOverlapString()
}

private fun removeOverlapString(){
    result = result.removeRange(index,removeIndex+1)
    restart()
}

private fun restart(){
    restartFlag=true
}

private fun repeatFirstChar(){
    restartFlag=false
    index=0
}
