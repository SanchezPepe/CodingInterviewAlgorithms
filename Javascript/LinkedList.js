class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    constructor(data){
        this.head = new Node(data);
        this.size = 1;
    }

    add(data){
        let list = this.head;
        while(list.next !== null){
            list = list.next;
        }
        list.next = new Node(data);
        this.size++;
    }

    delete(){
        if(this.size === 0){
            return null;
        } else {
            let list = this.head;
            while(list.next.next !== null){
                list = list.next;
            }
            let ans = list.next;
            list.next = null;
            size--;
            return ans;
        }
    }

    reverse(){
        this.traverse(this.head);
    }

    traverse(node){
        if(node.next === null){
            this.head = node;
            return this.head;
        } else {
            let prev = this.traverse(node.next);
            node.next = null;
            prev.next = node;
            return node;
        }
    }

    printList(){
        let output = "";
        let list = this.head;
        while(list !== null){
            output += list.data + ' -> ';
            list = list.next
        }
        console.log(output.substring(0, output.length-3));
    }
}

function test(){
    let list = new LinkedList(0);
    for (let i = 1; i <= 5; i++) {
        list.add(i);
    }
    list.printList();
    console.log(list.reverse());
    list.printList();

}

test();