package cn.daymenu.milucms.admin.exception;

import cn.daymenu.milucms.admin.common.enums.ExceptionCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author madison
 */
@Configuration
public class ExceptionHandler implements HandlerExceptionResolver,Ordered {

    private static final  Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final String ERROR_CODE_NAME = "code";
    private static final String ERROR_MSG_NAME = "message";
    private static final String ERROR_DATA_NAME = "data";
    MappingJackson2JsonView view = new MappingJackson2JsonView();
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            if (bindingResult.hasErrors() && bindingResult.hasFieldErrors()) {
                FieldError fieldError = bindingResult.getFieldError();
                LOGGER.warn(fieldError.getDefaultMessage());
                modelAndView.addObject(ERROR_CODE_NAME, ExceptionCodeEnum.ILLEGAL_PARAMS.getCode());
                modelAndView.addObject(ERROR_MSG_NAME, fieldError.getDefaultMessage());
            }
        } else{
            modelAndView.addObject(ERROR_CODE_NAME, ExceptionCodeEnum.SERVER_ERROR.getCode());
            modelAndView.addObject(ERROR_MSG_NAME, e.getMessage());
        }
        modelAndView.addObject(ERROR_DATA_NAME,null);
        modelAndView.setView(view);
        return modelAndView;
    }
}
