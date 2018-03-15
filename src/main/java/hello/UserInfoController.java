package hello;

import org.json.JSONArray;
import hello.dbCalls.UserPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class UserInfoController { //We get user's information
    @RequestMapping(value = "/getUserInfo")
    public String getUserInfo(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "userId", required = true) int userId) {
        MsSqlConnection connection = new MsSqlConnection();

        ResultSet userInfo = UserPage.getUserInfo(connection.con, id, userId);

       /* try {
            userInfo.beforeFirst();;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        JSONArray arr = new JSONArray();
        try {
            try {
                arr = ResultSetConverter.convert(userInfo);
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
