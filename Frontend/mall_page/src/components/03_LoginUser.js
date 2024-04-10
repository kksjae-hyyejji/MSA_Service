const LoginUser = () => {

    //event.preventDefault();


    return (
        <div>
            <form>
                <h1 class="h3 mb-3 fw-normal">Please Sign-in</h1>

                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="Id" />
                    <label>Id</label>
                </div>
                <div class="form-check text-start my-0.5"></div>
                <div class="form-floating">
                    <input type="password" class="form-control" placeholder="Password" />
                    <label>Password</label>
                </div>
                <div class="form-check text-start my-0.5"></div>
                <button class="btn btn-dark btn-primary w-100 py-2" type="submit">Sign in</button>
                <p class="mt-5 mb-3 text-body-secondary">© 2024</p>
            </form>
        </div>
    );
}

export default LoginUser;