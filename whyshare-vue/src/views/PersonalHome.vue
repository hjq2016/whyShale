<template>
  <div>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="评论" name="first">评论</el-tab-pane>
      <el-tab-pane label="文章" name="second"><content-manager></content-manager></el-tab-pane>
      <el-tab-pane label="收藏" name="third">收藏</el-tab-pane>
      <el-tab-pane label="关注" name="fourth">关注</el-tab-pane>
    </el-tabs>
    <router-view></router-view>
  </div>
</template>

<script>
import navBar from '@/views/Navbar'
import contentManager from "@/views/creator/ContentManager";

export default {
  components: {
    navBar,
    contentManager
  },
}
</script>

<style>
</style>