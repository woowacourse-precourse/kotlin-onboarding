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
        if (words[i] == "I") { // Warning 예외
            words[i] = "R"
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

    }

    return words.joinToString("")
}


