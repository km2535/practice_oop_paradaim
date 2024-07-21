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