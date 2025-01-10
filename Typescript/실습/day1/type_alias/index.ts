type coffee = {name:string, price:number};

const americano: coffee = {name:"아아", price:3000};

//타입 빵 = 이름, 칼로리, 성분, 가격
type bread = {name:string, kcal:number, ingredient:string[], price:number};

const breadMenu:bread[] = [
    {name:"단팥빵", kcal:300, ingredient:[ "밀가루", "단팥"], price:2000},
    {name:"소금빵", kcal:300, ingredient:["소금", "밀가루"], price:2000},
]

//대학생 타입 = 이름, 나이, 전공, 학번, 학년
type Person = {name:string, age:number };
type Student = {major:string, id:number, grad:number};
type University = Person & Student;

const kim: University = {
    name:"김탁구",
    age:20,
    major:"컴공",
    id:250012,
    grad:1
}

//유저타입
//User타입 : id, username
//Profile 타입 : firstname, lastname, email
/// UserProfile
type User = {id:string, username:string};
type Profile = {firstname:string, lastname:string, email:string};
type UserProfile = User & Profile;

const tomas:UserProfile = {
    id:"tomasKig",
    username :"tomas",
    firstname :"tony",
    lastname: "tomas",
    email: "tomas@gmail.com"
}


//블로그 게시글
//Post 타입 : postid, title, content
//Autor 타입 : authorId, name, gender
//PostWithAuthor
type Post = {postid: string, title: string, content: string};
type Author = {authorid:string, name : string, gender:string};
type PostWithAuthor = Post & Author;

//함수타입 알리아스 만들기
// 두 매개변수 더하는 함수 타입 만들기
type Operation = (x:number, y:number) => number;

const add1: Operation = (x, y) => x + y;
const minus1: Operation = (x, y) => x - y;

