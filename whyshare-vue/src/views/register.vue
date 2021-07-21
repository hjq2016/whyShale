<!--
模仿github登录页
-->

<template>
  <div class="register">
    <div class="register-body">
      <van-row style="text-align: center;margin-top: 20%">
        <van-col class="single-line-span" span="24">注册</van-col>
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
            <van-button round block type="info" native-type="submit">注册</van-button>
          </div>
        </van-form>
      </div>
      <van-row style="text-align: center;">
        <van-col class="single-line-span" span="24">已注册?
          <router-link to="/login">请登录</router-link>
        </van-col>
      </van-row>
    </div>
  </div>
</template>

<script>

import {Toast} from "vant";
import {Result} from "@/dto/Result";
import {AxiosResponse} from "@/dto/AxiosResponse";
import Constant from "@/constant";
import router from '@/router'
import {register} from "@/service/user/user";

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
      let response = await register({
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
      await router.push({path: '/login'})
    }
  },
};

</script>

<style lang="less">
@import '../common/style/mixin';

.register {
  .register-body {
    .cl;
    .wh(40%, 20);
  }
}

</style>
