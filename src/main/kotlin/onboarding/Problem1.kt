package onboarding
import java.util.*
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1)
        return -1
    else {
        var a = mutableListOf<Int>(0, 0);
        var b = mutableListOf<Int>(0, 0)
        var max1 = 0;
        var max2 = 0;
        for (i in pobi.indices) {
            var c = i;
            while (c > 0) {
                a[0] *= c % 10
                a[1] += c % 10
                c = (c / 10).toInt()
            }
        }
        for (i in pobi.indices) {
            var c = i;
            while (c > 0) {
                b[0] *= c % 10
                b[1] += c % 10
                c = (c / 10).toInt()
            }
        }
        max1 = Collections.max(a);
        max2 = Collections.max(b);
        if (max1 == max2) return 0
        else if (max1 > max2) return 1
        else return 2
    }
}
