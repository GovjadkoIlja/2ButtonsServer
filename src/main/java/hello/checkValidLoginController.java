package hello;

import hello.dbCalls.Login;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class checkValidLoginController { //Check of a user's login
    @RequestMapping(value = "/checkValidLogin")
    public int login(@RequestParam(value = "login", required = true) String login) {
        MsSqlConnection connection = new MsSqlConnection();

        System.out.println(login);

        return Login.checkValidLogin(connection.con, login);
    }
}
