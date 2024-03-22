// register.js
function validateForm() {
    var name = document.getElementById('name').value.trim();
    var contactinfo = document.getElementById('contactinfo').value.trim();
    var email = document.getElementById('email').value.trim();
    var password = document.getElementById('password').value.trim();
    var role = document.getElementById('role').value;

    // Check if name, email, password, role, and contact info are not empty
    if (name === '' || email === '' || password === '' || role === '' || contactinfo === '') {
        alert('Please fill in all required fields.');
        return false;
    }

    // Prepare data to send to the backend
    var userData = {
        name: name,
        email: email,
        password: password,
        role: role,
        contactinfo: contactinfo
    };

    // Submit the form data to the backend
    fetch('/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify(userData)
    })
    .then(data => {
		alert('User registered successfully');
        // Determine the redirect URL based on the user's role
        var redirectUrl;
        if (role === 'customer') {
            redirectUrl = 'dashboard-customer.html';
        } else if (role === 'farmer') {
            redirectUrl = 'dashboard-farmer.html';
        } else {
            // Handle other roles or default redirect
            redirectUrl = 'default.html';
        }
        // Redirect the user to the appropriate dashboard
        window.location.href = redirectUrl;
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to register user');
    });

    return true; // Form is valid, proceed with submission
}
