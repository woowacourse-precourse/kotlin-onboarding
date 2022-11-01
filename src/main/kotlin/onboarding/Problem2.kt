package onboarding

fun solution2(cryptogram: String): String {
    var base:String = crytogram
    var change:String = ""   
    
    //더 이상 변하는 것이 없을 때 break를 통해서 무한 반복문을 종료한다.
    while(true){
        for(i in (0..base.length-1)){
            //해당 문자와 앞의 문자가 같을 때 change를 update 하지 않는다.
        	if((i!=(base.length-1))&&(base[i]==base[i+1])) continue
            //i가 val이기 때문에 생긴 조건문
            else if((i!=0)&&(base[i]==base[i-1])) continue
            change = change+base[i]
    	}
        //더 이상 crytogram이 아닌 문자 생성시 종료
        if(base == change) break
        base = change
        change=""
    }
    return change
}
