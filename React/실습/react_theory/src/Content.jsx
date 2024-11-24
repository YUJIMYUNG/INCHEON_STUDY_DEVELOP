const Content = () => {
    const listsCss = {
        display : "flex"
        
    }
    const titlesCss = {
        fontSize: "15px",
        color: "gray",
        textAlign: "left",
        padding: "10px"
    }
    const contentsCss = {
        fontSize: "15px",
        textAlign: "right",
        padding: "10px"
    }
    
    
    return (
        <div>
            <div className="list" style={listsCss}>
                <span className="title" style={titlesCss}>차량명</span>
                <span className="contents" style={contentsCss}>쏘렌토</span>
            </div>
            <div className="list" style={listsCss}>
                <span className="title" style={titlesCss}>트림</span>
                <span className="contents" style={contentsCss}>가솔린 터보 2.5 4WD 트렌디</span>
            </div>
            <div className="list" style={listsCss}>
                <span className="title" style={titlesCss}>차량번호</span>
                <span className="contents" style={contentsCss}>123가 0987</span>
            </div>
            <div className="list" style={listsCss}>
                <span className="title" style={titlesCss}>차량등록일</span>
                <span className="contents" style={contentsCss}>2020년 8월 30일(19년형)</span>
            </div>
            <div className="list" style={listsCss}>
                <span className="title" style={titlesCss}>주행거리</span>
                <span className="contents" style={contentsCss}>34,567km</span>
            </div>
        </div>
    );
};

export default Content;