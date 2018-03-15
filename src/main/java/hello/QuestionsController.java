package hello;

import hello.dbCalls.Question;
import hello.dbCalls.UserPage;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class QuestionsController {
    @RequestMapping(value = "/saveFeedback") //Можно в скобках дописать method = RequestMethod.GET чтобы знать, к какому методу мы обращаемся. По какому URL обращаемся к методу и каким http методом (GET, POST) А так обращается по всем
    public int saveFeedback(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "questionId", required = true) int questionId, @RequestParam(value = "feedback", required = false, defaultValue = "0") int feedback) {
        MsSqlConnection connection = new MsSqlConnection();

        Question.saveFeedback(connection.con, id, questionId, feedback);

        return 200;
    }

    @RequestMapping(value = "/saveFavorites") //Можно в скобках дописать method = RequestMethod.GET чтобы знать, к какому методу мы обращаемся. По какому URL обращаемся к методу и каким http методом (GET, POST) А так обращается по всем
    public int saveFavorites(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "questionId", required = true) int questionId, @RequestParam(value = "inFavorites", required = false, defaultValue = "0") int inFavorites) {
        MsSqlConnection connection = new MsSqlConnection();

        Question.saveFavorites(connection.con, id, questionId, inFavorites);

        return 200;
    }

    @RequestMapping(value = "/saveAnswer") //Можно в скобках дописать method = RequestMethod.GET чтобы знать, к какому методу мы обращаемся. По какому URL обращаемся к методу и каким http методом (GET, POST) А так обращается по всем
    public int saveAnswer(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "questionId", required = true) int questionId, @RequestParam(value = "answer", required = true) int answer) {
        MsSqlConnection connection = new MsSqlConnection();

        Question.saveAnswer(connection.con, id, questionId, answer);

        return 200;
    }
}
