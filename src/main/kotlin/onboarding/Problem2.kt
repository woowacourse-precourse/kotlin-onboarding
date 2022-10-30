package onboarding

/* TODO 기능 목록   */
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
        if(result.length-1<=index){
            if(restartFlag){
                repeatFirstChar()
            }
            else{
                break
            }
        }
        else{
            if(result[index]==result[index+1]){
                getRemoveIndex()
                removeOverlapString()
                restart()
            }
            else{
                index++
            }
        }
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
}

private fun removeOverlapString(){
    result = result.removeRange(index,removeIndex+1)
}

private fun restart(){

}

private fun repeatFirstChar(){

}
