const Cart = () => {

    //event.preventDefault();


    return (
        <div class="list-group">
            <label class="list-group-item d-flex justify-content-between lh-sm">
                <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="" />
                <div>
                    <h6 class="my-0">Product name</h6>
                    <small class="text-body-secondary">Category</small>
                </div>
                <span class="text-body-secondary">$12</span>
            </label>
            <label class="list-group-item d-flex justify-content-between lh-sm">
                <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="" />
                <div>
                    <h6 class="my-0">Product name</h6>
                    <small class="text-body-secondary">Category</small>
                </div>
                <span class="text-body-secondary">$12</span>
            </label>
            <label class="list-group-item d-flex justify-content-between lh-sm">
                <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="" />
                <div>
                    <h6 class="my-0">Product name</h6>
                    <small class="text-body-secondary">Category</small>
                </div>
                <span class="text-body-secondary">$12</span>
            </label>


            <div class="form-check text-start my-0.5"></div>
            <button class="w-100 btn btn-dark btn-primary btn-lg" type="submit">Order</button>
            <p class="mt-5 mb-3 text-body-secondary">© 2024</p>
        </div>
    );
}

export default Cart;