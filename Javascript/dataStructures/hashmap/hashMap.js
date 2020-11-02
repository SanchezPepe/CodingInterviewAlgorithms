class HashMap {
    constructor(){
        this.data = {};
    }

    add(key, value){
        this.data[key] = value;
    }

    containsKey(key){
        return this.data.hasOwnProperty(key);
    }

    size(){
        return Object.keys(this.data).length;        
    }

    remove(key){
        return delete this.data[key];
    }
}

module.exports = HashMap;
