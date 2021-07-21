<template>
  <navBar></navBar>
  <div style="margin: auto 20% ">
    <div class="title" style="text-align: center">
      <input placeholder="请输入标题" v-model="title" />
      <van-button type="default" color="#7232dd" round="true"
                  size="small" text="发布" @click="publish"></van-button>
    </div>
    <div class="page">
      <textarea cols="100" rows="40" style="border-bottom-color: #42b983; background-color: #666666" v-model="content">

      </textarea>
    </div>
  </div>
</template>

<script>
import navBar from '@/views/Navbar'
import {page} from "@/service/page/page";
import {Toast} from "vant";
import constant from "@/constant";

export default {
  components: {
    navBar
  },
  data() {
    return {
      title: '',
      content: '222',

    }
  },
  methods: {
    async publish() {
      let params = new Object();
      params.title = this.title;
      params.content = this.content;
      let response = await page(params);
      if (response.resp_code == constant.SUCCESS_CODE) {
        Toast.success(JSON.stringify(response.resp_msg))
      }

    }
  }
}
</script>

<style lang="less">
@import '../common/style/mixin';
</style>