<template>
  <div>
    <header class="home-header wrap" :class="{'active' : headerScroll}">
      <router-link tag="i" to="/home">
        <i class="iconfont icon-zhishi"></i>
        <span class="app-name">{{ constant.WHY_SHARE }}</span>
      </router-link>
      <div class="home-items">
        <el-row>
          <el-col :span="12">首页</el-col>
          <el-col :span="12">看看</el-col>
        </el-row>
      </div>
      <el-input
          style="width: 30%"
          placeholder="请输入搜索关键词"
          suffix-icon="el-icon-search"
          v-model="searchValue">
      </el-input>
      <router-link tag="i" to="/login">
        <el-button type="success" round>登录or注册</el-button>
      </router-link>
      <el-dropdown>
        <el-button type="primary">
          用户名字<i class="el-icon-arrow-down el-icon--right"></i>
        </el-button>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>
              <router-link tag="i" to="/personalHome">
                <el-button round>我的首页</el-button>
              </router-link>
            </el-dropdown-item>
            <el-dropdown-item>
              <router-link tag="i" to="/creator">
                <el-button round>创作中心</el-button>
              </router-link>
            </el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </header>


  </div>
</template>

<script>
import {reactive, onMounted, toRefs, nextTick} from 'vue'
import {useRouter} from 'vue-router'
// import swiper from '@/components/Swiper'
// import navBar from '@/components/NavBar'
// import { getHome } from '@/service/home'
import {getLocal} from '@/common/js/utils'
import {Toast} from 'vant'
import constant from '@/constant'
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'navbar',
  components: {
    HelloWorld
  },
  data() {
    return {
      constant: constant,
      searchValue: '',
      value1: '124444',
      value2: 'ddddddd',
      option1: [
        {text: '全部商品', value: 0},
        {text: '新款商品', value: 1},
        {text: '活动商品', value: 2},
      ],
      option2: [
        {text: '默认排序', value: 'a'},
        {text: '好评排序', value: 'b'},
        {text: '销量排序', value: 'c'},
      ],
    }
  },
  setup() {
    const router = useRouter()
    const state = reactive({
      swiperList: [], // 轮播图列表
      isLogin: false, // 是否已登录
      headerScroll: false, // 滚动透明判断
      hots: [],
      newGoodses: [],
      recommends: [],
      categoryList: [
        {
          name: '新蜂超市',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E8%B6%85%E5%B8%82%402x.png',
          categoryId: 100001
        }, {
          name: '新蜂服饰',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E6%9C%8D%E9%A5%B0%402x.png',
          categoryId: 100003
        }, {
          name: '全球购',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E5%85%A8%E7%90%83%E8%B4%AD%402x.png',
          categoryId: 100002
        }, {
          name: '新蜂生鲜',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E7%94%9F%E9%B2%9C%402x.png',
          categoryId: 100004
        }, {
          name: '新蜂到家',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E5%88%B0%E5%AE%B6%402x.png',
          categoryId: 100005
        }, {
          name: '充值缴费',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E5%85%85%E5%80%BC%402x.png',
          categoryId: 100006
        }, {
          name: '9.9元拼',
          imgUrl: 'https://s.yezgea02.com/1604041127880/9.9%402x.png',
          categoryId: 100007
        }, {
          name: '领劵',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E9%A2%86%E5%88%B8%402x.png',
          categoryId: 100008
        }, {
          name: '省钱',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E7%9C%81%E9%92%B1%402x.png',
          categoryId: 100009
        }, {
          name: '全部',
          imgUrl: 'https://s.yezgea02.com/1604041127880/%E5%85%A8%E9%83%A8%402x.png',
          categoryId: 100010
        }
      ],
      loading: true
    })
    onMounted(async () => {
      const token = getLocal('token')
      if (token) {
        state.isLogin = true
      }
      Toast.loading({
        message: '加载中...',
        forbidClick: true
      });
      // const { data } = await getHome()
      // state.swiperList = data.carousels
      // state.newGoodses = data.newGoodses
      // state.hots = data.hotGoodses
      // state.recommends = data.recommendGoodses
      // state.loading = false
      // Toast.clear()
    })

    nextTick(() => {
      window.addEventListener('scroll', () => {
        let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
        scrollTop > 100 ? state.headerScroll = true : state.headerScroll = false
      })
    })

    const goToDetail = (item) => {
      router.push({path: `/product/${item.goodsId}`})
    }

    const tips = () => {
      Toast('敬请期待');
    }

    return {
      ...toRefs(state),
      goToDetail,
      tips
    }
  },
}
</script>

<style lang="less" scoped>
@import '../common/style/mixin';

.home-header {
  //position: fixed;
  left: 0;
  top: 0;
  .wh(100%, 50px);
  .fj();
  line-height: 50px;
  padding: 0 15px;
  .boxSizing();
  font-size: 15px;
  //color: #fff;
  z-index: 10000;

  .home-items {
    margin-left: 20px;
    .wh(25%, 20px);
  }

  //.nbmenu2 {
  //  color: @primary;
  //}
  //
  //&.active {
  //  background: @primary;
  //
  //  .nbmenu2 {
  //    color: #fff;
  //  }
  //
  //  .login {
  //    color: #fff;
  //  }
  //}
  //
  //.app-name {
  //  padding: 0 10px;
  //  color: @primary;
  //  font-size: 20px;
  //  font-weight: bold;
  //  border-right: 1px solid #666;
  //}
  //
  //.header-search {
  //  display: flex;
  //  .wh(74%, 20px);
  //  line-height: 20px;
  //  margin: 10px 0;
  //  padding: 5px 0;
  //  color: #232326;
  //  background: rgba(255, 255, 255, .7);
  //  border-radius: 20px;
  //
  //  .icon-search {
  //    padding: 0 10px;
  //    font-size: 17px;
  //  }
  //
  //  .search-title {
  //    font-size: 12px;
  //    color: #666;
  //    line-height: 21px;
  //  }
  //}
  //
  //.icon-iconyonghu {
  //  color: #fff;
  //  font-size: 22px;
  //}
  //
  //.login {
  //  color: @primary;
  //  line-height: 52px;
  //
  //  .van-icon-manager-o {
  //    font-size: 20px;
  //    vertical-align: -3px;
  //  }
  //}
}
</style>