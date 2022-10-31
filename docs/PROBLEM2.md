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

<br><hr>

## 🤔 프리코스 1주차 Problem2 기능 목록

* 💡 O(n) 안에 해결하는 알고리즘을 구상하자!
* 연속하는 중복 문자를 제거하는 String Extension 메서드를 구현한다.
  + Stack 자료구조를 사용하여, 순차적으로 주어진 문자열의 character를 push한다.
  + Stack의 top과 push할 character가 같다면 pop한다.
* Stack의 상태를 지니고 있는 Stack가 필드(isContinuous, prevChar)를 선언한다.
  + Stack의 상태(isContinuous, prevChar)를 변경하는 메서드를 구현한다
* Stack의 top과 매개변수로 주어지는 character가 같으면 pop하고, 다른 경우 push하는 Stack\<Char\> Extension 메서드를 구현한다.
* Stack\<Char\> 자료구조를 String 형태로 반환하는 Stack\<Char\> Extension 메서드를 구현한다.