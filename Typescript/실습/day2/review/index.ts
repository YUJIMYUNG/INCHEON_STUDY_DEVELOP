// 캐릭터 타입 만들기

// 기본으로 모든 캐릭터는 이름과 레벨을 갖는다.
// 전사 : 힘과 사용하는 무기
// 마법사 : 마나와 사용하는 주문
// 도적: 만첩도와 사용하는 은신
// 궁수 : 정확도와 사용하는 활

type Character = {name:string, level:number};
type Warrior = {power:number, weapon: string[]};
type Wizard = {mana:number, skills:string[] };
type Thief = {agility:number, sealth:string[]};
type Archer = {accuracy:number, bow:string[]};

const myChar: Character & Warrior = {
    name: "전사짱",
    level : 23,
    power : 100,
    weapon : ["도끼", "창"]
};



