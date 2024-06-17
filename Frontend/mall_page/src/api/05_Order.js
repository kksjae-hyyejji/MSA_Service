import axios from "axios";

const baseUrl=REACT_APP_ORDER_API_URL;

const createOrderApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/create",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);
        return response;
    }).catch((error) => {
        console.log(error);
    })

    return null;
}

const cancelOrderApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/cancel",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);
        return response;
    }).catch((error) => {
        console.log(error);
    })

    return null;
}

const getOrdersApi = (request) => {
    axios({
        method: 'get',
        url: baseUrl + "/orders",
        data: request,
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((response) => {
        console.log(response);
        return response;
    }).catch((error) => {
        console.log(error);
    })

    return null;
}

export { createOrderApi, cancelOrderApi, getOrdersApi };