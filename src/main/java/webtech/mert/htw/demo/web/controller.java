package webtech.mert.htw.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

    @GetMapping(path = "/")
    public ModelAndView showPage(){
        return new ModelAndView("meilenstein1");
    }
}
