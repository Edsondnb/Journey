

const suma = (a, b) => {
    return new Promise ((resolve, reject) => {
        if(a < 0 || b < 0){
            reject("Esto no es valido");
        }else{
            resolve(a + b);
        }
    }); 
};

const resultado = suma(-3, 5).then((res) => {
    console.log(resultado);
}).catch((error) => {
    console.log(error);
});

console.log(resultado);
