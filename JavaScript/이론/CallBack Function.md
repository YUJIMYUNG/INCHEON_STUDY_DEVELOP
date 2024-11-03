# CallBack Function

<aside>
💡

다른 함수의 매개변수로  전달되어 실행되는 함수! ex) 마술상자 안에 마술상자!

</aside>

## Grammer

---

```jsx
fucntion test(callback) {
	// 코드 실행
	callback()
}

const test = (callback) => {
	// 코드 실행
	callback()
}
```

### 콜백함수 안에 매개변수 전달

---

```java
const elementSkill = (element) => {
    console.log(`${element} 모으기`);
    console.log(`${element} 발사`);
}

test(getOne()); // test에 getOnee함수를 넣기
test(getOne); // test에 1을 넣기

triggerSkill(()=>elementSkill(skills[skillNumber]));
```