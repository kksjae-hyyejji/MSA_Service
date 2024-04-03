import axios from "axios";

const baseUrl = process.env.REACT_APP_USER_API_URL;

const registUserApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/user/regist",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);
    }).catch((error) => {
        console.log(error);
    })

    return null;
}

const modifyAddressUserApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/user/address",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);
    }).catch((error) => {
        console.log(error);
    })

    return null;
}

const loginUserApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/user/login",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);
    }).catch((error) => {
        console.log(error);
    })

    return null;
}

export { registUserApi, modifyAddressUserApi, loginUserApi };