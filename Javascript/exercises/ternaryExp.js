class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function ternaryExp(expression){
    let head = new Node(expression[0]);
    let stack = new stack();
    stack.push(head);

    for (let i = 1; i < expression.length; i++) {
        if(expression[i] === '?'){
            node = stack.pop();
            node.left = new Node(expression[i+1]);
            stack.push(node.left);
        } else if(expression[i] === ':'){
            node = stack.pop();
            node.right = new Node(expression[i+1]);
            stack.push(node.right);
        }
    }

}

