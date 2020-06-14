## 자동차 경주 게임 구현

### 기능 요구사항
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

### 실행 결과
* 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

### 프로그래밍 요구사항
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
* MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

### 기능 목록 및 commit 로그 요구사항
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    * 참고문서: AngularJS Commit Message Conventions

### AngularJS Commit Message Conventions 중
* commit message 종류를 다음과 같이 구분

```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

## 기능 구현 목록

### Model
* Car
    * 경주에 참가하는 자동차 객체이며, 이름과 위치 정보 및 이동 전략을 가진다.
    * 이름이 null이거나 빈 문자열이거나 5자를 초과하는 경우 생성 예외가 발생한다.

* CarsGroup
    * List<Car>를 감싼 일급 컬렉션이다.
    * List<String> 자동차 이름들 명단을 받으면 이를 변환해 생성한다.
    * 이름 명단, 위치 명단을 List로 변환해 반환한다.
    * 모든 자동차들에 대해 move를 요청한다.

* MovingStrategy
    * 자동차가 움직이기 위한 전략을 정의한 인터페이스이다.

* RandomMovingStrategy
    * 랜덤 전략으로 자동차가 움직이는 인터페이스이다.
    
* RacingGame
    * 게임을 실행하는 객체이다.
    * 게임 시도 회수를 생성자 파라미터로 받으며, 1회 미만의 경우 예외가 발생한다.
    * 참가 자동차 리스트를 받으면, 게임 시도 회수만큼 각 자동차들을 움직이며 결과를 기록한다.
    * 플레이 가능한 다음 회차가 있는지를 보여주며, 회차가 없는데 플레이 하는 경우 예외를 발생한다.
    
* RacingGameBuildingException
    * Runtime Exception을 상속한 커스텀 예외이다.
    
### View
* InputView
    * 경주 자동차 이름들을 입력받는다.
    * 시도할 횟수를 입력받는다.
    
* OutputView
    * 게임 결과를 출력한다.
    * 우승자를 출력한다.

### Controller
* Application
