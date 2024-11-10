const makeImg = (image) => 
    `
    <div class="image">
        <img src="${image}" alt="">
    </div>
`

const makeName = (name) =>
    `
    <div class="name">
        <span>${name}</span>
    </div>

`

export const makeNameTag = (image, name) =>
    `
    <div class="nameTag">
        ${makeImg(image)}
        ${makeName(name)}
    </div>
`