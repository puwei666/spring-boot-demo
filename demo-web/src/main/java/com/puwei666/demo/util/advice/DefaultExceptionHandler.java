package com.puwei666.demo.util.advice;

import com.puwei666.demo.consts.MessageConst;
import com.puwei666.demo.exception.InputException;
import com.puwei666.demo.vo.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(InputException.class)
    @ResponseBody
    ResponseMessage handleInputException(HttpServletRequest request, HttpServletResponse response,
                                         InputException exception) {
        log.info("Input exception", exception);
        ResponseMessage responseMessage = new ResponseMessage(MessageConst.CODE_INPUT_ERROR, exception.getMessage());
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return responseMessage;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ResponseMessage handleException(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        log.error("", e);
        ResponseMessage responseMessage = new ResponseMessage(MessageConst.CODE_INNER_ERROR,
                MessageConst.MSG_INNER_ERROR);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return responseMessage;
    }

}
