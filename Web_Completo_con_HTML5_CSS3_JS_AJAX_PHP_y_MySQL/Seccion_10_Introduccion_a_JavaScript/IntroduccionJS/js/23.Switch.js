//Switch

const metodoPago = 'Bitcoin';

switch (metodoPago) {
    case 'Tarjeta':
        console.log('Pagaste con tarjeta');    
        break;
    case 'Efectivo':
        console.log('Pagaste con Efectivo');    
        break;
    case 'Bitcoin':
        console.log('Pagaste con Bitcoin');    
        break;
    default:
        console.log('Pagaste con Yape');
        break;
}

console.log(metodoPago);