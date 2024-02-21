package br.com.api.auth;

import br.com.api.auth.dto.UserDto;
import br.com.api.auth.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/new")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveNewUser(@RequestBody @Validated UserDto userDto) {
        try {
            ModelMapper mp = new ModelMapper();
            var user = mp.map(userDto, User.class);
            userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha no cadastro do usuário.");

        }
    }

    @GetMapping("todos")
    public  List<User> list() {
//        if (principal != null) {
//            List<User> AllUsers = userService.listAll(null);
//            return ResponseEntity.ok(AllUsers);
//        }
//        UserDetailsServiceImpl userDetailsService = null;
//        User authenticatedUser = (User) userDetailsService.loadUserByUsername(principal.getName());
//
//        if (userService.isAdmin(authenticatedUser)) {
//            List<User> AllUsers = userService.listAll(authenticatedUser);
//            return ResponseEntity.ok(AllUsers);
//        } else {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//        }
            return userService.listAll();


    }


}
