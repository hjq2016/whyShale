export function Result(res){
    if (!res) {
        return
    }
    this.data = res.data;
    this.resp_code = res.resp_code;
    this.resp_msg = res.resp_msg;
}
