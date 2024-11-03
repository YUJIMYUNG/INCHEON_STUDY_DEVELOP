# Centering and Containing

<aside>
💡

**CSS에서 콘텐츠를 중앙에 배치하고 컨테이너 내에 콘텐츠를 포함하는 것은 웹 페이지 디자인에서 자주 사용되는 기술이다.**

</aside>

## 이론

---

### 콘텐츠 포함 (Containing Content)

콘텐츠를 컨테이너 낸부에 포함시키는 방법으로는 주로 `max-width` 와 `margin` 속성을 사용한다.

```css
.container{
	width:100% /* 전체 너비 사용 */
	max-width:1200px; /* 최대 너비 제한 */
	margin : 0 auto;/* 자동 마진으로 중앙 정렬 */
}
```

이 설정은 컨테이너가 뷰포트 너비를 초과하지 않게 하면서, 주어진 최대 너비까지 확장할 수 있도록한다. 또한, `margin: 0 auto;` 는 컨테이너가 항상 뷰포트의 중앙에 위치하도록 보장한다.