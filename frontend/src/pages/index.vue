<template>
    <!-- app-container是整个页面的最外层容器，通过css样式设置它为最小高度100vh，即占满整个视口高度 -->
    <div class="app-container"> 
      <!-- decorative-background用于设置背面的装饰背景，这些元素用于创建一些带有动画效果的圆形装饰图案 -->
      <div class="decorative-background">
        <div class="decor-circle accent-circle"></div>
        <div class="decor-circle primary-circle"></div>
        <div class="decor-circle secondary-circle"></div>
      </div>
      <deco_background></deco_background>
      
      <!-- 主内容区 -->
      <div class="content-container">
        <!-- 图标，即上面那一个小圆，这里使用了Font Awesome库中的聊天图标 -->
        <div class="icon-container">
          <svg t="1748507024366"  class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10334" width="40" height="40"><path d="M490.684916 156.359281C256.165269 156.359281 64.383234 309.755867 64.383234 501.634326 64.383234 610.634973 126.868113 710.691594 230.678884 775.40424 227.606262 773.488857 225.494778 770.415816 224.753999 767.352292 223.887537 768.541972 221.953407 773.256131 218.857033 779.006383 217.065752 782.332956 214.951892 785.897204 212.584292 789.613841 209.515541 794.431134 206.194743 799.237633 202.873358 803.77396 200.894915 806.476107 199.385181 808.450099 198.588038 809.457524 172.393538 846.514453 195.912543 878.240014 237.91885 864.281028 238.904007 863.944749 240.468491 863.41216 242.667337 862.668117 246.342793 861.42442 250.469427 860.037674 254.950478 858.543831 267.750292 854.276769 280.813441 850.010352 293.359528 846.033927 295.896051 845.229988 298.389767 844.444875 300.83653 843.680116 316.56621 838.763658 329.922562 834.822101 340.069379 832.152296 345.53275 830.714787 349.931698 829.683229 353.049854 829.104939 354.354436 828.862994 355.312446 828.724123 355.799045 828.684232 354.825653 828.76403 353.666503 828.729983 351.271205 828.060274 395.73304 840.491494 442.681213 846.909372 490.684916 846.909372 515.054363 846.909372 539.17115 845.255803 562.858125 841.990612L553.743714 841.264542C587.27542 851.488506 622.974605 856.786459 659.544225 856.786459 693.181558 856.786459 726.090816 852.304522 757.271021 843.619314 754.092157 844.504782 753.608504 844.478091 752.940486 844.368364 754.491872 844.623192 756.826954 845.133168 759.766796 845.870344 765.488513 847.305086 773.068547 849.485235 781.988654 852.233024 783.660815 852.748123 785.371243 853.28047 787.11584 853.828542 794.321124 856.09211 801.796248 858.523923 809.096177 860.956383 813.473523 862.414988 816.808901 863.546001 818.665128 864.183881 860.663463 877.971145 884.367548 846.417249 859.473647 810.157106L858.061678 808.322293C856.808278 806.864525 854.629739 804.067756 852.506478 800.829267 851.198804 798.834746 850.132845 796.983268 849.402965 795.433479 848.88826 798.914448 846.566215 803.916137 841.990053 806.75813 915.30587 761.225855 959.616766 690.536117 959.616766 613.308352 959.616766 565.930919 942.964529 520.637339 912.303541 481.843704L916.899107 494.563385C912.222016 305.709617 721.984814 156.359281 490.684916 156.359281ZM874.458588 502.750536 878.87761 508.341678C903.736413 539.794134 916.986598 575.834235 916.986598 613.308352 916.986598 674.834711 880.94872 732.326397 819.523603 770.474036 802.737889 780.898687 803.163281 797.33264 810.846353 813.646472 812.511881 817.182966 814.544511 820.713465 816.871626 824.262883 820.163834 829.284301 823.400763 833.439809 825.757675 836.181018L824.345705 834.346205C826.245123 837.112873 827.218499 839.100202 827.393889 839.834262 826.869427 837.639217 827.310775 834.026062 830.096989 830.317167 832.870293 826.625461 836.179448 825.20914 838.39741 825.099927 837.62165 825.138126 835.424001 824.758139 832.221342 823.706931 830.525993 823.122175 827.066992 821.949243 822.554587 820.445634 815.038264 817.941067 807.337514 815.435854 799.875177 813.091531 798.056786 812.520277 796.271017 811.964481 794.521489 811.425549 765.181772 802.387618 755.193882 799.883117 745.847847 802.486444 718.393861 810.133719 689.327665 814.092267 659.544225 814.092267 627.172439 814.092267 595.657587 809.415292 566.15969 800.421253L561.682084 799.056011 557.04528 799.695183C535.285067 802.694774 513.110434 804.215178 490.684916 804.215178 446.549157 804.215178 403.457662 798.324515 362.734113 786.938494 351.832032 783.890348 334.145392 788.544012 288.136195 802.924618 285.63427 803.706617 283.086605 804.508715 280.497094 805.329449 267.729439 809.3761 254.472422 813.705833 241.486537 818.034925 236.942593 819.549735 232.755682 820.956737 229.021658 822.220252 226.774814 822.980535 225.182894 823.522465 224.313674 823.819927 221.208111 824.851035 218.947329 825.258295 218.14354 825.226502 220.466916 825.3184 223.929592 826.769872 226.819244 830.667817 229.71253 834.570666 230.098527 838.322463 229.508371 840.593362 229.704432 839.838924 230.732379 837.824526 232.699225 835.037893 233.109594 834.570863 234.938024 832.180175 237.251504 829.020436 241.083328 823.786956 244.915738 818.239954 248.523314 812.576814 251.420355 808.029067 254.057357 803.582735 256.378759 799.271676 270.621662 772.821292 274.586859 752.486106 253.20607 739.157937 161.261462 681.842314 107.013402 594.975258 107.013402 501.634326 107.013402 335.711853 277.868719 199.053473 490.684916 199.053473 700.625512 199.053473 870.235026 332.209541 874.282045 495.621998L874.458588 502.750536ZM874.35643 501.634326 916.986598 501.634326C916.986598 499.274725 916.957412 496.917663 916.899107 494.563385L874.282045 495.621998C874.331614 497.623493 874.35643 499.627657 874.35643 501.634326ZM557.04528 799.695183 559.951702 820.842898 566.15969 800.421253C467.508194 770.341978 402.101853 695.9473 402.101853 613.308352 402.101853 503.628141 516.430046 412.524437 659.544225 412.524437 750.184557 412.524437 832.352401 449.475927 878.87761 508.341678L912.303541 481.843704C857.398565 412.375501 762.792042 369.830244 659.544225 369.830244 494.751422 369.830244 359.471685 477.629422 359.471685 613.308352 359.471685 716.357726 438.355709 806.082232 553.743714 841.264542L558.221321 842.629784 562.858125 841.990612C564.566072 841.755176 566.271624 841.511382 567.974711 841.259249L561.740762 799.024014C560.177951 799.255379 558.612768 799.479109 557.04528 799.695183Z" fill="#2c2c2c" p-id="10335"></path></svg>
        </div>
  
        <!-- 标题 -->
        <h1 class="title">
          <span class="welcome-text">欢迎来到</span>
          <div class="typing-container">
            <span class="typing-text">{{ displayText }}</span>
          </div>
        </h1>
  
        <!-- 描述 -->
        <p class="description">
          轻松愉悦的聊天空间，与朋友分享每一刻精彩
        </p>
  
        <!-- 进入按钮 -->
        <button class="enter-button" @click="enterChatroom">
            <svg t="1748508271848" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="11364" width="20" height="20"><path d="M128.6 469.3h665L589.1 264.8c-16.7-16.7-16.7-43.7 0-60.3 16.6-16.7 43.7-16.7 60.3 0l277.3 277.3c2 2 3.8 4.2 5.3 6.5 0.7 1 1.2 2.2 1.8 3.3 0.7 1.4 1.6 2.7 2.2 4.1 0.6 1.4 0.9 2.9 1.3 4.3 0.4 1.2 0.8 2.4 1.1 3.7 1.1 5.5 1.1 11.2 0 16.7-0.3 1.3-0.7 2.4-1.1 3.7-0.4 1.4-0.8 2.9-1.3 4.3-0.6 1.4-1.4 2.7-2.2 4.1-0.6 1.1-1.1 2.2-1.8 3.3-1.6 2.4-3.4 4.5-5.3 6.5L649.4 819.5c-8.3 8.3-19.2 12.5-30.2 12.5-10.9 0-21.8-4.2-30.2-12.5-16.7-16.7-16.7-43.7 0-60.3l204.5-204.5h-665c-23.6 0-42.7-19.1-42.7-42.7 0.1-23.6 19.2-42.7 42.8-42.7z" fill="#ffffff" p-id="11365"></path></svg>进入聊天室
        </button>
      </div>
    </div>
  </template>
  
