// --- Directions
// Given a string, return the character that is most
// commonly used in the string.
// --- Examples
// maxChar("abcccccccd") === "c"
// maxChar("apple 1231111") === "1"

function maxChar(str) {
    let obj = {};
    let arr = str.split("");
    for(let i = 0; i < arr.length; i++){
        if(arr[i] in obj){
            obj[arr[i]] += 1;
        } else{
            obj[arr[i]] = 1;
        }
    }
    let values = Object.values(obj); //Obtengo los acumuladores
    let indexOfMax = values.indexOf(Math.max(...values)); //Busco el máximo y en qué indice está
    let keys = Object.keys(obj); //Obtengo los llaves e inserto el índice
    return keys[indexOfMax];
}

module.exports = maxChar;
