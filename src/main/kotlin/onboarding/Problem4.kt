package onboarding

fun solution4(word: String): String {
    // 제약 1: 알파벳 외의 문자는 변환 x
    // 제약 2: 소문자는 소문자, 대문자는 대문자
    val result = StringBuffer()
    // 1. 한 단어씩 돌아가면 - 'a'/'A' 로 변환 (여기서 제약 2해결)
    var spellInt: Int
    var transitedSpell: Char
    for (spell in word) {
        // 대문자라면,
        if (spell.isUpperCase()) {
            spellInt = spell - 'A'
            transitedSpell = 'Z'.minus(spellInt)
            result.append(transitedSpell)
        }
        // 소문자라면,
        else if (spell.isLowerCase()) {
            spellInt = spell - 'a'
            transitedSpell = 'z'.minus(spellInt)
            result.append(transitedSpell)
        }
        // 알파벳 외 문자
        else {
            result.append(spell)
        }
    }
    return result.toString()
}