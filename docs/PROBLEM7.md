## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 함수를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 제한사항

- user는 길이가 1 이상 30 이하인 문자열이다.
- friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
- friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
    - A와 B는 친구라는 의미이다.
    - 아이디는 길이가 1 이상 30 이하인 문자열이다.
- visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
- 동일한 친구 관계가 중복해서 주어지지 않는다.
- 추천할 친구가 없는 경우는 주어지지 않는다.

### 실행 결과 예시

| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |

---

## 기능 목록
`Problem7.kt`는 아래의 기능들을 제공한다.

### 전역 변수
`target : Account`는 해당 target에 대한 Account의 score를 비교하기 위해 설정된다.
### 클래스
`Account` 클래스는 `userName`, `friendList`, `scoreMap` 맴버 변수를 갖는다.  
`Comparable` 인터페이스를 상속 받아 `compareTo` 함수를 제공한다.

### 함수
|함수| 파라미터                                  | 반환 값                     |설명|
|---|---------------------------------------|--------------------------|---|
|`solution7`| `String`, `List<List<String>>>`, `List<String>` | `List<String>`             |매개변수를 통해 친구 관계를 만들고 추천 친구 목록을 반환한다.|
|`initRelation`| `List<List<String>>>`                 | `HashMap<String, Account>` |매개변수를 통해 친구 관계를 만들고 이름과 `Account`를 `key`, `value`로 갖는 `HashMap`을 반환한다.|
|`updateScoreByVisit`| `List<String>`, `String `               |`Unit`|`List`를 통해 `String` 매개변수를 이름으로 가지는 `Account`에게 방문한 `Account`들의 `scoreMap`을 갱신한다.| 