package hello;

import hello.dbCalls.Add;
import hello.dbCalls.Login;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController { //Controller for a registration
    @RequestMapping(value = "/addUser") //Можно в скобках дописать method = RequestMethod.GET чтобы знать, к какому методу мы обращаемся. По какому URL обращаемся к методу и каким http методом (GET, POST) А так обращается по всем
    public int login(@RequestParam(value = "login", required = true) String login, @RequestParam(value = "password", required = true) int password, @RequestParam(value = "phone", required = false, defaultValue = "NULL") String phone, @RequestParam(value = "description", required = false, defaultValue = "NULL") String description, @RequestParam(value = "age", required = true) int age, @RequestParam(value = "sex", required = true) int sex, @RequestParam(value = "avatarLink", required = false, defaultValue = "NULL") String avatarLink)  {
        MsSqlConnection connection = new MsSqlConnection();

        System.out.println(login);

        return Add.addUser(connection.con, login, password, age, sex, phone, description, avatarLink); //Данные напрямую записываются в HTTP ответ в JSON
    }
}
