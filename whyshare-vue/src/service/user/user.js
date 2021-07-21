import axios from '@/utils/axios'
import constant from "@/constant";

export function login(params) {
    return axios.post('/userService/login', params);
}

export function refreshToken() {
    axios.defaults.headers[constant.ACCESS_TOKEN_TF] = localStorage.getItem(constant.ACCESS_TOKEN_TF) || ''
}

export function register(params) {
    return axios.post('/userService/users/register', params);
}