package onboarding

fun solution2(cryptogram_: String): String {
    var cryptogram=cryptogram_
    var tmp=""

    while(true){
        var size=cryptogram.length
        var remove=false

        for(i in 0..size-2){
            // 다음 단어가 중복단어면 현재 단어 스팁
            if(cryptogram[i]==cryptogram[i+1]){
                remove=true
                continue
            }

            // 다음 단어가 중복단어가 아니면
                // 그 전에 중복상태가 아닐 경우에만 추가
            if(!remove) tmp+=cryptogram[i]
            remove=false
        }

        // 마지막 단어 처리
        if(!remove) tmp+=cryptogram[size-1]

        if(cryptogram==tmp || tmp=="") break
        cryptogram=tmp
        tmp=""
    }

    return tmp
}
