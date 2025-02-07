package tn.esprit.projet_pi.Controller;

import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projet_pi.Log.LoginRequest;
import tn.esprit.projet_pi.Log.RegisterRequest;
import tn.esprit.projet_pi.Service.UserService;
import tn.esprit.projet_pi.entity.User;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setNom(request.getNom());
        user.setEmail(request.getEmail());
        user.setMdp(request.getMdp());
        user.setRole(request.getRole());
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {
        String token = String.valueOf(userService.login(loginRequest.getEmail(), loginRequest.getMdp()));

        // Renvoyer le token dans une réponse JSON
        return ResponseEntity.ok(Collections.singletonMap("token", token)); // Utilisation d'une map pour inclure le token dans une structure JSON
    }
}
