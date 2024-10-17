# CSS Selector & Multi Class

<aside>
💡

**선택자와 클래스 여러 방법 배우기!**

</aside>

## 이론

---

```css

* {color : pink}
div{color : green}
.box{color : red}

.album > img {color : blue}
div p {color : skyblue}
```

- **전체 선택자 ( * )** : 문서의 모든 요소를 선택
- **태그 선택자 (태그)**
- **클래스 선택자 ( .클래스명)**
- **자식 선택자 ( > )**
- **자손 선택자(띄어쓰기)** : 부모 안에 있는 모든 자손 요소를 선택

## 멀티 클래스

---

```html
<div class="box kakao">점심메뉴 추천</div> //별명 두개 (box, kakao)
```

- **멀티 클래스를 활용하여 코드의 양을 줄이기(코드 다이어트)**