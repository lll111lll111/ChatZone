// utils/auth.ts
import { useUserStat } from '@/stores/userStat';
import router from '@/router';

export function checkLogin() {
  const userStore = useUserStat();
  
  // 如果未登录，跳转到登录页
  if (!userStore.get) {
    alert("请先登录");
    router.push('/login');
    return false;
  }
  
  return true;
}