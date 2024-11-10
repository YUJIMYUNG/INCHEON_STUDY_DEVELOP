const makeImg = (image) => ` 
    <div class="image">
        <img src="${image}" alt="">
    </div>`;

const makeInfo = (price, detail) => 
    `
    <div class="info">
        <h5>${price} </h5>
        <span>${detail}</span>
    </div>

` 

export const makeRoomCard = (image, price, detail) => 
    `
     <div class="roomCard">
       ${makeImg(image)}
       ${makeInfo(price, detail)}
    </div>
    `
