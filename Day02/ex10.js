function printMultiplicationTable() {
    var output = '';

    // 1. read the value from the input text box
    var input = document.getElementById('num').value.trim();

    if(!input) return false;

    // 2. try converting the input text into a number
    if(!isNaN(input)) {
        var num = parseInt(input);
        // 3. if successful then generate a string reprensting the table
        for(var i=1; i<=15; i++) {
            output += `${num} X ${i} = ${num*i}<br />`;
        }
    }
    else {
        // 4. if failed, then generate an error string
        output = 'Cannot print table for <b>' + input + '</b>';
    }

    // 5. output the string to a div#d1
    document.getElementById('d1').innerHTML = output;

    // cancel form submission;
    return false;
}

