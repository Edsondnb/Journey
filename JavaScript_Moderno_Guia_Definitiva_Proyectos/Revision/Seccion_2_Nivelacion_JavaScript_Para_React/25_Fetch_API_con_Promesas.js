
fetch('https://jsonplaceholder.typicode.com/users/1')
    .then((response) => {
        console.log(response);
        return response.json();
    }).then((data)=>{
        return console.log(data);
    });
