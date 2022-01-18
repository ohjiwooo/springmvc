package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {} , age ={}" ,username , age);
        response.getWriter().write("okk");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParmaV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge
                                 ){
        log.info("username = {} , age ={}" ,memberName , memberAge);
        return "okk";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParmaV3(@RequestParam String username,
                                 @RequestParam int age
    ){
        log.info("username = {} , age ={}" ,username, age);
        return "okk";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParmaV4(@RequestParam String username, int age
    ){
        log.info("username = {} , age ={}" ,username, age);
        return "okk";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam (required = false)String username,
            @RequestParam (required = false)int age
    ){
        log.info("username = {} , age ={}" ,username, age);
        return "okk";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam (required = false,defaultValue = "jiwoo")String username,
            @RequestParam (required = false , defaultValue = "22")int age
    ){
        log.info("username = {} , age ={}" ,username, age);
        return "okk";
    }

    /**
     * @RequestParam Map, MultiValueMap
     * Map(key=value)
     * MultiValueMap(key=[value1, value2, ...] ex) (key=userIds, value=[id1, id2])
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        log.info("username={}, age={}", helloData.getUsername(),helloData.getAge());
        return"ok";

    }

    @ResponseBody
    @RequestMapping("model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){

        log.info("username={}, age={}", helloData.getUsername(),helloData.getAge());
        return"ok";

    }
}
