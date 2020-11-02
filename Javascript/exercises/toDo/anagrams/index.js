// --- Directions
// Check to see if two provided strings are anagrams of eachother.
// One string is an anagram of another if it uses the same characters
// in the same quantity. Only consider characters, not spaces
// or punctuation.  Consider capital letters to be the same as lower case
// --- Examples
//   anagrams('rail safety', 'fairy tales') --> True
//   anagrams('RAIL! SAFETY!', 'fairy tales') --> True
//   anagrams('Hi there', 'Bye there') --> False

/* function anagrams(stringA, stringB) {
    let charAccumulator = {};
    let cleanedA = stringA.replace(/[^\w]/g, '').toLowerCase();
    let cleanedB = stringB.replace(/[^\w]/g, '').toLowerCase();
    if (cleanedA.length != cleanedB.length)
        return false;
    cleanedA.split("").forEach(elem => {
        if (charAccumulator.hasOwnProperty(elem))
            charAccumulator[elem] += 1;
        else
            charAccumulator[elem] = 1;
    });
    console.log(charAccumulator, cleanedB);
    for (let i = 0; i < cleanedB; i++) {
        if (!charAccumulator.hasOwnProperty(elem))
            return false;
    }
    return true;
} */

// First solution
function anagrams(stringA, stringB) {
    let cleanedA = stringA.replace(/[^\w]/g, '').toLowerCase().split("").sort().join("");
    let cleanedB = stringB.replace(/[^\w]/g, '').toLowerCase().split("").sort().join("");
    return cleanedA === cleanedB;
    // Considerar caso en el que se usa JSON.stringify;
}


// Second solution
/* function anagrams(stringA, stringB) {
    const aCharMap = buildCharMap(stringA);
    const bCharMap = buildCharMap(stringB);
    if(Object.keys(aCharMap).length !== Object.keys(bCharMap).length){
        return false;
    }
    for(let char in aCharMap){
        if (aCharMap[char] !== bCharMap[char]) {
            return false;
        }
    }
    return true;
}

function buildCharMap(str) {
    const charMap = {};
    for (let char of str) {
        charMap[char] = charMap[char] + 1 || 1;
    }
    return charMap;
}
 */

module.exports = anagrams;