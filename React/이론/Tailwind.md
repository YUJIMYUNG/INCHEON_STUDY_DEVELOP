# Tailwind CSS Library

<aside>
💡

**Tailwind CSS Library는 Utility-First 디자인 원칙을 기반으로 한 CSS 프레임워크로, 클래스명을 사용하여 스타일을 빠르고 효율적으로 적용할 수 있도록 설계된 도구이다.**

</aside>

## TailWind CSS의 주요 특징

---

1. **Utility-First Framwork**
    - 미리 정의된 유틸리티 클래스 사용(예 : bg-blue-500, text-center)
    - CSS를 직접 작성하지 않고 클래스 조합으로 디자인 구현 가능
2. **커스터마이징 가능**
    - tailwind.config.js 파일을 통해 프로젝트에 맞게 테마와 스타일 확장 가능
3. **모듈화된 CSS**
    - HTML 과 CSS가 밀접하게 연결되어 가독성과 유지보수성이 향상
4. **미니멀한 출력**
    - 사용하지 않는 CSS는 제거(purge)하여 최적화된 CSS파일 생성 가능

## 설치법

---

[Install Tailwind CSS with Create React App - Tailwind CSS](https://tailwindcss.com/docs/guides/create-react-app)

- vscode 익스텐션에 tailwind intellisens를 설치하면 더 간편하게 사용 가능

## Tailwind CSS 클래스 구성

---

1. 텍스트 스타일
    1. 폰트 크기 : `text-sm`, `text-lg`, `text-2xl` 등
    2. 폰트 색상 : `text-red`, `text-yellow` 등
    3. 폰트 두께 : `font-thin`, `font-bold`, `font-extrabold` 등
    4. 정렬 : `text-center`, `text-justify` 등
2. 색상  스타일
    1. 배경색 : `bg-red-500`, `bg-bule-400` 등
    2. 테두리 색상 : `border-green-300`, `border-yelllow-200` 등
3. 레이아웃 스타일
    1. 여백
        1. 패딩 : `p-1`, `p-3`, `p-4`, `px-1`, `py-2` 등
        2. 마진 : `m-1`, `m-5`, `m-10`, `mx-1`, `my-10` 등
    2. 플렉스박스 : `flex`, `justify-옵션`, `items-옵션`
4. 상태 클래스
    1. hover : `hover:bg-blue-700`
    2. active(클릭시) : `active:text-red-300`
5. 기타 클래스
    1. 너비 및 높이 : `w-값`, `h-값`
    2. 테두리 : `border`, `border-2`, `rounded(9999px)`
    3. 그리드 : `grid`, `grid-cols-값`