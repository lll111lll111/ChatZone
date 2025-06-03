import type { App } from 'vue';
import { ElMessage } from 'element-plus';
import { AxiosError } from 'axios';

export const ErrorHandler = {
  install(app: App) {
    // 1. 处理Vue组件错误
    app.config.errorHandler = (err: unknown, instance, info: string) => {
      console.error('[Vue错误]', info, err);
      // 断言 err 为 Error 类型，或者进行类型检查
      showErrorToast(err as Error);
    };

    // 2. 处理未捕获的Promise错误
    window.addEventListener('unhandledrejection', (event: PromiseRejectionEvent) => {
      console.error('[Promise错误]', event.reason);
      showErrorToast(event.reason as Error); // 断言为 Error 类型
      event.preventDefault();
    });

    // 3. 处理JavaScript运行时错误
    window.onerror = function (
      eventOrMessage: string | Event,
      source?: string,
      lineno?: number,
      colno?: number,
      error?: Error
    ): boolean {
      if (typeof eventOrMessage === 'string') {
        // Standard error
        console.error('[运行时错误]', eventOrMessage, source, lineno, colno, error);
        showErrorToast(eventOrMessage);
      } else {
        // Event error (e.g., resource loading)
        console.error('[运行时错误]', eventOrMessage);
        showErrorToast('运行时错误');
      }
      return true;
    };

    // 4. 处理资源加载错误
    window.addEventListener('error', (event: Event) => {
      if (event.target instanceof HTMLImageElement) {
        console.error('[资源加载错误]', event.target.src);
        // 传递字符串而不是 event 对象
        showErrorToast(`图片加载失败: ${event.target.src}`);
      }
    }, true);
  },
};

// 统一错误提示方法
type CustomError = Error | AxiosError | string;

const showErrorToast = (error: CustomError) => {
  let message = '未知错误';
  
  if (typeof error === 'string') {
    message = error;
  } else if (error instanceof AxiosError) {
    message = error.response?.data?.message || error.message;
  } else {
    message = error.message || error.toString();
  }
  
  ElMessage({
    message,
    type: 'error',
    duration: 5000,
  });
};