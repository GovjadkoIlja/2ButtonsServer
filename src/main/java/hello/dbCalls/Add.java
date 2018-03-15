package hello.dbCalls;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;

public class Add {
    public static int addUser(Connection con, String login, int password, int age, int sex, String phone, String description, String avatarLink) {
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call addUser(?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            st.setString("login", login);
            st.setInt("password", password);
            st.setInt("age", age);
            st.setInt("sex", sex);
            st.setString("phone", phone);
            st.setString("description", description);
            st.setString("avatarLink", avatarLink);
            java.sql.Date regDate = new java.sql.Date(Calendar.getInstance().getTime().getTime()); //Доработать, чтобы время было не нулевое всегда

            st.setDate("regDate", regDate);
            st.registerOutParameter("userID", Types.INTEGER);

            st.execute();
            return st.getInt("userID");
            //return st.getInt(9);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(st!=null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static void addQuestion(Connection con, int userID, String condition, int anonymity, int audience, int questionType, int standartPictureID, String firstOption, String secondOption) {
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call addQuestion(?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            st.setInt("userID", userID);
            st.setString("condition", condition);
            st.setInt("anonymity", anonymity);
            st.setInt("audience", audience);
            st.setInt("questionType", questionType);
            st.setInt("standartPictureID", standartPictureID);
            st.setString("firstOption", firstOption);
            st.setString("secondOption", secondOption);

            java.sql.Date asked = new java.sql.Date(Calendar.getInstance().getTime().getTime()); //Доработать, чтобы время было не нулевое всегда
            st.setDate("asked", asked);

            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(st!=null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
