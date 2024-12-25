package io.github.zeroornull.runnable;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.dubbo.common.utils.StringUtils;

import java.io.IOException;

/**
 * 测试servlet3.0支持的异步功能
 */
public class CustomServletRunnable implements Runnable {

    private AsyncContext asyncContext;

    public CustomServletRunnable(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        //模拟业务逻辑
        HttpServletRequest req = (HttpServletRequest) asyncContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
        String productId = req.getParameter("productId");
        if (StringUtils.isBlank(productId)) {
            productId = "0000000";
        }
        try {
            response.getWriter().write(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //完成后交由Tomcat线程池执行返回
        asyncContext.complete();
    }
}
