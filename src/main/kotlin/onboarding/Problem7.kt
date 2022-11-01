package onboarding

import java.util.SplittableRandom

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var a = ArrayList<String>()
    var b = ArrayList<ArrayList<String>>()
    for (i in friends){
        for (j in i) {
            if (j in a) continue
            else {
                b.add(arrayListOf(j))
                a.add(j)
            }
        }
    }
    for (i in friends){
        for (j in 0..a.size - 1){
            if(a[j] == i[0]){
                b[j].add(i[1])
            }
        }
    }
    var use = arrayListOf<String>()
    for (i in b){
        if (i[0] == user)
            use = i
        use.removeAt(0)
    }
    var point = arrayListOf<Int>(a.size - use.size - 1,0)
    var res = ArrayList<ArrayList<String>>()
    for (i in a){
        if(i == user || i in use) continue
        else{
            if (i in res){

            }
        }
    }
    TODO("프로그램 구현")
}