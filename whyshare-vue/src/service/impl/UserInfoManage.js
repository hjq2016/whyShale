import {Userinfo} from "@/dto/Userinfo";

export const UserInfoManager = function() {
}
UserInfoManager.prototype.data=new Userinfo();
UserInfoManager.prototype.setData = function (data) {
    this.data = data;
}