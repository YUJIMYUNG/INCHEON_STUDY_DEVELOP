# Root

<aside>
💡

**Root의 의사 클래스는 주로 CSS 색상, 폰트 크기, 마진, 패딩을 정의 하는데 사용되고, 웹 페이지 전체에 걸쳐 일관된 스타일을 유지할 수 있도록 도와준다.**

</aside>

## 이론

---

```css
:root {
	--primary-color : #abcdef;
	--secondary-colo : #efefef;
	--text-color : #dbdbdb;
	--background-colo : #fff;
	
	--font-size : 16px;
	--font-size-large : 20px;
	--font-size-x-large : 24px;
	
	--padding-button : 10px;
	--border-radius: 8px;
}

.apple{
	color : var(--pramary-color)
}

```