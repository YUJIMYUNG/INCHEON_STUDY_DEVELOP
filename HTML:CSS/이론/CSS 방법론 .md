# CSS 방법론

<aside>
💡

CSS코드를 더 효율적으로 관리하고 유지보수하기 위한 패턴이나 규칙

</aside>

## 이론

---

### BEM(Block, Element, Modifier)

![image.png](CSS 방법론/image.png)

- 구조 : block\_\_element—modifier
- 장점 : 클래스 이름의 역할이 명확하게 나타남

### OOCSS(Object-Oriented CSS)

- 구조와 스킨을 분리하기
- 컨테이너(박스)와 콘텐츠 분리하기

```css
/* 구조와 스킨을 분리하기 */
.box {
  padding: 20px;
}

.box-blue {
  background-color: blue;
  color: white;
}

.box-red {
  background-color: red;
  color: black;
}

/* 컨테이너(박스)와 콘텐츠 분리하기 */
.card {
  padding: 10px;
  border: 1px solid gray;
}

.card-title {
  font-size: 20px;
}

.card-desc {
  font-size: 15px;
}
```
