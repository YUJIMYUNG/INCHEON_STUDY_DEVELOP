type Job = "sales" | "engineer" | "account";

type Worker_ = {
    [key in Job]:String;
};
const myJob:Worker_ = {
    engineer:"자바",
    account:"회계",
    sales: "판매",
}

// 서브웨이 샌드위치
type OrderWay = {
    bread : string,
    cheese: string,
    vegitable : string[],
    source :string[]
}

type SubwaySetKey = keyof OrderWay
type Order = {
    [key in SubwaySetKey] : string | string[];
};

const mySubway:Order = {
    bread:"플랫브래드",
    cheese:"슈레드",
    vegitable : ["양파", "상추"],
    source: ["랜치", "마요네즈"]
}