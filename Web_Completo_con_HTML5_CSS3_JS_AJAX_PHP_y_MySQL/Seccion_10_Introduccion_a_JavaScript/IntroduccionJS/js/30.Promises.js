//Promises

const usuarioAutenticado = new Promise ( (resolve, reject) => {
        const auth = true;

        if (auth) {
            resolve('Usuario autenticado'); //el proimise se cumple
        } else {
            reject('No se pudo iniciar sesion');
        }
});

//console.log(usuarioAutenticado);x

usuarioAutenticado
    .then(resultado => console.log(resultado)) //then => entonces, usado para acceder al promises
    .catch(error => console.log(error))


//En los PROMISE existe 3 valores
//Pending: No se ha cumplido pero tampoco se ha rechazado
//Fulfield: ya se cumplio
//Reflected: se ha rechazado o no se puede cumplir