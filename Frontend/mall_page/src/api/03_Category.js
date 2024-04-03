import axios from "axios";

const baseUrl=REACT_APP_CATEGORY_API_URL;

const createCategoryApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/category/create",
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

const getAllCategoriesApi = (request) => {
    axios({
        method: 'get',
        url: baseUrl + "/category/all",
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

const modifyCategoryApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/category/modify",
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

const deleteCategoryApi = (request) => {
    axios({
        method: 'post',
        url: baseUrl + "/category/delete",
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

export { createCategoryApi, getAllCategoriesApi, modifyCategoryApi, deleteCategoryApi };