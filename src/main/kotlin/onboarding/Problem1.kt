package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[1]-pobi[0] != 1 || crong[1]-crong[0] != 1){
        println(-1)
        return
    }

   var hun:Int
   var ten:Int
   var one:Int
   var add:Int
   var mul:Int
    
   var pobi_max = ArrayList<Int>()
   var crong_max = ArrayList<Int>()
   
   for(i in pobi){
       hun = i/100
       ten = (i/10)%10
       one = i%10
       
       if(hun==0){
           add = ten+one
           mul = ten*one
       } else{
           add = hun+ten+one
           mul = hun*ten*one
       }
       if(add<=mul) pobi_max.add(mul)
       else pobi_max.add(add)
   }
   for(i in crong){
       hun = i/100
       ten = (i/10)%10
       one = i%10
       
       if(hun==0){
           add = ten+one
           mul = ten*one
       } else{
           add = hun+ten+one
           mul = hun*ten*one
       }
       if(add<=mul) crong_max.add(mul)
       else crong_max.add(add)
   }
   
   if(pobi_max.max()==crong_max.max()) println(0)
   else if(pobi_max.max()<crong_max.max()) println(2)
   else println(1)
}