package hello;

import hello.dbCalls.Login;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController { //Check user's credentials during authentication and send id.
    @RequestMapping(value = "/login")
    public int login(@RequestParam(value = "login", required = true) String login, @RequestParam(value = "password", required = true) int password) {
        MsSqlConnection connection = new MsSqlConnection();

        System.out.println(login + " " + password);

        return Login.identification(connection.con, login, password);
    }
}
