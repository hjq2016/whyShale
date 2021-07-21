<template>
  <navBar></navBar>
  <div>
    <van-tabs v-model="active">
      <van-tab title="动态">动态</van-tab>
      <van-tab title="回答">回答</van-tab>
      <van-tab title="视频">视频</van-tab>
      <van-tab title="提问">提问</van-tab>
      <van-tab title="文章">文章</van-tab>
      <van-tab title="专栏">专栏</van-tab>
      <van-tab title="想法">想法</van-tab>
      <van-tab title="收藏">收藏</van-tab>
      <van-tab title="关注">关注</van-tab>
    </van-tabs>
  </div>
</template>

<script>
import navBar from '@/views/Navbar'

export default {
  components: {
    navBar
  },
}
</script>

<style>
</style>