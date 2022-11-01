package onboarding

fun solution4(word: String): String {
    var word_hashMap = HashMap<String, Any>()
    //대문자
    word_hashMap.put("A","Z")
    word_hashMap.put("B","Y")
    word_hashMap.put("C","X")
    word_hashMap.put("D","W")
    word_hashMap.put("E","V")
    word_hashMap.put("F","U")
    word_hashMap.put("G","T")
    word_hashMap.put("H","S")
    word_hashMap.put("I","R")
    word_hashMap.put("J","Q")
    word_hashMap.put("K","P")
    word_hashMap.put("L","O")
    word_hashMap.put("M","N")
    word_hashMap.put("N","M")
    word_hashMap.put("O","L")
    word_hashMap.put("P","K")
    word_hashMap.put("Q","J")
    word_hashMap.put("R","I")
    word_hashMap.put("S","H")
    word_hashMap.put("T","G")
    word_hashMap.put("U","F")
    word_hashMap.put("V","E")
    word_hashMap.put("W","D")
    word_hashMap.put("X","C")
    word_hashMap.put("Y","B")
    word_hashMap.put("Z","A")
    //소문자
    word_hashMap.put("a","z")
    word_hashMap.put("b","y")
    word_hashMap.put("c","x")
    word_hashMap.put("d","w")
    word_hashMap.put("e","v")
    word_hashMap.put("f","u")
    word_hashMap.put("g","t")
    word_hashMap.put("h","s")
    word_hashMap.put("i","r")
    word_hashMap.put("j","q")
    word_hashMap.put("k","p")
    word_hashMap.put("l","o")
    word_hashMap.put("m","n")
    word_hashMap.put("n","m")
    word_hashMap.put("o","l")
    word_hashMap.put("p","k")
    word_hashMap.put("q","j")
    word_hashMap.put("r","i")
    word_hashMap.put("s","h")
    word_hashMap.put("t","g")
    word_hashMap.put("u","f")
    word_hashMap.put("v","e")
    word_hashMap.put("w","d")
    word_hashMap.put("x","c")
    word_hashMap.put("y","b")
    word_hashMap.put("z","a")
    //공백
    word_hashMap.put(" "," ")
    val word = "I love you"
    val result = "R olev blf"

    var wordlist = mutableListOf<String>()
    var rewordlist = mutableListOf<String>()
    var rewordarray: String = ""
    for(i in 0 .. word.length-1){
        var a = word.substring(i until i+1)
        wordlist.add(a)

        var reword = word_hashMap.get(wordlist[i])
        rewordlist.add(reword.toString())

    }
    /*
    for(i in 0 .. rewordlist.size-1){
        rewordarray = rewordlist[i]
    }

     */
    var answer = rewordlist.joinToString("")
    return answer
}
