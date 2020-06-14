## 문자열 사칙 연산 계산기 구현

### 기능 요구사항
* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
* 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구사항
* 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 기능 분리 힌트
* 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
    * 덧셈
    * 뺄셈
    * 곱셈
    * 나눗셈
    * 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    * 사칙 연산을 모두 포함하는 기능 구현
* 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
* 반복적인 패턴을 찾아 반복문으로 구현한다.

## 기능 구현 목록

### Model
* CalculationExpression
    * 사용자의 계산식 문자열(List<String>)을 감싼 일급 컬렉션이다.
    * 기본 생성자 이외에 String을 받아 Parsing해 객체를 생성한다.
    * Split된 문자열의 개수가 1이거나 짝수일 경우 예외를 발생시킨다.
    * Index 번호를 받았을 때, String이 연산자이면 적합한 연산자를, Number라면 Integer로 변환해서 리턴한다.
        * 해당 반환 작업 수행이 불가능할 때 예외를 발생시킨다.
        
* StringSplitter
    * 입력받은 문자열을 지정 구분자로 Split한다.       
    * 문자열이 null이거나 빈 공백일 경우 예외를 발생시킨다.
    
* StringCalculator
    * CalculationExpression을 받으면 계산을 진행한다.

* Operator
    * 사칙연산자를 정의한 Enum이며, 각 상수별로 계산에 필요한 인터페이스를 정의하고 있다.
    * String을 파라미터로 받으면 해당 연산자의 시그니처와 동일한 연산자를 리턴한다.
    * 없을 경우 예외를 발생한다.
    
* CalculationResult
    * 계산 결과 값을 감싼 객체이다.
    
* LadderBuildingException
    * 런타임 예외를 상속받는 커스텀 예외 클래스이다.

### View
* InputView
    * 사용자의 계산식 문자열을 입력 받는다.
    
* OutputView
    * 계산 결과를 출력한다.

### Controller
* Application
