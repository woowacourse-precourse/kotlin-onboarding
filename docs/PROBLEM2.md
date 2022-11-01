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

### 기능 목록
    1. 처음 들어온 cryptogram에 연속된 중복 문자가 있는지 확인
    2. 1.에서 연속 중복 문자가 있다면 제거
    3. 2.에서 제거했음에도 연속 중복 문자가 있다면 제거
    4. 연속 중복 문자가 없을 때까지 3.을 반복

--- 

### 예외 사항
    1. cryptogram 중 알파벳 대문자가 포함된 경우
    2. cryptogram이 알파벳이 아닌 경우