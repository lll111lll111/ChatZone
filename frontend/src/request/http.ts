// 在http.js中引入axios
import axios from 'axios'; // 引入axios
// vant的toast提示框组件，大家可根据自己的ui组件更改。
// import { Toast } from 'vant';

axios.defaults.timeout = 1000;
axios.defaults.url = 'api'