import React, {useState} from 'react';

const ModifyUser = () => {

    const [city,setCity]=useState("");
    const [street,setStreet]=useState("");
    const [zipCode,setZipCode]=useState();
    const [detailedAddress,setDetailedAddress]=useState("");

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

    const modifyAddress = () => {

        if(city===""||street===""||zipCode===null||detailedAddress===""){
            alert("Please fill in the fields");
            return;
        }

        alert("Modify");

        //event.preventDefault();
    }
    
    return (
        <div class="col-md-7 col-lg-8">
            <form>
                <div class="row g-3">
                    <div class="col-12">
                        <label class="form-label">Id</label>
                        {/* TO DO :: login Id로 고정 */}
                        <input type="text" class="form-control" placeholder="loginId" value="loginId"/>
                    </div>

                    <div class="col-sm-4">
                        <label class="form-label">City</label>
                        <input type="text" class="form-control" placeholder="" value={city} onChange={handleOnChangeCity} />
                    </div>

                    <div class="col-sm-5">
                        <label class="form-label">Street</label>
                        <input type="text" class="form-control" placeholder="" value={street} onChange={handleOnChangeStreet} />
                    </div>

                    <div class="col-sm-3">
                        <label class="form-label">Zip Code</label>
                        <input type="text" class="form-control" placeholder="" value={zipCode} onChange={handleOnChangeZipCode} />
                    </div>

                    <div class="col-12">
                        <label class="form-label">Detailed Address</label>
                        <input type="text" class="form-control" placeholder="" value={detailedAddress} onChange={handleOnChangeDetailedAddress}/>
                    </div>
                </div>
                
                <div class="form-check text-start my-0.5"></div>
                <button class="w-100 btn btn-dark btn-primary btn-lg" onClick={modifyAddress} >Modify</button>
                <p class="mt-5 mb-3 text-body-secondary">© 2024</p>
            </form>
        </div>
    );
}

export default ModifyUser;