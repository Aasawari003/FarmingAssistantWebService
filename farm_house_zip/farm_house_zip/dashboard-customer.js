document.addEventListener('DOMContentLoaded', function () {
    // Smooth navigation between nav options
    document.querySelectorAll('.navbar-nav a').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();

            const targetId = this.getAttribute('href');
            const targetElement = document.querySelector(targetId);

            window.scrollTo({
                top: targetElement.offsetTop,
                behavior: 'smooth'
            });
        });
    });

    // Redirect to QR code payment page when adding to cart
    document.querySelectorAll('.btn-add-to-cart').forEach(btn => {
        btn.addEventListener('click', function (e) {
            e.preventDefault();
            alert('Redirecting to QR code payment page...');
            // Redirect to QR code payment page
            window.location.href = 'qr-code-payment.html';
        });
    });


    // Like functionality for farmer posts
    document.querySelectorAll('.btn-like').forEach(btn => {
        btn.addEventListener('click', function (e) {
            e.preventDefault();
            alert('Liked the farmer post!');
        });
    });

    // Comment functionality for farmer posts
    document.querySelectorAll('.btn-comment').forEach(btn => {
        btn.addEventListener('click', function (e) {
            e.preventDefault();
            alert('Commented on the farmer post!');
        });
    });

    // Share farmer post
    document.querySelectorAll('.btn-share').forEach(btn => {
        btn.addEventListener('click', function (e) {
            e.preventDefault();
            alert('Generating shareable link...');
        });
    });

    // Sample order history data (replace with actual data from backend)
    const orderHistoryData = [
        { orderId: '12345', productName: 'Product 1', quantity: 2, totalPrice: '$20', status: 'Delivered' },
        { orderId: '67890', productName: 'Product 2', quantity: 1, totalPrice: '$15', status: 'Shipped' }
    ];

    // Function to generate HTML for order history table rows
    function generateOrderHistoryRows(data) {
        let html = '';
        data.forEach(order => {
            html += `
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.productName}</td>
                    <td>${order.quantity}</td>
                    <td>${order.totalPrice}</td>
                    <td>${order.status}</td>
                </tr>
            `;
        });
        return html;
    }

    // Display order history data in the table
    const orderHistoryTable = document.getElementById('orderHistoryTable');
    orderHistoryTable.innerHTML = `
        <table class="table">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                ${generateOrderHistoryRows(orderHistoryData)}
            </tbody>
        </table>
    `;

    // AJAX call to fetch order history data from the backend (replace with actual AJAX call)
    // $.ajax({
    //     url: '/api/order-history',
    //     method: 'GET',
    //     success: function (response) {
    //         // Populate the order history table with response data
    //         const orderHistoryData = response.data;
    //         orderHistoryTable.innerHTML = `
    //             <table class="table">
    //                 <thead>
    //                     <tr>
    //                         <th>Order ID</th>
    //                         <th>Product Name</th>
    //                         <th>Quantity</th>
    //                         <th>Total Price</th>
    //                         <th>Status</th>
    //                     </tr>
    //                 </thead>
    //                 <tbody>
    //                     ${generateOrderHistoryRows(orderHistoryData)}
    //                 </tbody>
    //             </table>
    //         `;
    //     },
    //     error: function (xhr, status, error) {
    //         console.error(error);
    //     }
    // });
});
