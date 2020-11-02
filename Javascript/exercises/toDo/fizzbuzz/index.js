// --- Directions
// Write a program that console logs the numbers
// from 1 to n. But for multiples of three print
// “fizz” instead of the number and for the multiples
// of five print “buzz”. For numbers which are multiples
// of both three and five print “fizzbuzz”.
// --- Example
//   fizzBuzz(5);
//   1
//   2
//   fizz
//   4
//   buzz

function fizzBuzz(n) {
    for (let i = 1; i <= n; i++) {
        let multipleOfThree = i % 3 === 0;
        let multipleOfFive = i % 5 === 0;
        if (!multipleOfFive && !multipleOfThree) {
            console.log(i);
        } else if (multipleOfFive && multipleOfThree) {
            console.log("fizzbuzz");
        } else if (multipleOfFive) {
            console.log("buzz");
        } else if (multipleOfThree) {
            console.log("fizz");
        }
    }
}

module.exports = fizzBuzz;