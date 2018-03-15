package hello;

import hello.dbCalls.PeopleList;
import hello.dbCalls.Results;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class VotersController { //Controller for question's voters
    @RequestMapping(value = "/getVoters")
    public String getVoters(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "questionId", required = true) int questionId, @RequestParam(value = "amount", required = false, defaultValue = "15") int amount, @RequestParam(value = "option", required = true) int option, @RequestParam(value = "minAge", required = false, defaultValue = "0") int minAge, @RequestParam(value = "maxAge", required = false, defaultValue = "100") int maxAge, @RequestParam(value = "sex", required = false, defaultValue = "0") int sex, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        MsSqlConnection connection = new MsSqlConnection();

        ResultSet voters = Results.getAnsweredList(connection.con, id, questionId, amount, option, minAge, maxAge, sex, search);

        /*try {
            voters.beforeFirst();;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        JSONArray arr = new JSONArray();
        try {
            try {
                arr = ResultSetConverter.convert(voters);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arr.toString();
    }
}
