package onboarding

/**
 * 제약조건 검사 함수
 * - word는 길이가 1 이상 1,000 이하인 문자열이다.
 *
 * @author @ponopono0322
 * @param word 바꾸려는 문자열
 * @return true: 제약조건 충분, false: 제약조건 불충분
 */
fun constraintsS4(word: String) = word.length in 1 .. 1000

/**
 * 제약조건 함수
 * - 알파벳 외의 문자는 변환하지 않는다.
 * - 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 *
 * @author @ponopono0322
 * @param s 시작하는 문자
 * @param e 끝나는 문자
 * @return 청개구리 변환 사전
 */
fun getMap(s: Char, e: Char) = (s .. e).zip(e downTo s).toMap()

/**
 * Solution Algorithm
 * 1. 아스키코드 문자를 해시맵으로 만든다(제한사항 2를 만족시키기 위함).
 * 2. 청개구리의 문자를 갱신해준다(제한사항 3을 만족시키기 위함).
 * 3. 원문을 순회하면서 청개구리 문장으로 만든다
 *
 * @author @ponopono0322
 * @param word 변경하고자 하는 문장
 * @return 청개구리 문장
 */
fun solution4(word: String): String {
    if (!constraintsS4(word)) return ""   // 제약조건 수행
    var frog = (' ' .. '}').zip(' '.. '}').toMap()  // 청개구리 사전 초기화
    frog = frog + getMap('a', 'z') + getMap('A', 'Z')   // 청개구리 사전 업데이트

    var newWord = ""   // 바뀐 문자열

    word.forEach { newWord += frog.getValue(it) }

    return newWord
}
