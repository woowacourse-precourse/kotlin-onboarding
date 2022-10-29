## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 함수를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |

---

## 기능 목록

### Problem2.kt
`Problem2.kt`는 `removeNowSequentialChar`, `setNoSequentialString` 함수를 가지며
연속하는 중복 문자들을 삭제한 결과를 반환하는 `solution2` 함수를 제공한다.

| 함수 | 파라미터          | 반환 값  | 설명                                                       |
|---|---------------|-------|----------------------------------------------------------|
| `solution2` | `String`        | `String` | 임의의 문자열을 파라미터로 받아 기능 요구사항을 해결한 결과를 반환                    |
| `removeNowSequentialChar` | `StringBuilder` | `Unit` | StringBuilder 객체의 현재 연속된 문자를 제거                          |
| `getNoSequentialString` | `String`        | `String` | 임의의 문자열을 파라미터로 받아 연속하는 중복 문자들이 없을 때까지 문자를 제거하고 그 문자열을 반환 |
