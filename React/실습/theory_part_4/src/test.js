const coffee = {name:"아메리카노", price:2500, shots:3};
const coffee1 = {name:"라떼", price:3000, shots:2};

const newCoffee =  {...coffee, ...coffee1};


const arr  = [5, 7, 9, 11, 13];
// arr.map((v, i) => {}) v는 값, i는 index 번호
// arr.filter((v, i) => {})

//문제1
const menu = [
    {name: "커피", price:2500},
    {name: "도너츠", price:3000},
    {name: "타르트", price:3500}
]

menu.map((v, i) => {
    v.id = i +1;
    return v;
})

//또는( 아래 문법을 지향한다 )
menu.map((v, i) => {
    return {...v, id : i+1};
})


//문제2
const startbucks = [
    {name:"americano", shots:2, price:4000},
    {name:"latte", shots:2, price:5000},
    {name:"mint", shots:0, price:5500},
];

// 각각 no : 0~2 추가해주기
startbucks.map((v, i) => {
    return {...v, no : i};
})

// shots을 하나씩 늘려주고 가격을 1000원을 더해서 새로운 리스트 만들기
const starbucksAdd = startbucks.map((v, i) => {
    const addShots = v.shots + 1;
    const addPrice = v.price + 1000;
    return {...v, shots : addShots, price:addPrice}
})