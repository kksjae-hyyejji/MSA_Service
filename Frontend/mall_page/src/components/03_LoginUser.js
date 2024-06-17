import React, { useState } from 'react';
import { loginUserApi } from '../api/01_User';
import { useNavigate } from 'react-router-dom';
import { useCookies } from 'react-cookie';

const LoginUser = () => {

    const navigate = useNavigate();
    const [cookies, setCookie, removeCookie] = useCookies(['token']);

    const [id, setId] = useState("");
    const [password, setPassword] = useState("");

    const handleOnChangeId = (e) => {
        setId(e.target.value);
    };
    const handleOnChangePassword = (e) => {
        setPassword(e.target.value);
    };

    const clearAllStates = () => {
        setId("");
        setPassword("");
    }

    const signIn = async (e) => {

        if (id === "" || password === "") {
            alert("Please fill in the fields");
            return;
        }

        e.preventDefault();

        const request = {
            loginId: id,
            password: password
        };

        const response = await loginUserApi(request);
        console.log(response);
        if (response === null) {
            alert("Login failed");
            clearAllStates();
            return;
        }

        setCookie('token', response.data.data.Authrorization, { path: '/' });
        navigate('/', { replace: true });
    }
    return (
        <div class="col-md-7 col-lg-8">
            <form>
                <h1 class="h3 mb-3 fw-normal">Please Sign-in</h1>

                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="Id" value={id} onChange={handleOnChangeId} />
                    <label>Id</label>
                </div>
                <div class="form-check text-start my-0.5"></div>
                <div class="form-floating">
                    <input type="password" class="form-control" placeholder="Password" value={password} onChange={handleOnChangePassword} />
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