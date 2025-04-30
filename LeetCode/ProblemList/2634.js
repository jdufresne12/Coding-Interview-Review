// John Dufresne 4/30/25

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let filteredArr = [];

    for(let i = 0; i < arr.length; i++) {
        if(fn(arr[i], i)) 
            filteredArr.push(arr[i]);
    }
    
    return filteredArr;
};

function greaterThan10(n) { return n > 10; }
const array = [0,10,20,30]

console.log(filter(array, greaterThan10))
