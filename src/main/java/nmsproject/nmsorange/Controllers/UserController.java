package nmsproject.nmsorange.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/user/profile")
    public String userProfile() {
        return "This is user profile - accessible by USER or ADMIN";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "This is admin dashboard - accessible only by ADMIN";
    }

}
