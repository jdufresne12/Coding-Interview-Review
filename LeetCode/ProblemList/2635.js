// John Dufresne 4/30/25

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let transformed = [];

    arr.forEach((element, i) => transformed.push(fn(element, i)));

    return transformed;
};