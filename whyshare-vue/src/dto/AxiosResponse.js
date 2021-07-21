export function AxiosResponse(res){
    if (!res) {
        return
    }
    this.data = res.data;
    this.status = res.status;
    this.statusText = res.statusText;
    this.headers = res.headers;
    this.config = res.config;
    this.request = res.request;
}
