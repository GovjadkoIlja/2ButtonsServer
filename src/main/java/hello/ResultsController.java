package hello;

import hello.dbCalls.Question;
import hello.dbCalls.Results;
import hello.dbCalls.UserPage;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class ResultsController { //To work with questions results
    @RequestMapping(value = "/getResults")
    public String saveFeedback(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "questionId", required = true) int questionId, @RequestParam(value = "minAge", required = false, defaultValue = "0") int minAge, @RequestParam(value = "maxAge", required = false, defaultValue = "100") int maxAge, @RequestParam(value = "sex", required = false, defaultValue = "0") int sex) {
        MsSqlConnection connection = new MsSqlConnection();

        ResultSet results = Results.getResults(connection.con, id, questionId, minAge, maxAge, sex);

        /*try {
            results.beforeFirst();;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        JSONArray arr = new JSONArray();
        try {
            try {
                arr = ResultSetConverter.convert(results);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(arr.toString().substring(1, arr.toString().length()-1));

        return arr.toString().substring(1, arr.toString().length()-1);
    }
}
