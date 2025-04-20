<template>
  <div>
    <!--头部区域开始-->
    <div style="height: 60px; border-bottom: 1px solid #eee;display: flex;align-items: center">
      <div style="display:flex;align-items: center;padding-left: 20px">
        <!--放logo-->
        <span style="font-size: 20px;font-weight: bold;color:#42cc2d;margin-left: 5px">学生活动管理系统</span>
      </div>
      <div style="flex:1">
      </div>
      <div></div>
    </div>
    <!--头部区域结束-->

    <!--下方区域开始-->
    <div style="display: flex">
      <!--菜单区域开始-->
      <div style="width:240px">
        <el-menu :default-openeds="['1']" default-active="/manager/home" style="min-height: calc(100vh - 60px">
          <el-menu-item index="/manager/home">
            <el-icon><House /></el-icon>
            <span>首页</span>
          </el-menu-item>
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>数据管理</span>
            </template>
            <el-menu-item index="1-1">二级菜单</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </div>
      <!--菜单区域结束-->

      <!--数据渲染区域开始-->
      <div></div>
      <!--数据渲染区域结束-->
    </div>
    <!--下方区域结束-->
  </div>
</template>

<script setup>

</script>