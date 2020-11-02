// --- Directions
// Given an integer, return an integer that is the reverse
// ordering of numbers.
// --- Examples
//   reverseInt(15) === 51
//   reverseInt(981) === 189
//   reverseInt(500) === 5
//   reverseInt(-15) === -51
//   reverseInt(-90) === -9

// Solution 1
/* function reverseInt(n) {
    let arr = n.toString().split("").reverse();
    if (n < 0){
        arr.pop();
        arr.unshift("-");
    }
    return parseInt(arr.join(""));
} */

// Second solution
function reverseInt(n){
    return parseInt(n.toString().split("").reverse().join("")) * Math.sign(n);
}

module.exports = reverseInt;
