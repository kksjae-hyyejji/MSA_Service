import React, {useState} from 'react';

const LoginUser = () => {

    const [id,setId]=useState("");
    const [password,setPassword]=useState("");

    const handleOnChangeId = (e) => {
        setId(e.target.value);
    };
    const handleOnChangePassword = (e) => {
        setPassword(e.target.value);
    };

    const signIn = () => {

        if(id===""||password===""){
            alert("Please fill in the fields");
            return;
        }

        alert("SignIn");

        //event.preventDefault();
    }
    return (
        <div class="col-md-7 col-lg-8">
            <form>
                <h1 class="h3 mb-3 fw-normal">Please Sign-in</h1>

                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="Id" value={id} onChange={handleOnChangeId}/>
                    <label>Id</label>
                </div>
                <div class="form-check text-start my-0.5"></div>
                <div class="form-floating">
                    <input type="password" class="form-control" placeholder="Password" value={password} onChange={handleOnChangePassword}/>
                    <label>Password</label>
                </div>
                <div class="form-check text-start my-0.5"></div>
                <button class="btn btn-dark btn-primary w-100 py-2" onClick={signIn}>Sign in</button>
                <p class="mt-5 mb-3 text-body-secondary">© 2024</p>
            </form>
        </div>
    );
}

export default LoginUser;