<!--
模仿github登录页
-->

<template>
  <div class="login">
    <div class="login-body">
      <van-row style="text-align: center;margin-top: 20%">
        <van-col class="single-line-span" span="24">登录</van-col>
      </van-row>
      <div>
        <van-form style="border: 1px solid;" @submit="onSubmit">
          <van-field
              v-model="username"
              name="用户名"
              label="用户名"
              placeholder="用户名"
              :rules="[{ required: true, message: '请填写用户名' }]"
          />
          <van-field
              v-model="password"
              type="password"
              name="密码"
              label="密码"
              placeholder="密码"
              :rules="[{ required: true, message: '请填写密码' }]"
          />
          <div style="margin: 16px;">
            <van-button round block type="info" native-type="submit">登录</van-button>
          </div>
        </van-form>
      </div>
      <van-row style="text-align: center;">
        <van-col class="single-line-span" span="24">新用户?
          <router-link to="/register">请注册</router-link></van-col>
      </van-row>
    </div>
  </div>
</template>

<script>
import {login, refreshToken} from '@/service/user/user'
import {Toast} from "vant";
import {Result} from "@/dto/Result";
import {AxiosResponse} from "@/dto/AxiosResponse";
import Constant from "@/constant";
import {setLocal} from "@/common/js/utils"
import router from '@/router'

export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    async onSubmit(values) {
      console.log('submit', values)
      let response = await login({
        "username": this.username,
        "password": this.password
      })
      response = new AxiosResponse(response);
      let res = new Result(response.data);
      if (Number(res.resp_code) != 0) {
        Toast.fail(res.resp_msg);
        return;
      }
      Toast.success(res.resp_msg)
      console.log(Constant.ACCESS_TOKEN_TF, response.headers[Constant.ACCESS_TOKEN])
      setLocal(Constant.ACCESS_TOKEN_TF, response.headers[Constant.ACCESS_TOKEN])
      refreshToken();
      await router.push({path: '/'})
    }
  },
};

</script>

<style lang="less">
@import '../common/style/mixin';

.login {
  .login-body {
    .cl;
    .wh(40%, 20);
  }
}

</style>
