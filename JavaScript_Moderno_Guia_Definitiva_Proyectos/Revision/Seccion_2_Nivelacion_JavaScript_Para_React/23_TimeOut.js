
const evaluar = () => {
    const edad = prompt("Cual es tu edad?");

    if(edad >= 18){
        console.log("Eres mayor de edad");
        return;
    } 

    console.log("Eres menor de edad");      
}

evaluar();