/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    if(this.length === 0)
        return -1;
    return this.at(this.length - 1)
};

// Input: nums = [null, {}, 3]
// Output: 3
const arr = [1, 2, 3];
console.log(arr.last());
