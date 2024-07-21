# 테스트
## @Test
- 테스트를 하고자하는 메서드에 어노테이션을 붙인다.
- @DisplayName을 작성하여 테스트의 이름을 작성하여 문서화한다.
```java
    @DisplayName("비밀번호가 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest(){
        assertThatCode(()->new  PasswordValidator("serverwizard")).doesNotThrowAnyException();
    }
```

## 엣지 케이스
- 대부분의 에러는 엣지케이스에서 발생한다.
  - 엣지케이스를 테스트하기위해 ParameterizedTest로 쉽게 테스트 할 수 있다.
### @ParameterizedTest
- 해당 메서드를 파라미터 기반으로 테스트한다.
- 파라미터를 ValueSource로 추가할 수 있다.
```java

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaaa", "aaaaaaaaaaaaa"})
    void validatePasswordTest2(String password){
        assertThatCode(()->new  PasswordValidator(password)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
```

# 객체지향 패러다임
## 4가지 특징
- 추상화
- 다형성
- 캡슐화
- 상속
## 5가지 설계 원칙 (SOLID)
- SRP : Single Responsibility Principle
- OCP : Open Closed Principle
- LSP : Liskov's Substitution Principle
- ISP : Interface Segregation Principle
- DIP : Dependency Inversion Principle 
## 갹체지향 패러다임
- 적절한 객체에게 적절한 책임을 할당하여 서로 메시지를 주고 받으며 협력하도록 하는 것
- 점점 증가하는 SW 복잡도를 낮추기 위해 객체지향 패러다임이 대두 

## 객체지향 프로그래밍 VS 절차지향 프로그래밍
- 책임이 한곳에 집중되어 있는가? 
  - Yes : 객체지향
  - NO : 절차지향
- 객체지향 설계는 high cohesion, loose coupling -> 높은 응집도와 낮은 결합도
  - 비슷한 것은 같이 모아두고 다른 것들은 분리하는 것
    - 유지보수에 좋음

## 객체지향으로 설계할 때 하면 좋은 고민
- 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
- 객체들 간의 관계를 고민
- 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
- 협력을 설계
  - 객체지향은 미래의 역할을 고민
- 객체들을 포괄하는 타입에 적절한 책임을 할당
  - 단일책임원칙
- 구현하기 