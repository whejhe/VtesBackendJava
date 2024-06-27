package com.vtes.backend_vtes.Controllers.secure;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/secure")
@RequiredArgsConstructor
public class SecureController {
    
    @PostMapping(value = "secure/login")
    public String login() {
        return "Login from secure endpoint";
    }

    
}
