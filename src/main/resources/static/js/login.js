const id = document.getElementById('id');
const password = document.getElementById('password');

const form = document.getElementById('form');

function login() {
    fetch('apikey', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        }, 
        body: JSON.stringify({
            id: id,
            password: password,
        })
    })
        .then(response => response.json())
        .then(res => console.log(res));
}

form.addEventListener('submit', (e) => {
    e.preventDefault();
    login();
});