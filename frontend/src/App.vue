<template>
    <div class="app">
        <deco_background></deco_background>
        <router-view></router-view>
   </div>
</template>

<script lang="ts"> 
    import {ref} from 'vue'
    import deco_background from '@/components/deco_background.vue'
    export default{//组件名
        name:'App',//注册组件,注册完之后,可以在html中当做标签使用
        components:{
        deco_background,
        },
        setup(){
            const textarea = ref('')
            return {textarea}
        }
    }
   
</script>

<style scoped>
   .app{
     border-radius: 50;
   }
   a{
    text-decoration: none;
    color: black;
    cursor: pointer;
    }
</style>