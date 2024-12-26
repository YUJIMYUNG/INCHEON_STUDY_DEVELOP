// [1] document 
console.log( document );

// [2] document.querySelector('CSS선택자')
console.log( document.querySelector('title') ); // <title>Page Title</title>
console.log( document.querySelector('body') );

// [3] document.querySelector('마크업명')
console.log( document.querySelector('div') );
console.log( document.querySelectorAll('div') );

// [4] document.querySelector('.class명');
console.log( document.querySelector('.box2') );

// [5] document.querySelector('#id명');
console.log( document.querySelector('#box3') );

// [6] value속성 
console.log( document.querySelector('.inputBox1').value );

// [7] innerHTML 속성 
console.log( document.querySelector('.printBox1').innerHTML )

// [8] style 속성 
document.querySelector('.printBox1').style = 'color:red;'

// [9] src 속성 
document.querySelector('.imgBox1').src = './짱구.jpg'