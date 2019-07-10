var fetchContactDetails = function () {
    var id = document.getElementById("contactId").value;
    if (!id) return;

    var url = "http://10.150.120.87:4000/contacts/" + id;
    var xhr = new XMLHttpRequest();
    // console.log('xhr.readyState is', xhr.readyState); // --> 0 (uninitialized)
    xhr.open('GET', url, true);
    // console.log('xhr.readyState is', xhr.readyState); // --> 1 (initialized)

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            // JOB-TO-BE-DONE when the response is complete
            if(xhr.status===200) {
                var p1 = JSON.parse(xhr.responseText);
                document.getElementById('name').innerHTML = p1.firstname + ' ' + p1.lastname;
                document.getElementById('phone').innerHTML = p1.phone;
                document.getElementById('email').innerHTML = p1.email;
                document.getElementById('picture').setAttribute('src', p1.picture);

            }
            else {
                alert('No data found for the id: ' + id);
            }
        }
    };

    xhr.send(); // at this time xhr.readyState --> 2 (request sent),
    // and becomes 3 (interactive) and 4 (complete)
}