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

</br>

## ✅ 기능 목록
1. 주어진 cryptogram의 연속 중복 글자를 제거하는 함수
> - [ ] 주어진 cryptogram의 각 문자를 하나씩 스택에 담는다.
> - [ ] 위 과정에서 만약 담을 문자와 담긴 글자가 같은 경우 스택에서 pop한다.
> - [ ] 결과 스택을 return 한다.
2. 스택의 문자를 pop하여 출력하는 함수
> - [ ] 결과 스택을 pop하여 리스트에 담는다.
> - [ ] 리스트의 각 문자를 거꾸로 결과 String에 담는다.
> - [ ] 결과 String을 출력한다.