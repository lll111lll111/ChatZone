<!-- BackgroundDecoration.vue -->
<template>
    <div class="decorative-background">
      <div class="decor-circle accent-circle"></div>
      <div class="decor-circle primary-circle"></div>
      <div class="decor-circle secondary-circle"></div>
    </div>
  </template>
  
  <script setup>
  // 可以在这里添加响应式逻辑
  </script>
  
  <style scoped>
  .decorative-background {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    pointer-events: none;
    z-index: -1; /* 设置为-1确保在内容后面 */
  }
  
  .decor-circle {
    position: absolute;
    border-radius: 50%;
    filter: blur(30px);
    opacity: 0.3;
  }
  
  .accent-circle {
    top: -50px;
    left: -50px;
    width: 150px;
    height: 150px;
    background-color: #ADE8F4;
    animation: float 8s ease-in-out infinite;
  }
  
  .primary-circle {
    bottom: 10%;
    right: 20%;
    width: 100px;
    height: 100px;
    background-color: #00B4D8;
    animation: float 10s ease-in-out infinite 2s;
  }
  
  .secondary-circle {
    top: 30%;
    right: -25px;
    width: 120px;
    height: 120px;
    background-color: #0096C7;
    animation: float 9s ease-in-out infinite 4s;
  }
  
  @keyframes float {
    0%, 100% {
      transform: translateY(0);
    }
    50% {
      transform: translateY(-10px);
    }
  }
  </style>