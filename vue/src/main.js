
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/css/global.css'
import ElementPlus from 'element-plus'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

import 'element-plus/dist/index.css'
//  // 路径根据实际调整



const app = createApp(App)
app.use(ElementPlus)
app.use(router)

app.mount('#app')

for(const [key,component] of Object.entries(ElementPlusIconsVue)){
    app.component(key,component)
}