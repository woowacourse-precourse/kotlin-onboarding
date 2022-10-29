package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    /**
     * 기능목록
     * 1. 지원자 수와 동일한 크기의 0으로 된 배열 선언 및 글자를 가리킬 포인터 2개 선언
     * 2. 지원자 수 만큼 for문 반복
     *    for문 내부에 while 문을 작성하여 지원자 각각의 문자를 비교
     *    동일한 두 글자가 있을 경우 지원자 index에 대응하는 0배열 index의 값을 1증가
     *    이미 0배열 index의 값이 0보다 클 경우 continue로 스킵
     *    지원자 비교가 끝났을 경우 다음 지원자로 넘어감
     * 3. 0배열 index의 값이 양수 인 경우에 해당하는 지원자의 이메일의 @ 앞부분만 잘라 임시 배열에 저장
     * 4. 임시 배열 중복 제거 후 오름차순 정렬
     * 5. result 배열에 임시배열 값을 할당하면서 @email.com 부분을 뒤에 붙인 뒤 리턴
     * */


}
