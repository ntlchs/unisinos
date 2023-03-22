'use strict';
const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;
let inputLines = null;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function () {
    inputLines = inputString.split('\n');

    // this is related to question
    // const arrCount = parseInt(readLine(), 10);

    // let arr = [];

    // for (let i = 0; i < arrCount; i++) {
    //     const arrItem = parseInt(readLine(), 10);
    //     arr.push(arrItem);
    // }

    // const k = parseInt(readLine(), 10);

    // replace the function below with your current one
    // const result = findNumber(arr, k);

    writeLine(result + '\n');
    // console.log(inputString);

    ws.end();
});

const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

function readLine() {
    return inputLines[currentLine++].trim();
}

function writeLine(string) {
    ws.write(string);
    console.log(string);
}

//---------------------------------------

function closestNumbers(numbers) {
    numbers.sort((a,b)=>a-b);
    let pairs = getPairs(numbers)
    pairs = getDifference(pairs);
    let result = stringify(pairs);
    console.log(result)
    

}

function getPairs(arr) {
    let result = []
    for (let i = 0; i < arr.length - 1; i++) {
        result.push([arr[i], arr[i+1]]);
  }
  return result;
}

function getDifference(arr) {
  let smallestDiff = Infinity;
  let smallestPairs = [];

  for (let i = 0; i < arr.length; i++) {
    const [num1, num2] = arr[i];
    const diff = Math.abs(num1 - num2);

    if (diff < smallestDiff) {
      smallestDiff = diff;
      smallestPairs = [[num1, num2]];
    } else if (diff === smallestDiff) {
      smallestPairs.push([num1, num2]);
    }
  }
  return smallestPairs;

}

function stringify(arr) {
    const flattenedArr = arr.flat();
    let result = '';

    for (let i = 0; i < flattenedArr.length; i += 2) {
        result += `${flattenedArr[i]} ${flattenedArr[i+1]}`;
        if (i+2 < flattenedArr.length) {
            result += '\n';
        }
  }

  return result;
}