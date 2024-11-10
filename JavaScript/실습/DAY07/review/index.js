
// 
// const container = document.createElement("section");
// container.style.cssText = "display:flex; flex-direction:column; gap:22px;"

// const btn = document.createElement("button");
// btn.style.cssText = "padding:10px 12pxl color:whitel border-radius:30px";
// btn.innerText = "Button";
// container.appendChild(btn);



const container = document.createElement("section");
container.style.cssText = "display:flex; flex-direction:column; gap:22px;"
document.body.appendChild(container);


const makeButton = () => {
    const buttonBox = document.createElement("section");
    buttonBox.style.cssText(`width:100px; background-color:${color}; border:1px solid ${color};  padding:10px 12pxl color:whitel border-radius:30px`)
    
}


const colorList = ["#2463EB", "#1D4#D8", "#DBEAFE"]l
colorList.forEach((v) => makeButton(v));