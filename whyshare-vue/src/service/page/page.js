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
