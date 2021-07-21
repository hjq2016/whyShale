 export function Userinfo(param){
    if (!param) {
        return
    }
    this.isLogin = param.isLogin;
    this.userName = param.userName;
}
