
const checkedBoxes = [
    {id:"checkbox2", isChecked:false, isNecessary:true},
    {id:"checkbox3", isChecked:false, isNecessary:true},
    {id:"checkbox4", isChecked:false, isNecessary:true},
    {id:"checkbox5", isChecked:false, isNecessary:true},
    {id:"checkbox6", isChecked:false, isNecessary:false},
    {id:"checkbox7", isChecked:false, isNecessary:false},
]

const chekedButton = document.getElementById("chekedButton");

checkedBoxes.forEach((v) => {
   const tag = document.getElementById(v.id);
   //check표시 갱신 로직
   tag.addEventListener('input' , (e) => {
    v.isChecked = e.target.checked;
    console.log(checkedBoxes);


    //필수이면서 모두 체크된 상황의 로직
    if (checkedBoxes.every((v) => (v.isNecessary==true ? v.isChecked : true))){
        checkedButton.classList.add("checked");
        checkedButton.classList.remove("notChecked");
   } else {
        checkedButton.classList.add("notChecked");
   }
   }); 
})

const all = document.getElementById("all");

all.addEventListener('input', (e) => {
    if(e.target.checked == true) {
        checkedBoxes.map((v) =>{
        v.isChecked = true;
        return v;
    });
     } else {
        checkedBoxes.map((v) =>{
        v.isChecked = false;
        return v;
    });
}

checkedBoxes.forEach((v) => {
    const tag = document.getElementById(v.id);
    tag.checked
})
})
