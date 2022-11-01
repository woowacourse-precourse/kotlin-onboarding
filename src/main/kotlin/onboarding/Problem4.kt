package onboarding

fun solution4(word: String): String {
    val words = word.chunked(1).toMutableList()

    for (i in 0 until words.size) { // 어떻게 대소문자 감지하는건지 모르겠음

        if (words[i] == "a") {
            words[i] = "z"
            continue }
        if (words[i] == "b") {
            words[i] = "y"
            continue }
        if (words[i] == "c") {
            words[i] = "x"
            continue }
        if (words[i] == "d") {
            words[i] = "w"
            continue }
        if (words[i] == "e") {
            words[i] = "v"
            continue }
        if (words[i] == "f") {
            words[i] = "u"
            continue }
        if (words[i] == "g") {
            words[i] = "t"
            continue }
        if (words[i] == "h") {
            words[i] = "s"
            continue }
        if (words[i] == "i") {
            words[i] = "r"
            continue }
        if (words[i] == "j") {
            words[i] = "q"
            continue }
        if (words[i] == "k") {
            words[i] = "p"
            continue }
        if (words[i] == "l") {
            words[i] = "o"
            continue }
        if (words[i] == "m") {
            words[i] = "n"
            continue }
        if (words[i] == "n") {
            words[i] = "m"
            continue }
        if (words[i] == "o") {
            words[i] = "l"
            continue }
        if (words[i] == "p") {
            words[i] = "k"
            continue }
        if (words[i] == "q") {
            words[i] = "j"
            continue }
        if (words[i] == "r") {
            words[i] = "i"
            continue }
        if (words[i] == "s") {
            words[i] = "h"
            continue }
        if (words[i] == "t") {
            words[i] = "g"
            continue }
        if (words[i] == "u") {
            words[i] = "f"
            continue }
        if (words[i] == "v") {
            words[i] = "e"
            continue }
        if (words[i] == "w") {
            words[i] = "d"
            continue }
        if (words[i] == "x") {
            words[i] = "c"
            continue }
        if (words[i] == "y") {
            words[i] = "b"
            continue }
        if (words[i] == "z") {
            words[i] = "a"
            continue }

        ////////////////////////////////////////////////////////////////////////////////////

        if (words[i] == "A") {
            words[i] = "Z"
            continue }
        if (words[i] == "B") {
            words[i] = "Y"
            continue }
        if (words[i] == "C") {
            words[i] = "X"
            continue }
        if (words[i] == "D") {
            words[i] = "W"
            continue }
        if (words[i] == "E") {
            words[i] = "V"
            continue }
        if (words[i] == "F") {
            words[i] = "U"
            continue }
        if (words[i] == "G") {
            words[i] = "T"
            continue }
        if (words[i] == "H") {
            words[i] = "S"
            continue }
        if (words[i] == "I") { // Warning 예외
            words[i] = "R"
            continue }
        if (words[i] == "J") {
            words[i] = "Q"
            continue }
        if (words[i] == "K") {
            words[i] = "P"
            continue }
        if (words[i] == "L") {
            words[i] = "O"
            continue }
        if (words[i] == "M") {
            words[i] = "N"
            continue }
        if (words[i] == "N") {
            words[i] = "M"
            continue }
        if (words[i] == "O") {
            words[i] = "L"
            continue }
        if (words[i] == "P") {
            words[i] = "K"
            continue }
        if (words[i] == "Q") {
            words[i] = "J"
            continue }
        if (words[i] == "R") {
            words[i] = "I"
            continue }
        if (words[i] == "S") {
            words[i] = "H"
            continue }
        if (words[i] == "T") {
            words[i] = "G"
            continue }
        if (words[i] == "U") {
            words[i] = "F"
            continue }
        if (words[i] == "V") {
            words[i] = "E"
            continue }
        if (words[i] == "W") {
            words[i] = "D"
            continue }
        if (words[i] == "X") {
            words[i] = "C"
            continue }
        if (words[i] == "Y") {
            words[i] = "B"
            continue }
        if (words[i] == "Z") {
            words[i] = "A"
            continue }
    }

    return words.joinToString("")
}


