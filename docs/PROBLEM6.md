## 🚀 기능 요구 사항

우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다. 간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.

혼란을 막기 위해 크루들의 닉네임 중 **같은 글자가 연속적으로 포함** 될 경우 해당 닉네임 사용을 제한하려 한다. 이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.


신청받은 닉네임 중 **같은 글자가 연속적으로 포함** 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 함수를 완성하라.

### 제한사항

- 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
- 크루는 1명 이상 10,000명 이하이다.
- 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
- 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
- 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
- result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.

### 실행 결과 예시

| forms | result |
| --- | --- |
| [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ] | ["jason@email.com", "jm@email.com", "mj@email.com"] |

---

## 기능 목록
`Problem6.kt`은 아래 기능들을 제공한다.

`User`클래스
- `email`, `nickname` 멤버 변수를 갖는다

`resultKey`
- 중복되는 단어들을 담는 `ArrayList`이다.

`nicknameMap`은 다음과 같이 정의한다.  
- `val nicknameMap = HashMap<String, ArrayList<User>`  

|함수| 파라미터                   | 반환 값           | 설명                                                                                                                               |
|---|------------------------|----------------|----------------------------------------------------------------------------------------------------------------------------------|
|`dividedList`| `String`               | `List<String>` | 닉네임을 2글자 단위로 나누어 `List`로 반환한다.                                                                                                   |
|`updateNicknameMap`| `User`, `List<String>` | `Unit`         | `dividedList`의 반환값의 원소들을 `nicknameMap`에 추가한다.                                                                                    |
|`resultHashSet`| `Unit`                  | `HashSet`      | `resultKey`의 원소를 `key`로 하여 `nicknameMap`을 탐색하고 `resultKey`의 `key`에 해당하는 `nicknameMap`의 `value`의 원소의 `email`을 `HashSet`에 넣어 반환한다. |
|`solution6`| `List<List<String>>`   | `List<String>` | 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 반환한다.|

### `updateNicknameMap`
- `key`가 있을 경우 `value`에 `add`한다. 이 때 `value.size`가 1이었다면 `resultKey`에도 `add`한다
- `key`가 없을 경우 `key`와 `MutableList<User>`를 초기화 하여 추가한다.
