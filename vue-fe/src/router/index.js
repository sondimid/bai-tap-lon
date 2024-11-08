import DashBoard from '@/components/DashBoard.vue';
import Login from '@/components/Login.vue';
import Register from "@/components/Register.vue";
import { createRouter, createWebHistory } from 'vue-router'
import MotelDetail from '@/components/MotelDetail.vue';
import Profile from '@/components/Profile.vue';
import ChangePassword from '@/components/ChangePassword.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "DashBoard", component: DashBoard },
    { path: "/login", name: "Login", component: Login },
    { path: "/register", name: "Register", component: Register },
    { path: "/motel-detail/:id", name: "MotelDetail", component: MotelDetail },
    { path: "/profile", name: "Profile", component: Profile },
    { path: "/change-password", name: "ChangePassword", component: ChangePassword },
  ],
});

export default router
