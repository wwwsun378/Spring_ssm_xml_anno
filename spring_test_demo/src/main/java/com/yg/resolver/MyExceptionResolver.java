package com.yg.resolver;

import com.yg.exception.BaseExecption;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/7 16:02
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /*
      参数Exception：异常对象
      返回值ModelAndView：跳转到错误视图信息
  */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof BaseExecption) {
            modelAndView.addObject("info", "自定义异常");
        } else if (e instanceof ClassCastException) {
            modelAndView.addObject("info", "类转换异常");
        }

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
