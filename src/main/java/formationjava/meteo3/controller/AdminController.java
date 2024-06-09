package formationjava.meteo3.controller;

import formationjava.meteo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update-role/{username}")
    public void updateUserRole(@PathVariable String username, @RequestBody Map<String, String> role) {
        userService.updateRole(username, role.get("role"));
    }
}
