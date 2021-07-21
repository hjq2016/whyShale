<template>
<div>
  <div v-for="page in pages" class="css-wooxo5" :key="page.id">
      <van-row>
        <van-col>{{page.title}}</van-col>
      </van-row>
      <van-row>
        <van-col>{{page.content}}</van-col>
      </van-row>
  </div>
  <van-pagination v-model="currentPage" :total-items="total" :items-per-page="pageSize"  mode="simple" @change="change">
    <template #prev-text>
      <van-icon name="arrow-left" />
    </template>
    <template #next-text>
      <van-icon name="arrow" />
    </template>
  </van-pagination>

</div>
</template>

<script>
import page from '@/service/page'
import constant from '@/constant'
export default {
  name: "ContentManager",
  data() {
    return {
      pages:undefined,
      currentPage:1,
      pageNo:1,
      pageSize: constant.pageSize,
      total:0
    }
  },
  methods: {
    init() {
      this.query(this.pageNo, this.pageSize)
    },
    query(pageNo, pageSize) {
      page.getPage({
        pageNo,
        pageSize
      }).then(res => {
        let data = res.data;
        this.pages = data.records;
        this.total = data.total;
        this.currentPage = data.current;
      })
    },
    change(current) {
      this.query(current, this.pageSize)
    }

  },
  created() {
    this.init();
  },

}
</script>

<style scoped>

.css-wooxo5 {
  box-sizing: border-box;
  margin: 0px 20px;
  min-width: 0px;
  padding-top: 20px;
  padding-bottom: 20px;
}

.css-t8gylk {
  box-sizing: border-box;
  margin: 0px 20px 0px 0px;
  min-width: 0px;
  flex: 0 0 700px;
  display: flex;
}

.css-1204lgo {
  box-sizing: border-box;
  margin: 0px;
  min-width: 0px;
  font-size: 15px;
  color: rgb(68, 68, 68);
  line-height: 25px;
  display: -webkit-box;
  text-overflow: ellipsis;
  overflow: hidden;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}

</style>