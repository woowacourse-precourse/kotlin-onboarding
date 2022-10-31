package onboarding

fun delDup(str:String):String{
    var ret=str
    var flg=false

    var idx=ret.length-1
    while(idx>0){
        if(ret[idx]==ret[idx-1]){
            ret=ret.removeRange(idx-1..idx)
            idx-=2
            flg=true
            continue
        }
        idx--
    }

    return if(flg){
        delDup(ret)
    }
    else{
        ret
    }


}

fun solution2(cryptogram: String): String {
    return delDup(cryptogram)
}

