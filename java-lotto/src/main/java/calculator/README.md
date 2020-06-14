## 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습

### 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.

## 구현 기능 목록

### Domain
* Number
    * 덧셈 계산에 사용되는 숫자를 정의한 객체이다.
    * 음수의 값은 가질 수 없다.
    
* NumbersGroup
    * List<Number>를 가진 일급 컬렉션이다.
    * StringSplitter를 통해 파라미터 문자열을 분리한다.
    * 생성자로 받는 값이 빈 문자열이나 null이면 계산 결과가 0이 되도록 0값 Numbers를 리턴한다.
    
* StringSplitter
    * 커스텀 구분자 패턴이 없으면 comma와 colon을 기본 구분자로 이용한다.
    * 커스텀 구분자가 있다면 해당 구분자를 이용한다.
    
* CalculatorBuildingException
    * Runtime Exception을 상속한 커스텀 예외 클래스이다.

* StringAddCalculator
    * NumbersGroup에 대한 모든 값들의 덧셈 작업을 수행하여 결과를 리턴한다.
    
* CalculationResult
    * 계산 결과를 담은 객체이다.

### View
* InputView
    * 사용자의 계산식 입력값을 받는다.
    
* OutputView
    * 계산 결과를 출력한다.

### Controller
* Application
