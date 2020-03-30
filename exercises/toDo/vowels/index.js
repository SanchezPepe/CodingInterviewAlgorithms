// --- Directions
// Write a function that returns the number of vowels
// used in a string.  Vowels are the characters 'a', 'e'
// 'i', 'o', and 'u'.
// --- Examples
//   vowels('Hi There!') --> 3
//   vowels('Why do you ask?') --> 4
//   vowels('Why?') --> 0

function vowels(str) {
    let vowels = str.replace(/[^aeiou]/gi, '');
    // let matches = str.match(/[aeioy]/gi/);
    // return matches ? matches.length : 0;
    console.log(str, vowels);
    return vowels.length;
}

function vowels2(str){
    let vowels = ['a', 'e', 'i', 'o', 'u'];
    let count = 0;
    for(let char of str.toLowerCase()){
        if(vowels.includes(char)){
            count++;
        }
    }
    return count;
}

module.exports = vowels;
