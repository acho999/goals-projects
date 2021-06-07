//тук ще държим всичко което не е action което не модифицира стейта в главния компонент
// и също така не е свързано с някакъв компонент

export function getRandomNumber () {

    return Math.floor(Math.random() * 11);//that way we return random number between 0 an 10, 
    //we can also specify thes constraints as parameters in the function

}

export function getRandomColor(){

    const colors = ['red','green','blue','pink','yellow']

    return colors[Math.floor(Math.random() * colors.length)];

}