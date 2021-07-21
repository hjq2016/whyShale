<template>
  <navBar></navBar>
  <div style="display: flex">
    <div style="width: 15%">
      <van-cell-group>
        <van-cell title="创作" @click="showCollapse1"/>
        <div class="collapse--content" id="collapse1" v-show="collapse1Show">
          <router-link tag="i" to="/write">发布文章</router-link>
        </div>
        <van-cell title="管理" @click="showCollapse2"/>
        <div class="collapse--content" id="collapse2" v-show="collapse2Show">
          <span @click="dynamic('contentManager')">内容管理</span>
          <span @click="dynamic('discussManager')">评论管理</span>
        </div>
        <van-cell title="个人中心"/>
      </van-cell-group>
    </div>
    <div style="width: 85%;">
      <component v-bind:is="currentComponent" class="tab"></component>
    </div>
  </div>
</template>

<script>
import navBar from '@/views/Navbar'
// import Login from '@/views/Login'
import contentManager from "@/views/creator/ContentManager";
import discussManager from "@/views/creator/DiscussManager";

export default {
  components: {
    navBar,
    contentManager,
    discussManager,
  },
  data() {
    return {
      activeKey: 0,
      collapse1Show:false,
      collapse2Show:false,
      currentComponent:'contentManager'
    };
  },
  methods: {
    showCollapse1() {
      this.collapse1Show = this.collapse1Show ? false : true;
    },
    showCollapse2() {
      this.collapse2Show = this.collapse2Show ? false : true;
    },
    dynamic(val) {
      this.currentComponent = val;
    }
  },
  computed: {
  }
}
</script>

<style lang="less">
@import '../common/style/mixin';
.collapse--content {
  a, span {
    box-sizing: border-box;
    margin: 0;
    min-width: 0;
    color: #808080;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-align-items: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    line-height: 44px;
    font-size: 15px;
    text-align: left;
    padding-left: 42px;
    border-radius: 4px;
    position: relative;
  }
}
</style>