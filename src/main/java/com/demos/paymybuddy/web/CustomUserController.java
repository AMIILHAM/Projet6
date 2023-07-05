package com.demos.paymybuddy.web;

import com.demos.paymybuddy.domain.CustomUser;
import com.demos.paymybuddy.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class CustomUserController {

    private final CustomUserService customUserService;

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable Long userId, Model model) {

        CustomUser user = this.customUserService.findById(userId).orElse(null);
        if (user == null) {
             return "userNotFound";
        }else {
            model.addAttribute("user", user);
            return "userDetails";
        }
    }

}
