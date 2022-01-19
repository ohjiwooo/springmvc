package hello.springmvc.basic.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
       model.addAttribute("data","hello");
       return "hello"; //@Controller를 사용하면서 String 을 리턴하면 그것이 뷰의 이름이 됨
    }

}
