import axios from "axios";

const baseUrl=REACT_APP_ORDER_API_URL;

const createOrderApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/order/create",
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

const cancelOrderApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/order/cancel",
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

const getOrdersApi = (request) => {
    axios({
        method: 'get',
        url: baseUrl + "/order/orders",
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

export { createOrderApi, cancelOrderApi, getOrdersApi };