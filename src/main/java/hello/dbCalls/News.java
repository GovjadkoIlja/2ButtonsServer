package hello.dbCalls;

import java.sql.*;

public class News {
    public static ResultSet getNews(Connection con, int userID, int amount) {
        ResultSet rs = null;
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call getNews(?, ?)}");

            st.setInt(1, userID);
            st.setInt(2, amount);

            rs = st.executeQuery();

            //rs = (ResultSet)st.getResultSet();


            System.out.println("AAAAAAAA");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
