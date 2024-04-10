const RegistUser = () => {

    //event.preventDefault();

    return (
        <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">Sign-up Form</h4>
            <form>
                <div class="row g-3">
                    <div class="col-12">
                        <label class="form-label">Id</label>
                        <input type="text" class="form-control" placeholder="" value="" />
                    </div>

                    <div class="col-12">
                        <label class="form-label">Password</label>
                        <input type="text" class="form-control" placeholder="" value="" />
                    </div>

                    <div class="col-12">
                        <label class="form-label">Phone Number</label>
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
                <button class="w-100 btn btn-dark btn-primary btn-lg" type="submit">Sign-up</button>
                <p class="mt-5 mb-3 text-body-secondary">© 2024</p>
            </form>
        </div>

    );
}

export default RegistUser;