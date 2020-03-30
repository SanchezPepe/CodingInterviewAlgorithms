// --- Directions
// Write a function that accepts an integer N
// and returns a NxN spiral matrix.
// --- Examples
//   matrix(2)
//     [[1, 2],
//     [4, 3]]
//   matrix(3)
//     [[1, 2, 3],
//     [8, 9, 4],
//     [7, 6, 5]]
//  matrix(4)
//     [[1,   2,  3, 4],
//     [12, 13, 14, 5],
//     [11, 16, 15, 6],
//     [10,  9,  8, 7]]

function matrix(n) {
    let count = 1;
    let matrix = new Array(n);
    for(let i = 0; i < matrix.length; i++){
      matrix[i] = new Array(n);
    }
    let firstC = 0;
    let lastC = n - 1;
    let firstR = 0;
    let lastR = n - 1;
    while(count <= n*n){
        let iterator = firstC;
        while(iterator <= lastC){
            matrix[firstR][iterator] = count;
            iterator++;
            count++;
        }
        firstR++;
        iterator = firstR;
        while(iterator <= lastR){
            matrix[iterator][lastC] = count;
            iterator++;
            count++;
        }
        lastC--;
        iterator = lastC;
        while(iterator >= firstC && count <= n*n){
            matrix[lastR][iterator] = count;
            iterator--;
            count++;
        }
        lastR--;
        iterator = lastR;
        while(iterator >= firstR){
            matrix[iterator][firstC] = count;
            iterator--;
            count++;
        }
        firstC++;
    }
    return matrix;
}

module.exports = matrix;
