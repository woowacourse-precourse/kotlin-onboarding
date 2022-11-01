package onboarding

import java.util.*
//기능 1 : string을 chararray형태로 변환하기
//기능 2: 큐 두개를 가지고 하나하나 뺴면서 바로 뒤 char과 비교 -> 같으면 둘 다 뺴기
//기능 3: 다했으면 (과정을 거쳐도 변한 게 없으면) 종료
//기능 4: string형태로 변환해서 return 하기

fun solution2(cryptogram: String): String {

    var char = cryptogram.toCharArray()

    var q : Queue<Char> = LinkedList()
    var q1 : Queue<Char> = LinkedList()

    for(i in 0 until (char.size)){
        q.add(char[i]);
    }

    var ok = 1
    while(ok == 1){
        ok = 0
        while(q.isEmpty() != true){
            var a = q.poll();
            if(a == q.peek()){
                ok = 1
                if(q.isEmpty() != true) q.poll()
                }
            else q1.add(a);
        }
        while(q1.isEmpty() != true){
            var a = q1.poll();
            if(a == q1.peek()){
                ok = 1
                if(q1.isEmpty() != true) q1.poll()
            }
            else q.add(a);
        }

    }

    var arr = CharArray(char.size)

    if(q.isEmpty()!= true){
        for(i in 0 until q.size){
            arr[i] = q.poll();
        }
    }
    else if(q1.isEmpty()!=true){
        for(i in 0 until q1.size){
            arr[i] = q1.poll();
        }
    }
    else return "--"


    var arr1 = arr.concatToString()

    return arr1
}
