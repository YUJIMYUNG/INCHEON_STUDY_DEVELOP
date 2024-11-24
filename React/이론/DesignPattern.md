<aside>
💡

**코드를 유지보수 하기 위한 필수 패턴!**

</aside>

## 컴포넌트 분류 패턴

---

1. 매크로 레벨 패턴(아키텍쳐 패턴)
    - **🎨 Hierarchical Component Pattern**
        
        > **계층적 컴포넌트 설계로 UI구조를 모듈링!**
        > 
        
        ### 계층적 컴포넌트 구조
        
        ---
        
        1. UI컴포넌트 : UI요를 랜더링하고, 재사용 가능한 컴포넌트
        2. Layout 컴포넌트 : 공통 레이아웃을 정의
        - src
            - components
                - common
                    - Typo
                    - Button
                    - Label
                - Layout
                    - Card
                    - Form
                    - Template
            - styles(스타일링 관련)
                - map
            - utils(유틸리티 관련)
                - math
        
        ### 설계 원칙
        
        ---
        
        1. 단일 책임 원칙
            1. 각 컴포넌트는 한 가지 역할만 수행하기
            2. 상위 컴포넌트는 데이터 관리, 하위 컴포넌트는 UI 렌더링(html+css) 집중
        2. 계층적 구조 정의
            1. 하위 컴포넌트는 상위 컴포넌트의 상태를 변경하지 않음
        
    - **🎨 Container - Presentational Design**
        
        > 컨테이너(Container)와 프레젠테이셔널(Presentational) 컴포넌트를 사용하여 UI와 로직을 분리하기
        > 
        
        ### 패턴의 개념
        
        ---
        
        - Presentation Component
            - Styling : color, backgound, padding, font
            - UI 랜더링
            - props를 통해 데이터를 받아 화면에 표시
        - Container Component
            - Layout : display, position, margin, width, height
            - Presentation Component에 데이터 전달 역할
            - 상태 관리 및 데이터 처리 등을 담당
        
        ### 패턴의 장점
        
        ---
        
        1. 역할 분리를 통한 가독성 및 유지보수성 향상
        2. 재사용성 증가
        3. 테스트 용이성
        4. 의존성 감소
        
        ### 패턴 활용시 주의사항
        
        ---
        
        1. 역할 분리에 대한 분명성 필요!
        2. props의 과도한 사용 지양하기!
        
2. 마이크로 레벨 패턴(구현패턴)
    - **🎀 Containment 패턴**
        
        > **Containment 패턴으로 유연하고 재사용 가능한 컴포넌트 설계하기**
        > 
        
        ### 패턴의 개념
        
        ---
        
        - Containment 패턴은 부모 컴포넌트가 자식 컴포넌트를 `children`으로 받아 내용을 동적으로 렌더링하는 방식
        - 주로 박스, 카드, 모달 등의 컨테이너 컴포넌트 설계에 활용
        
        ### 기본 사용법
        
        ---
        
        - 자식 컴포넌트를 동적으로 삽입
        - 부모 컴포넌트는 `props.children` 을 사용해 자식 컴포넌트를 렌더링
        
        ```jsx
        //1. children 방법(=자식 컴포넌트를 동적으로 삽입)
        <Card>
        	<span>1</span>
        	<span>2</span>
        	<span>3</span>
        	<span>4</span>
        </Card>
        
        //2. children 방법(=부모 컴포넌트는 props.children을 사용해 자식 컴포넌트를 렌터링)
        <Card children={} />
        ```
        
    - 🎀 **Specialization** **패턴**
        
        > Specialization 패턴으로 유사한 컴포넌트 간 차별화된 기능 구현
        > 
        
        ### 패턴의 개념
        
        ---
        
        - Specialization 패턴은 재사용 가능한 기본 컴포넌트(Base Componenet)를 정의하고, 이를 기반으로 특정 기능을 확장한 컴포넌트를 만드는 설계방식
        - 일반적인 구조를 공유하면서도 특화된 기능을 추가할 수 있음
        
        ### 기본 사용법
        
        ---
        
        - 기본 로직 재사용
            - 공통 동작(Base Component)을 정의하여 중복 제거
            - 공통된 스타일이나 로직 정의
            - 특화된 컴포넌트에서 이를 확장
        - 특화된 기능 제공
            - Specialization Component에서 고유한 스타일이나 로직 추가
            - Base Component를 기바능로 특정 요구사항을 추가
            - 고유한 스타일, 이벤트 처리, 데이터 로직 포함
        - 사용 사례
            - 버튼(`PrimaryButton`, `SecondaryButton`)
            - 카드(`InfoCard`, `WarningCard`)