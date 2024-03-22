// Function to add a new product to the My Products section
function addProduct(){
    // Fetch the farmer's email from the input field
    var email = document.getElementById('email').value.trim();
    var productName = document.getElementById('productName').value.trim();
    var imagePath = document.getElementById('imagePath').value.trim();
    var priceQuantity = document.getElementById('priceQuantity').value.trim();
    var productDescription = document.getElementById('productDescription').value.trim();

    // Check if any field is empty
    if(email==="" || productName==="" || imagePath==="" || priceQuantity==="" || productDescription===""){
        alert("Please fill all details");
        return false;
    }

    // Create an object with product data including the farmer's email
var productData = {
    email: email,
    productName: productName,
    imagePath: imagePath,
    priceQuantity: priceQuantity,
    productDescription: productDescription
};

fetch('/products', {
    method: "POST",
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    },
    body: JSON.stringify(productData) // Convert object to JSON string
})
.then(response => response.json())
    .then(data => {
		console.log("if saved")
    	console.log('Product saved:', data);
		alert('User registered successfully');
        // Determine the redirect URL based on the user's role
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to register user');
    });

    return true; // Form is valid, proceed with submission
}
// Function to delete a product
function deleteProduct(productId) {
    // Implement AJAX call to delete product from backend
    // Example:
    // $.ajax({
    //     method: 'DELETE',
    //     url: `/api/products/${productId}`,
    //     success: function (response) {
    //         // Handle success response
    //         removeProductFromUI(productId);
    //     },
    //     error: function (xhr, status, error) {
    //         // Handle error response
    //         console.error(error);
    //     }
    // });

    // For demonstration purposes, remove the product immediately from UI without backend call
    removeProductFromUI(productId);
}

// Function to remove product from UI
function removeProductFromUI(productId) {
    var productRow = document.querySelector(`tr[data-product-id="${productId}"]`);
    if (productRow) {
        productRow.remove();
    }
}

// AJAX function to add a product to the backend
function addProductToBackend(name, imageUrl, price, description) {
    // Implement AJAX call to add product to backend
    // Example:
    // $.ajax({
    //     method: 'POST',
    //     url: '/api/products',
    //     data: {
    //         name: name,
    //         imageUrl: imageUrl,
    //         price: price,
    //         description: description
    //     },
    //     success: function (response) {
    //         // Handle success response
    //         addProduct(name, imageUrl, price, description, response.productId); // Assuming backend returns productId
    //     },
    //     error: function (xhr, status, error) {
    //         // Handle error response
    //         console.error(error);
    //     }
    // });
}

// Function to handle form submission for adding a new product
/*document.getElementById('postProductForm').addEventListener('submit', function (event) {
   event.preventDefault();

    var productName = document.getElementById('productName').value;
    var productImageUrl = document.getElementById('productImage').value; // Changed to productImage
    var productPrice = document.getElementById('priceQuantity').value; // Changed to priceQuantity
    var productDescription = document.getElementById('productDescription').value;

    // Call the AJAX function to add the product to the backend
    addProductToBackend(productName, productImageUrl, productPrice, productDescription);

    // Add the new product to the frontend
    addProduct(productName, productImageUrl, productPrice, productDescription);

    // Reset the form
    this.reset();
});
*/

