import axios from "axios";

const baseUrl = REACT_APP_CART_API_URL;

const addCartProductApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/add",
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

const deleteCartProductsApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/delete",
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

const getAllCartProductsApi = (request) => {
    axios({
        method: 'get',
        url: baseUrl + "/all",
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

export { addCartProductApi, deleteCartProductsApi, getAllCartProductsApi };