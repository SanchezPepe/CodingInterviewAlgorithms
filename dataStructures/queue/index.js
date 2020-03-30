class Queue {
	constructor() {
		this.data = [];
	}

	add(record) {
		this.data.unshift(record);
	}

	remove() {
		return this.data.pop();
	}

	peek() {
		return this.data[this.data.length-1];
	}

	isEmpty(){
		return this.data === 0;
	}
}

module.exports = Queue;
