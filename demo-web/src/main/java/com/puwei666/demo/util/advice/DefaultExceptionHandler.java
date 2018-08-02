package com.puwei666.demo.util.advice;

import com.puwei666.demo.consts.MessageConst;
import com.puwei666.demo.exception.InputException;
import com.puwei666.demo.vo.ResponseMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DefaultExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

  @ExceptionHandler(InputException.class)
  @ResponseBody
  ResponseMessage handleInputException(HttpServletRequest request , HttpServletResponse response, InputException exception) {
    logger.error("Input exception",exception);
    ResponseMessage responseMessage = new ResponseMessage(MessageConst.CODE_INPUT_ERROR,exception.getMessage());
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    return responseMessage;
  }

  @ExceptionHandler(Throwable.class)
  @ResponseBody
  ResponseMessage handleException(HttpServletRequest request , HttpServletResponse response, Throwable e){
    logger.error("",e);
    ResponseMessage responseMessage = new ResponseMessage(MessageConst.CODE_INNER_ERROR,MessageConst.MSG_INNER_ERROR);
    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    return responseMessage;
  }

}
