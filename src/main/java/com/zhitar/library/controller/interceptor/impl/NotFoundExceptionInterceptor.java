package com.zhitar.library.controller.interceptor.impl;

import com.zhitar.library.controller.interceptor.ControllerExceptionInterceptor;
import com.zhitar.library.exception.NotFoundException;
import com.zhitar.library.util.PropertiesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundExceptionInterceptor implements ControllerExceptionInterceptor {

    @Override
    public boolean canHandle(Throwable ex) {
        return ex.getClass() == NotFoundException.class;
    }

    @Override
    public String afterException(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        String message = e.getMessage();
        String view = null;
        if (message.contains("email")) {
            request.setAttribute("error", message);
            request.setAttribute("email", request.getParameter("email"));
            view = PropertiesUtil.getValue("app.login.page");
        } else if (message.contains("notfound")) {
            view = PropertiesUtil.getValue("app.bookList.page");
            request.setAttribute("error", e.getMessage());
        }
        return view;
    }
}
