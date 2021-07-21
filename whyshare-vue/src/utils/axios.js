import axios from 'axios'
import {Toast} from 'vant'
import constant from '@/constant'
import router from '@/router'

axios.defaults.baseURL = process.env.NODE_ENV == 'development' ? constant.HOST : constant.HOST
// axios.defaults.withCredentials = true
axios.defaults.headers['X-Requested-With'] = 'XMLHttpRequest'
axios.defaults.headers[constant.ACCESS_TOKEN_TF] = localStorage.getItem(constant.ACCESS_TOKEN_TF) || ''
axios.defaults.headers.post['Content-Type'] = 'application/json'

axios.interceptors.response.use(res => {
    console.log('res', res)
    if (typeof res.data !== 'object') {
        Toast.fail('服务端异常！')
        return Promise.reject(res)
    }
    console.log('res.data', res.data);
    if (res.data.resp_code != 0) {
        if (res.data.resp_msg) {
            Toast.fail(res.data.resp_msg)
        }
        if (res.data.resp_msg.match("A0300")) {
            router.push({ path: '/login' })
        }
    }
    return res
})

export default axios
