<aside>
💡

**React 컴포넌트에서 부모로부터 데이터를 전달받기 위한 속성(properties)**

</aside>

## Props란?

- Props(properties) 는 React 컴포넌트의 입력값으로, 부모 컴포넌트가 자식 컴포넌트에 데이터를 전달하는데 사용

## Props사용법

```jsx
const Child = (props) => <h1>{props.name]</h1>

const Parent = () => {
	return <Child name="페이커" />
}
```

## Props의 특징

1. 단방향 데이터 흐름
    1. 데이터는 부모 → 자식으로 전달
    2. 자식에서 부모로 데이터를 보낼 경우 콜백함수 사용!
2. 동적 데이터 전달 가능
    1. props로 변수, 상태, 함수 등 다양한 데이터를 전달 가능!