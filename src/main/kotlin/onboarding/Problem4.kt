package onboarding

fun solution4(word: String): String {
   var reverse:String = "" 
   var num:Int
    
   for(i in word){
       num=i.toInt()
       //대문자 'A'부터 'Z'까지의 숫자 범위가 65-90까지 이므로 이를 반대 수로 바꿔 준다
       if(num>64&&num<91){
           num = 90+65-num
       }
       //소문자 'a'부터 'z'까지의 숫자 범위가 97-122까지 이므로 이를 반대 수로 바꿔 준다
       else if(num>96&&num<123){
           num = 122+97-num
       }
       reverse = reverse+num.toChar()
   }
   return reverse
}
