package com.memory.user.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.memory.user.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

  public JsonpAdvice() {
    super("callback");
  }
}
