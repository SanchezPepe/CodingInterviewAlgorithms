class Node {
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function collect(node, data, depth){
    if(!node){
        return null;
    }
    if(!data.hasOwnProperty(depth)){
        data[depth] = [];
    }

    data[depth].push(node.data);

    collect(node.left, data, depth+1);
    collect(node.right, data, depth+1);
}

function averageByDepth(rootNode){
    let map = {};
    collect(rootNode, map, 0);
    
    let keys = Object.keys(map);

    let result = [];
    keys.forEach(key => {
        let sum = map[key].reduce((acum, current) => acum + current);
        let avg = sum / map[key].length;
        result.push(avg);
    })
    return result;
}

let root = new Node(8);
let a = new Node(6);
let b = new Node(9);
root.left = a;
root.right = b;

console.log(averageByDepth(root));
/**
    8
4       6
 
 */
