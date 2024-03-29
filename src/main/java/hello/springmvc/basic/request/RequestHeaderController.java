package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController //응답값으로 뷰를 찾지않고 바디에 string넣어줌
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod method,
                          Locale locale,
                          @RequestHeader MultiValueMap<String,String> headerMap, //같은 키에 여러 vlaue 가능
                          @RequestHeader ("host") String host,
                          @CookieValue(value = "mycookie", required = false) String cookie
                          ){
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", method);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);

        return"okk";

    }
}
