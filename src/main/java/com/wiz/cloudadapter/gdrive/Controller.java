package com.wiz.cloudadapter.gdrive;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.authenticator.SingleSignOnSessionKey;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
public class Controller {

    @GetMapping("/oauth/google/login")
    public String message(Model model, OAuth2AuthenticationToken token){
        log.info("token: {}",token);
        return "success";
    }
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2AuthenticationToken token){
        log.info("token: {}",token);
        return "success";
    }
}
