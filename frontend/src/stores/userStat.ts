import { defineStore } from 'pinia'
import 'pinia-plugin-persistedstate'

// Ensure the plugin is added to Pinia in your main.ts or equivalent file
import { computed, ref } from 'vue'


export const useUserStat = defineStore(
  'userStat',
  () => {
    const userStat = ref<boolean>()

    const get = computed(() => userStat.value)

    function set(data: boolean) {
      userStat.value = data
    }
    function clear() {
      userStat.value = undefined
    }

    return { userStat, get, set, clear }
  },{
    persist : true
  }
)