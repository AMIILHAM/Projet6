package com.demos.paymybuddy.web;

import com.demos.paymybuddy.dto.CustomUserDto;
import com.demos.paymybuddy.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final CustomUserService userService;

    @GetMapping("/home")
    public String index(HttpSession session, Model model) {
        String email = (String) session.getAttribute("username");
        CustomUserDto userDto = this.userService.getCustomUserDtoByEmail(email);
        model.addAttribute("pageName", "Home");
        model.addAttribute("user", userDto);
        model.addAttribute("connectionList", userDto.getFriendsList());

        return "dashboard";
    }

    @GetMapping("/contact")
    public String contactPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("username");
        CustomUserDto userDto = this.userService.getCustomUserDtoByEmail(email);
        model.addAttribute("pageName", "Contact");
        model.addAttribute("user", userDto);
        model.addAttribute("connectionList", userDto.getFriendsList());

        return "contact";
    }


    @GetMapping("/profile")
    public String profilePage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("username");
        CustomUserDto userDto = this.userService.getCustomUserDtoByEmail(email);
        model.addAttribute("pageName", "Profile");
        model.addAttribute("user", userDto);
        model.addAttribute("connectionList", userDto.getFriendsList());

        return "profile";
    }


    @PostMapping("/profile")
    public void updateProfile(@Valid @ModelAttribute("user") CustomUserDto userDto, BindingResult result,HttpSession session, Model model) {
        String email = (String) session.getAttribute("username");

    }
}
