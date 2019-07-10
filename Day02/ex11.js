function showCurrentTime() {
    console.log(new Date())
}

function sleep(delay = 1000) {
    var startTime = Date.now();
    while((Date.now() <= (startTime + delay))) ;
}

function execAfterDelay(callbackFn, delay) {
    if(typeof callbackFn !== 'function') {
        throw 'callback is not a function'
    }
    if(typeof delay !== 'number') {
        throw 'delay must be a number';
    }
    delay = Math.abs(delay);
    console.log('going to sleep now...')
    sleep(delay);
    console.log('woke up just now...')
    callbackFn();
}

console.log('Start of script');
setTimeout(showCurrentTime, 20000);
console.log('End of script')