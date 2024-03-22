function validateForm() {
    console.log("hello");
    var email = document.getElementById('email').value.trim();
    var password = document.getElementById('password').value.trim();
    
    // Check if email and password are not empty
    if (email === '' || password === '') {
        return false;
    }

    var userData = {
        email: email,
        password: password,
    };

    // Send login request to backend
    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(userData)
    })
    .then(response => {
        if (response.ok) {
            return response.text(); // Parse the response as text
        } else {
            console.error('Error:', response.statusText);
            throw new Error('Failed to log in. Please try again.');
        }
    })
    .then(data => {
        // Determine the redirect URL based on the user's role
        var redirectUrl;
        if (data === '/dashboard-customer.html') {
            redirectUrl = 'dashboard-customer.html';
        } else if (data === '/dashboard-farmer.html') {
            redirectUrl = 'dashboard-farmer.html';
        } else {
            redirectUrl = 'default.html';
        }
        // Redirect the user to the appropriate dashboard
        window.location.href = redirectUrl;
    })
    .catch(error => {
        console.error('Error:', error.message);
        alert(error.message);
    });

    return true; // Form is valid, proceed with submission
}
