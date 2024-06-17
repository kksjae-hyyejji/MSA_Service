import axios from "axios";

const baseUrl = REACT_APP_PRODUCT_API_URL;

const createProductApi = (request) => {
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

const getProductsByCategoryApi = (request) => {
    axios({
        method: 'get',
        url: baseUrl + "/" + request.categoryName + "/" + request.pageNum,
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

const getAllProductsApi = (request) => {
    axios({
        method: 'get',
        url: baseUrl + "/all/" + request.pageNum,
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

export { createProductApi, getProductsByCategoryApi, getAllProductsApi };