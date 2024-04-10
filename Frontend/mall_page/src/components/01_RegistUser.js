import React, {useState} from 'react';

const RegistUser = () => {

    const [id,setId]=useState("");
    const [password,setPassword]=useState("");
    const [confirmPassword,setConfirmPassword]=useState("");
    const [phoneNumber,setPhoneNumber]=useState();
    const [city,setCity]=useState("");
    const [street,setStreet]=useState("");
    const [zipCode,setZipCode]=useState();
    const [detailedAddress,setDetailedAddress]=useState("");

    const handleOnChangeId = (e) => {
        setId(e.target.value);
    };
    const handleOnChangePassword = (e) => {
        setPassword(e.target.value);
    };
    const handleOnChangeConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);
    };
    const handleOnChangePhoneNumber = (e) => {
        setPhoneNumber(e.target.value);
    };
    const handleOnChangeCity = (e) => {
        setCity(e.target.value);
    };
    const handleOnChangeStreet = (e) => {
        setStreet(e.target.value);
    };
    const handleOnChangeZipCode = (e) => {
        setZipCode(e.target.value);
    };
    const handleOnChangeDetailedAddress = (e) => {
        setDetailedAddress(e.target.value);
    };

    const signUp = () => {

        if(id===""||password===""||confirmPassword===""||phoneNumber===null||city===""||street===""||zipCode===null||detailedAddress===""){
            alert("Please fill in the fields");
            return;
        }

        alert("SignUp");

        //event.preventDefault();
    }

    return (
        <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">Sign-up Form</h4>
            <form>
                <div class="row g-3">
                    <div class="col-12">
                        <label class="form-label">Id</label>
                        <input type="text" class="form-control" placeholder="" value={id} onChange={handleOnChangeId}/>
                    </div>

                    {/* TO DO :: Validation */}
                    <div class="col-12">
                        <label class="form-label">Password</label>
                        <input type="password" class="form-control" placeholder="" value={password} onChange={handleOnChangePassword}/>
                    </div>

                    <div class="col-12">
                        <label class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" placeholder="" value={confirmPassword} onChange={handleOnChangeConfirmPassword}/>
                    </div>

                    <div class="col-12">
                        <label class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" placeholder="" value={phoneNumber} onChange={handleOnChangePhoneNumber}/>
                    </div>

                    <div class="col-sm-4">
                        <label class="form-label">City</label>
                        <input type="text" class="form-control" placeholder="" value={city} onChange={handleOnChangeCity}/>
                    </div>

                    <div class="col-sm-5">
                        <label class="form-label">Street</label>
                        <input type="text" class="form-control" placeholder="" value={street} onChange={handleOnChangeStreet}/>
                    </div>

                    <div class="col-sm-3">
                        <label class="form-label">Zip Code</label>
                        <input type="text" class="form-control" placeholder="" value={zipCode} onChange={handleOnChangeZipCode}/>
                    </div>

                    <div class="col-12">
                        <label class="form-label">Detailed Address</label>
                        <input type="text" class="form-control" placeholder="" value={detailedAddress} onChange={handleOnChangeDetailedAddress}/>
                    </div>
                </div>

                <div class="form-check text-start my-0.5"></div>
                <button class="w-100 btn btn-dark btn-primary btn-lg" onClick={signUp}>Sign-up</button>
                <p class="mt-5 mb-3 text-body-secondary">© 2024</p>
            </form>
        </div>

    );
}

export default RegistUser;