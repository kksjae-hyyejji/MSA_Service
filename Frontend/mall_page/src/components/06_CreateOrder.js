const CreateOrder = () => {

    //event.preventDefault();


    return (
        <div class="col-md-7 col-lg-8">

            <form>
                <h5 style={{ color: 'blue' }}>Orderer</h5>
                <hr class="my-3" />
                <div class="col-12">
                    <label class="form-label">Id</label>
                    {/* TO DO :: login Id로 고정 */}
                    <input type="text" class="form-control" placeholder="loginId" value="loginId" />
                </div>

                <div class="form-check text-start my-0.5"></div>
                <h5 class="d-flex justify-content-between align-items-center mb-3">
                        <span style={{color: 'blue'}}>Products</span>
                        <span class="badge bg-primary rounded-pill">2</span>
                </h5>
                <hr class="my-3" />
                {/* TO DO :: 주문할 Product 리스트로 수정 */}
                <div class="col-12">
                    <ul class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Product 1</h6>
                                <small class="text-body-secondary">Category 1</small>
                            </div>
                            <span class="text-body-secondary">$12</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Product 2</h6>
                                <small class="text-body-secondary">Category 2</small>
                            </div>
                            <span class="text-body-secondary">$8</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between bg-body-tertiary">
                            <div class="text-success">
                                <h6 class="my-0">Promotion code</h6>
                                <small>EXAMPLECODE</small>
                            </div>
                            <span class="text-success">−$5</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total (USD)</span>
                            <strong>$15</strong>
                        </li>
                    </ul>
                </div>


                <div class="form-check text-start my-0.5"></div>
                <h5 style={{ color: 'blue' }}>Shipping Info</h5>
                <hr class="my-3" />


                <div class="row g-3">
                    <div class="col-12">
                        <label class="form-label">Receiver's Name</label>
                        <input type="text" class="form-control" placeholder="" value="" />
                    </div>

                    <div class="col-12">
                        <label class="form-label">Receiver's Phone Number</label>
                        <input type="tel" class="form-control" placeholder="" />
                    </div>

                    <div class="col-sm-4">
                        <label class="form-label">City</label>
                        <input type="text" class="form-control" placeholder="" value="" />
                    </div>

                    <div class="col-sm-5">
                        <label class="form-label">Street</label>
                        <input type="text" class="form-control" placeholder="" value="" />
                    </div>

                    <div class="col-sm-3">
                        <label class="form-label">Zip Code</label>
                        <input type="text" class="form-control" placeholder="" value="" />
                    </div>

                    <div class="col-12">
                        <label class="form-label">Detailed Address</label>
                        <input type="text" class="form-control" placeholder="" />
                    </div>
                </div>

                <div class="form-check text-start my-0.5"></div>
                <h5 style={{ color: 'blue' }}>Payment</h5>
                <hr class="my-3" />

                {/* TO DO :: Payment 타입에 맞게 수정 */}
                <div class="my-3">
                    <div class="form-check">
                        <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked=""/>
                            <label class="form-check-label" for="credit">Credit card</label>
                    </div>
                    <div class="form-check">
                        <input id="debit" name="paymentMethod" type="radio" class="form-check-input"/>
                            <label class="form-check-label" for="debit">Debit card</label>
                    </div>
                    <div class="form-check">
                        <input id="paypal" name="paymentMethod" type="radio" class="form-check-input"/>
                            <label class="form-check-label" for="paypal">PayPal</label>
                    </div>
                </div>

                <div class="form-check text-start my-0.5"></div>
                <button class="w-100 btn btn-dark btn-primary btn-lg" type="submit">Order</button>
                <p class="mt-5 mb-3 text-body-secondary">© 2024</p>
            </form>
        </div>
    );
}

export default CreateOrder;