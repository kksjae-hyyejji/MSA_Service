import axios from "axios";

const baseUrl = process.env.REACT_APP_USER_API_URL;

const registUserApi = (request) => {
    return axios({
        method: 'post',
        url: baseUrl + "/regist",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);

        if (response.status === 200) return response;
    }).catch((error) => {
        console.log(error);
        return null;
    })
}

const modifyAddressUserApi = (request) => {
    return axios({
        method: 'post',
        url: baseUrl + "/address",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);
        return response.data;
    }).catch((error) => {
        console.log(error);
        return null;
    })
}

const loginUserApi = (request) => {
    return axios({
        method: 'post',
        url: baseUrl + "/login",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);

        if (response.status === 200) return response;
    }).catch((error) => {
        console.log(error);
        return null;
    })
}

export { registUserApi, modifyAddressUserApi, loginUserApi };