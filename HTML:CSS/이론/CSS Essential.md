# CSS Essential

<aside>
💡

**필수 CSS 모음집 반드시 친해지기! 💞**

</aside>

[How to organize CSS @ 9elements](https://9elements.com/css-rule-order/)

## 이론

---

### BoxModel

- border : 테두리 관련 속성
- border-radius : 테두리 모퉁이 관련 속성
- padding : 요소 내부 공간 속성
- margin : 요소 외부 공간 속성
- box-shadow : 그림자
- width : 넓이
- height : 높이

### Background

- background-color : 배경 색상 관련 속성
- cursor : 마우스 포인터 속성

### Typography

- font-weight : 글자 두께
- color : 글자 색상
- font-size : 글자 크기
- font-family : 글자 스타일
- text-align : 글자 위치 조정
- text-transform : 대소문자 설정
- word-spaceing : 글자 사이 공간

### Display and Visibility

- display : 태그를 어떻게 나타내는지에 대한 속성
- opacity : 투명도
- transform : 태그를 변화시키는 속성
    - rotate : 회전 (ex : 45deg)
    - scale : 크기 (ex : 2 → 2배)
    - translate : 이동 (ex : 100px,100px → x축 100px 이동, y축 100px 이동)

### Position

- position : 요소의 위치 지정(top, bottom, right, left 필수)
    - relative : 자기 자리에서 위치 조정
    - absolute : 부모가 relative이면 그 기준으로 위치 조정
    - fixed : 브라우저 기준으로 위치 조정
- z-index : 요소의 겹침(레이어 순서)을 조정

### Animation

- transition : 요소에 변화를 주는 속성을 컨트롤하는 속성
    - 타겟 시간 변화함수
- animation : keyframe에 정의된 애니메이션을 실행해주는 속성

```css
animation: flip-scale-2-hor-top 1s linear both;

@keyframes abc {
    from{
        background-color: skyblue;
    }
    to{
        background-color: pink;
        transform: scale(1.5) translate(50px, 50px);
    }
    
}

  @keyframes flip-scale-2-hor-top {
    0% {
      -webkit-transform: translateY(0) rotateX(0) scale(1);
              transform: translateY(0) rotateX(0) scale(1);
      -webkit-transform-origin: 50% 0%;
              transform-origin: 50% 0%;
    }
    50% {
      -webkit-transform: translateY(-50%) rotateX(-90deg) scale(2);
              transform: translateY(-50%) rotateX(-90deg) scale(2);
      -webkit-transform-origin: 50% 50%;
              transform-origin: 50% 50%;
    }
    100% {
      -webkit-transform: translateY(-100%) rotateX(-180deg) scale(1);
              transform: translateY(-100%) rotateX(-180deg) scale(1);
      -webkit-transform-origin: 50% 100%;
              transform-origin: 50% 100%;
    }
```