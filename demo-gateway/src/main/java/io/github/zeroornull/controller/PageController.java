package io.github.zeroornull.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/settlement")
public class PageController {

    Logger logger = LogManager.getLogger(PageController.class);

    @RequestMapping(value = {"/page"}, method = {RequestMethod.POST,
        RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    public String page(HttpServletRequest request) {
        logger.error("st is:" + request.getParameter("st"));
        return "/settlement";
    }

}
