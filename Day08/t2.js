function test() {
    console.log('testing...')
    if(require('./t1')) {
        if(fs.exists(__filename)) {
            test();
        }
    }
}
test();