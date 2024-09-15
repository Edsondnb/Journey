

//FIZZ buzz

//3 6 9 12 .. fizz, Para los múltiplos de 3 imprime la palabra "Fizz"
//5 10 15 20 .. buzz, múltiplos de 5 imprime "Buzz"
//15 30 45 .. fizbuzzz!, Para los números que son múltiplos de 3 y de 5, imprime

for(let i=0; i < 100; i++){

    if( i % 15 === 0){ //condicion menos comun la que pasará menos veces, por lo tanto deberá ser la que se revise primero
        console.log(`${i} fizzBUZZ`);
    }
    if( i % 3 === 0 ){
        console.log(` ${i} fizz`);
        
    } else if (i % 5 === 0){
         console.log( `${i} buzz`);
    }


}