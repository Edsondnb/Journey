


const producto = {
    
    nombreProducto: "Monitor 20 pulgadas",
    precio: 300,
    disponible: true,

    informacion:{
        medidas: {
            peso: '1kg',
            medida: '1m'
        },
        
        fabricacion : {
            pais: 'china'
        }
    }
}

//accediendo con destructuring
const {nombre, informacion , informacion: { fabricacion, fabricacion : { pais} }} = producto;

console.log(informacion);
console.log(fabricacion);
console.log(pais);