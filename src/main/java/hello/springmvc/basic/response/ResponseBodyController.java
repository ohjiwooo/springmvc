package hello.springmvc.basic.response;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response)throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(){
       return new ResponseEntity<>("okk", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3(){
        return "okk";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyV4(){
        HelloData helloData = new HelloData();
        helloData.setUsername("jiwoo");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData,HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyV5(){
        HelloData helloData = new HelloData();
        helloData.setUsername("jiwoo");
        helloData.setAge(20);

        return helloData;
    }
}
