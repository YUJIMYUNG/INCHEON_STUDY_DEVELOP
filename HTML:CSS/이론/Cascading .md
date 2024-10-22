# Cascading

<aside>
💡

**CSS(Cascading-Style-Sheet)에서 Cascading은 스타일 규칙이 어떻게 적용되는지를 결정하는 중요한 메커니즘이다. 이 원리를 이해하면 여러 스타일 규칙이 충돌할 때 어떤 규칙이 최종적으로 적용될지 예측 가능하다.**

</aside>

## 이론

---

### 상속

- CSS에서 상속되는 속성이 기본적으로 텍스트 및 기타 속성이 포함됨(즉, 부모 요소에서 자식요소로 자동 전달)
- 텍스트 관련 속성(color, font-???)들은 부모에서 설정하면 자동으로 자식에게 전달 됨
- 기타 속성(cursor, opacity, display)들은 부모에서 설정하면 자동으로 자식에게 전달 됨

### 속성 충돌 발생시

1. 소스 순서(Source Order)
    
    ```css
    div {color:blue;}
    div {color:red;} /* 우선적용 */
    ```
    
2. 중요도
    1. style 태그
    2. css 파일
    3. 브라우저 기본 스타일
3. 명시성(얼마나 구체적인지)
    
    ```css
    // <div class="test"
    
    .test { color : pink;} /* 우선 적용 */
    div { color : green;}
    body { color : red;}
    * {color : white;}
    ```