const meses = ['enero','febreo' ,'Marzo' ,'Abril']; 
const meses2 = ['junio','julio']; 
const meses3 = ['agosto','setiembre']; 


//.concat

const resultado = meses.concat(meses2, meses3)
console.log(resultado);

// spread operator
const resultado2 = [...meses, ...meses2];
console.log(resultado2);