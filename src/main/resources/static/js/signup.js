const id = document.getElementById('id');
const password = document.getElementById('password');
const fname = document.getElementById('name');
const bday = document.getElementById('birthday');
const form = document.getElementById('form');
const email = document.getElementById('email');


form.addEventListener('submit', (e) => {
    e.preventDefault();

    fetch('http://127.0.0.4:1234/', {
        method: 'POST',
        body: JSON.stringify({
            id: id,
            password: password,
            // fname: fname,
            email: email,
            // bday: bday,
        })
    })
        .then(response => response.json())
        .then(res => console.log(res));
});