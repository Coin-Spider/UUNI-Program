
import { createRouter, createWebHistory } from 'vue-router'

const Login=()=>import("@/view/User/Login.vue");

const routes = [
    {
      path:'/',
      component:Login,
      name:'登录'
    },
]
const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router