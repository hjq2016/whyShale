<template>
  <el-row v-for="page in pages">
    <el-col :span="24">
      <div class="title"><span>{{ page.title }}</span></div>
      <div class="content"><span>{{ page.content }}</span></div>
      <div class="action">
        <el-button type="primary" icon="el-icon-search" @click="">赞同</el-button>
        <el-button type="primary" icon="el-icon-search"></el-button>
        <el-link href="https://element.eleme.io" target="_blank">添加评论</el-link>
        <el-link href="https://element.eleme.io" target="_blank">收藏</el-link>
      </div>
    </el-col>
  </el-row>
  <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      :current-page="currentPage"
      @current-change="currentChange">
  </el-pagination>
</template>

<script>
import pageService from "@/service/page";
import constant from "@/constant";
import {pageAgreePost} from "@/service/page/page";

export default {
  name: "pageList",
  data() {
    return {
      pages: [],
      currentPage: 1,
      pageNo: 1,
      pageSize: constant.pageSize,
      total: 0

    }
  },
  methods: {
    init() {
      this.query(this.pageNo, this.pageSize)
    },
    query(pageNo, pageSize) {
      pageService.getAllPage({
        pageNo,
        pageSize
      }).then(res => {
        let data = res.data;
        this.pages = data.records;
        this.total = data.total;
        this.currentPage = data.current;
      })
    },
    currentChange(current) {
      this.query(current, this.pageSize)
    },
    pageAgree() {
      pageService.pageAgreePost({
        
      })
    }
  },
  created() {
    this.init();
  }
}
</script>

<style scoped>

</style>