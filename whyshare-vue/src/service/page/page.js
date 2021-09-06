import axios from '@/utils/axios'
import {Result} from "@/dto/Result";

export async function page(params) {
    let result = await axios.post('/pageService/page', params);
    let res = new Result(result.data);
    return res;
}

export async function getPage(params) {
    let result = await axios.get('/pageService/page', {params:params});
    let res = new Result(result.data);
    return res;
}

export async function getAllPage(params) {
    let result = await axios.get('/pageService/page/all', {params:params});
    let res = new Result(result.data);
    return res;
}
//点赞
export async function pageAgreePost(params) {
    let result = await axios.post('/pageService/page/pageAgree', params);
    let res = new Result(result.data);
    return res;
}