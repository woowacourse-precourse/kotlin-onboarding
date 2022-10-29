package onboarding

//1.문자열 쪼개서 리스트 변환
//2.연속으로 같은 문자가 있는지 확인
//3.같은 문자가 있을 시 삭제
//4.같은 문자가 없을 때 까지 반복
fun solution2(cryptogram: String): String {
    var CharList:MutableList<Char> = cryptogram.toMutableList()
    //문자열 쪼개서 리스트로 변환
    CharList=FindContinuity(CharList)   //연속되는 문자 찾고 지워준다.

    return CharList.joinToString("")    //리스트를 스트링으로 바꿔 리턴한다.
}
//연속되는 문자 찾는 함수
fun FindContinuity(CryptogramList:MutableList<Char>): MutableList<Char> {
    var location:MutableList<Int> = mutableListOf(0)     //연속으로 같은 문자 있는지 확인 후 리스트 위치를 저장할 리스트
    while(location.isNotEmpty()){   //리스트 위치를 저장한 리스트가 빌 때 까지 실행
        location.clear()
        for(i:Int in 0..CryptogramList.size){
            if(CryptogramList.size>i+1){    // i+1이 리스트 크기보다 작을 때
                if(CryptogramList[i]==CryptogramList[i+1]){ //연속될 때 location 리스트에 위치를 저장한다.
                    location.add(i)
                }
            }
        }
        Removelement(location, CryptogramList)  //연속되는 문자 지워주는 함수
    }
    return CryptogramList
}

//연속되는 문자 지워주는 함수
fun Removelement(location:MutableList<Int>, CryptogramList:MutableList<Char>){
    location.sortDescending()
    for(i in location){
        CryptogramList.removeAt(i)
        CryptogramList.removeAt(i)
    }

}