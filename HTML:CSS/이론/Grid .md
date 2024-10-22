# Grid

<aside>
💡

**Grid 를 사용하면 행과 열을 기반으로 요소를 정렬하고 배치할 수 있으며, 유연성과 반응성 있는 웹 디자인을 효율적으로 설계할 수 있다.**

</aside>

## 이론

---

- Container 설정
    - grid : 자식들을 바둑판화 or 행렬로 바꾸는 속성
    - grid-template-columns : 열의 크기를 정의
    - repeat : 반복 횟수와 크기를 설정함
    
    ```css
    .container{
    	display : grid;
    	grid-template-columns:repeat(2, 1fr); //2열로 만드는 속성
    }
    ```