<script setup>
import { checkLoginApi } from '@/request/api'
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

// 初始化路由实例
const router = useRouter()

// 状态管理
const fullText = '聊天室'
const displayText = ref('')
const typingSpeed = ref(300) // 打字速度(ms)
const typingIndex = ref(0)
const isTyping = ref(false)
const isSlidingIn = ref(false)

// 生命周期钩子
onMounted(() => {
  // 先触发滑入动画
  setTimeout(() => {
    isSlidingIn.value = true
    // 滑入动画开始后延迟启动打字效果
    setTimeout(() => {
      startTyping()
    }, 500)
  }, 800)
})

// 打字效果逻辑
const startTyping = () => {
  isTyping.value = true
  typeCharacter()
}

const typeCharacter = () => {
  if (typingIndex.value < fullText.length) {
    displayText.value += fullText.charAt(typingIndex.value)
    typingIndex.value++
    setTimeout(() => {
      typeCharacter()
    }, typingSpeed.value)
  } else {
    isTyping.value = false
  }
}

// 进入聊天室逻辑
const enterChatroom = async () => {
  const response = await checkLoginApi()
  if(response.data.code === 200) {
    // 如果用户已登录，跳转到聊天室页面
    router.push('/wechat')
  } else {
    // 如果用户未登录，跳转到登录页面
    router.push('/login')
  }
}
</script>
  
  <style scoped>
  /* 全局样式 */
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Inter', sans-serif;
  }
  
  .app-container {
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(to bottom right, #EBF4FB, #F8FAFC); /* 调整背景渐变颜色 */
    overflow: hidden;
    position: relative;
  }
  
  /* 装饰背景 */
  .decorative-background {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    pointer-events: none;
    z-index: 0;
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
  
  /* 主内容区 */
  .content-container {
    position: relative;
    z-index: 1;
    text-align: center;
    padding: 20px;
    max-width: 600px;
    width: 90%;
  }
  
  /* 图标 */
  .icon-container {
    display: inline-block;
    padding: 20px;
    background-color: rgba(255, 255, 255, 0.9);
    border-radius: 50%;
    border: 2px solid #C5E4F7; /* 调整边框颜色和宽度 */
    box-shadow: 0 4px 8px rgba(0, 180, 216, 0.1); /* 调整阴影 */
    margin-bottom: 30px;
    animation: fadeIn 1s ease-out;
    animation: float 5s ease-in-out infinite; /* 应用浮动动画 */
  }
  
  .icon-container svg {
    font-size: 3.0rem; /* 调整图标大小 */
    color: #0077B6; /* 调整图标颜色 */
  }
  
  /* 标题 */
  .title {
    margin-bottom: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .welcome-text {
    display: block;
    font-size: clamp(1.8rem, 5vw, 2.5rem); /* 调整字体大小范围 */
    font-weight: bold;
    background: linear-gradient(to right, #0077B6, #0096C7); /* 调整标题渐变颜色 */
    background-clip: text;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    opacity: 0;
    animation: fadeIn 1s ease-out 0.3s forwards;
  }
  
  .typing-container {
    overflow: hidden; /* 确保内容滑入时不会溢出 */
    width: 100%;
    text-align: center;
    opacity: 0;
    transform: translateX(-100%);
    animation: slideIn 1s ease-out 0.8s forwards;
  }
  
  .typing-text {
    display: inline-block; /* 使文本在容器内正确对齐 */
    font-size: clamp(1.8rem, 5vw, 2.5rem);
    font-weight: bold;
    color: #0077B6; /* 调整文字颜色 */
    position: relative;
  }
  
  .typing-text::after {
    content: '';
    position: absolute;
    right: -5px;
    top: 50%;
    transform: translateY(-50%);
    width: 2px;
    height: 80%;
    background-color: #0077B6; 
    animation: blink 0.7s infinite;
  }
  
  @keyframes slideIn {
    from {
      opacity: 0;
      transform: translateX(-100%);
    }
    to {
      opacity: 1;
      transform: translateX(0);
    }
  }
  
  @keyframes blink {
    0%, 100% {
      opacity: 1;
    }
    50% {
      opacity: 0;
    }
  }
  
  /* 描述 */
  .description {
    font-size: 1rem; /* 调整字体大小 */
    color: #4A4A4A; /* 调整文字颜色 */
    margin-bottom: 30px;
    line-height: 1.5;
    opacity: 0;
    animation: fadeIn 1s ease-out 1.5s forwards;
  }
  
  /* 进入按钮 */
  .enter-button {
    background: linear-gradient(to right, #00A5E0, #0096C7); /* 调整按钮渐变颜色 */
    color: white;
    border: none;
    padding: 12px 30px; /* 调整按钮内边距 */
    border-radius: 8px; /* 调整按钮圆角 */
    font-size: 1rem;
    font-weight: bold;
    cursor: pointer;
    transition: all 0.3s ease;
    box-shadow: 0 4px 8px rgba(0, 180, 216, 0.2); /* 调整按钮阴影 */
    opacity: 0;
    animation: fadeIn 1s ease-out 2s forwards;
  }
  
  .enter-button:hover {
    background: linear-gradient(to right, #0096C7, #00A5E0);
    transform: translateY(-2px); /* 调整按钮悬停上移距离 */
    box-shadow: 0 6px 12px rgba(0, 180, 216, 0.3);
  }
  
  .enter-button:active {
    transform: translateY(1px);
  }
  .enter-button svg{
    position: relative;
    top: 3px;
  }
  
  /* 动画 */
  @keyframes fadeIn {
    from {
      opacity: 0;
      transform: translateY(10px); /* 调整动画起始位移 */
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }
  </style>