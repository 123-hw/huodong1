

<template>
  <div>
    <el-button>Default</el-button>
    <el-button type="primary">当前活动</el-button>
    <el-button type="success">活动提交</el-button>
    <el-button type="info">审核状态</el-button>

    <el-button type="warning">Warning</el-button>
    <el-button type="danger">Danger</el-button>


<div style="padding: 50px">
  <el-icon size="25" color="blue"><Bell /></el-icon>
  <el-button type="primary" icon="search">查询</el-button>

  <el-input placeholder="placeholder":suffix-icon="Calendar" prefix-icon="Search"></el-input>

</div>
  </div>
</template>

<script setup>
import {Calendar} from "@element-plus/icons-vue";
</script>