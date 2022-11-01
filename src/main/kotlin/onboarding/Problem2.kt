package onboarding
import java.util.*

fun solution2(cryptogram: String): String {
    var plane = mutableListOf<Char>();
    plane.add(cryptogram[0]);

    for(i in 1 until cryptogram.length){
        if(cryptogram[i] != plane.last()){//이전거랑 다르면
            //연속된 문자가 3개 이상 있을때는 이걸로 안될거같은데, 솔직히 잘 모르겠다.
            plane.add(cryptogram[i]);
        }
        else{
            plane.removeLast();
        }
    }
    //println(plane)
    return plane.joinToString("");

}
