<template>
  <div>
    <!--头部区域开始-->
    <div style="height: 60px;display: flex;">
      <div style="width:240px; display:flex;align-items: center;padding-left: 20px;background-color:#3a456b">
        <!--放logo-->
        <span style="font-size: 20px;font-weight: bold;color:#42cc2d;margin-left: 5px">学生活动管理系统</span>
      </div>
      <div style="flex:1;display:flex;align-items: center;padding-left: 20px; border-bottom: 1px solid #ddd">首页/数据分析</div>
      <div style="width: fit-content ;padding-right: 20px; display: flex;align-items:center;border-bottom: 1px solid #ddd">
        <el-dropdown>
           <div style="display: flex;align-items:center;">
              <img style="width: 40px;height: 40px; border-radius: 50%" src="http://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png" alt="">
              <span style="margin-left: 5px">管理员</span>
          </div>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>修改密码</el-dropdown-item>
              <el-dropdown-item>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>

      </div>
    </div>
    <!--头部区域结束-->

    <!--下方区域开始-->
    <div style="display: flex">
      <!--菜单区域开始-->
      <div style="width:240px;">
        <el-menu router :default-openeds="['1']" default-active="router.currentRoute.value.path" style="min-height: calc(100vh - 60px">
          <el-menu-item index="/manager/home">
            <el-icon><House /></el-icon>
            <span>首页</span>
          </el-menu-item>
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>数据管理</span>
            </template>
            <el-menu-item index="/manager/about">关于</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </div>
      <!--菜单区域结束-->

      <!--数据渲染区域开始-->
      <div style="flex:1;width:0; padding:  10px;background-color: #e0e3ff">
        <RouterView/>
      </div>
      <!--数据渲染区域结束-->
    </div>
    <!--下方区域结束-->
  </div>
</template>

<script setup>
import  router from "@/router/index.js";
</script>
<style>
.el-dropdown{
  cursor:pointer;
}
.el-tooltip__trigger{
  outline:none;
}
</style>