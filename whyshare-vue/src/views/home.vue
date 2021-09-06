<template>
  <nav-bar></nav-bar>
  <router-view></router-view>
</template>

<script>
import navBar from '@/views/Navbar'
import pageList from "@/views/pageList";
export default {
  name: "home",
  components:{
    navBar,
    pageList
  }
}
</script>

<style scoped>

</style>