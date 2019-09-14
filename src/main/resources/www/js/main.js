// alert("test");
// $.getJSON('http://localhost:8080/api/UserClass/')

// var UserClasses = $.ajax({
//
//     type: "GET",
//     data: $(this).serialize(),
//     username: "root",
//     password: "root",
//     dataType: "json"
//     success: function (data) {
//
//     }
// });

var data;

var aJax = $.ajax({
    xhrFields: {
        withCredentials: true
    },
    beforeSend: function (xhr) {
        xhr.setRequestHeader('Authorization', 'Basic ' + btoa('root:root'));
        xhr.overrideMimeType('application/json;charset=utf-8')
        // xhr.setRequestHeader('User-Agent', 'PostmanRuntime/7.16.3')
        // xhr.setRequestHeader('Accept-Encoding', 'gzip, deflate')
        xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8')
        // xhr.setRequestHeader('Accept-Encoding', 'gzip, deflate')
    },
    crossDomain: true,
    type: "GET",
    url: 'http://localhost:8080/api/UserClass/',
    // data: data,
    // data: {username: "root", password: "root"},
    // contentType: "application/json; charset=utf-8",
    dataType: "json"



    // success: function (results) {
    //
    //     console.log(JSON.parse(results));
    //
    // }
});

// console.log(data);

// $.getJSON('http://localhost:8080/api/UserClass/', data, )

// for (var i in aJax.done()) {
//     console.log(i);
// }
//
console.log(aJax.done());
// console.log(JSON.parse(aJax.serialize()));


