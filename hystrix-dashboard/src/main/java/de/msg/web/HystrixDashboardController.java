package de.msg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The {@link HystrixDashboardController} redirects to the hystrix dashboard.
 */
@Controller
public class HystrixDashboardController {
    /**
     * Forwards http requests from / to /hystrix.
     *
     * @return Request mapping to /hystrix.
     */
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }
}
