
function _regist(){

    let phoneInput = document.querySelector('.phoneInput');
    let personelInput = document.querySelector('.personelInput');

    let phone = phoneInput.value;
    let personel = personelInput.value;

    let waitlistDto = {
        "gphone" : phone,
        "gpersonel" : personel
    };

    let option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(waitlistDto)
    };
    
    fetch('/regist.do',option)
    .then(response => response.json())
    .then(data => {console.log(data);        
        alert(`대기번호 ${data}번 입니다.`)
    })
    .catch(error => console.log(error))

    document.querySelector('.phoneInput').value='';
    document.querySelector('.personelInput').value='';

    return;
}

function _print(){

    let teamHTML = document.querySelector('.team');
    let listHTML = document.querySelector('.list');
    
    let HTML1 = ``;
    let HTML2 = '<table border=1><tr><th>대기번호</th><th>핸드폰번호</th><th>인원수</th><th>입장</th><th>삭제</th>'

    fetch('/list.do')
    .then(response => response.json())
    .then(data => {
        console.log(data);
        let waitCount = data.totalWaitCount;
        let waitlist = data.waitList;
        
        HTML1 = `<table border=1><tr><th>현재 대기팀</th><th>${waitCount} 팀</th></tr>`

        for(let index =0; index <= waitlist.length-1; index++){
            let waitlistDto = waitlist[index]
            HTML2 += `<tr><th>${waitlistDto.wait_num}</th><th>${waitlistDto.gphone}</th><th>${waitlistDto.gpersonel}</th>
            <th><button onclick="" type="button">입장</button></th>
            <th><button onclick="_delete(${waitlistDto.gno})" type="button">삭제</button></th>`
        }
        teamHTML.innerHTML = `${HTML1}</table>`
        listHTML.innerHTML =`${HTML2}</table>`
    })
    .catch(error => console.log(error))
}

function _delete(gno){
    fetch(`/delete.do?gno=${gno}`,{method:'DELETE'})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.log(error))
    location='/list'
}

function _mypage(){
    let myphone = document.querySelector('.myphoneInput');
    let phone = myphone.value;

    fetch(`/mypage.do?gphone=${phone}`)
    .then(response => response.json())
    .then(data => {
        console.log(data)
        let mypage = data;
        if (mypage.length==0){alert('명단에 없는 전화번호 입니다.')}
        else{alert(`대기번호:${mypage[0].wait_num}번\n예상대기시간:${mypage[0].wait_time}분 입니다.`);}
    })
    .catch(error => console.log(error))

    document.querySelector('.myphoneInput').value=''
}