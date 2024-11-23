# React Design Pattern(전략론)

<aside>


**💡코드를 유지보수 하기 위한 필수 패턴!**

</aside>

## 컴포넌트 분류 패턴

---

1. 매크로 레벨 패턴(아키텍쳐 패턴)
    - 🎨 Hierarchical Component Pattern
        
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
        
2. 마이크로 레벨 패턴(구현패턴)