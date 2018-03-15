package hello;

import hello.dbCalls.PeopleList;
import hello.dbCalls.UserPage;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class FollowersController { //Represent user's followers or people who user are follow to
    @RequestMapping(value = "/getFollowers")
    public String getFollowers(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "userId", required = true) int userId, @RequestParam(value = "amount", required = false, defaultValue = "100") int amount, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        MsSqlConnection connection = new MsSqlConnection();

        ResultSet followers = PeopleList.getFollowers(connection.con, id, userId, amount, search);

        System.out.println(followers);

        /*try {
            followers.beforeFirst();;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        JSONArray arr = new JSONArray();
        try {
            try {
                arr = ResultSetConverter.convert(followers);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(arr.toString());

        return arr.toString();
    }

    @RequestMapping(value = "/getFollowTo")
    public String getFollowTo(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "userId", required = true) int userId, @RequestParam(value = "amount", required = false, defaultValue = "100") int amount, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        MsSqlConnection connection = new MsSqlConnection();

        ResultSet followTo = PeopleList.getFollowTo(connection.con, id, userId, amount, search);

        System.out.println(followTo);

        /*try {
            followTo.beforeFirst();;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        JSONArray arr = new JSONArray();
        try {
            try {
                arr = ResultSetConverter.convert(followTo);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(arr.toString());

        return arr.toString();
    }
}
