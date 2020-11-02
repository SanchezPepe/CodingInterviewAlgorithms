// --- Directions
// Given a string, return a new string with the reversed
// order of characters
// --- Examples
//   reverse('apple') === 'leppa'
//   reverse('hello') === 'olleh'
//   reverse('Greetings!') === '!sgniteerG'

// First solution
/* function reverse(str) {
    return str
        .split("")
        .reverse()
        .join("");
} */

// Second solution
function reverse(str) {
    let reversed = "";
    for (let char of str){
        reversed = char + reversed;
        //debugger;
    }
    return reversed;
}

//reverse('asdf');

//Third solution
/* function reverse(str) {
    return str.split("").reduce((rev, char) => char + rev, '');
}
 */


module.exports = reverse;