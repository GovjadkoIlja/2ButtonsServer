package hello;

import java.sql.*;
//import com.microsoft.sqlserver.jdbc;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import hello.dbCalls.Login;
import hello.dbCalls.QuestionsList;
import hello.dbCalls.UserPage;

public class MsSqlConnection {
    private final static String URL = "jdbc:sqlserver://localhost:1433";
    private final static String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;databaseName=OurFuture;integratedSecurity=true;";
    private final static String USERNAME = "Ilya";
    private final static String PASSWORD = "kate1805";

    public static Connection con = null;

    public MsSqlConnection() {
        try {
            con = DriverManager.getConnection(CONNECTIONURL);

        } catch (Exception e) {
            System.out.println("fail:(");
            e.printStackTrace();
        }

    }

    // Подумать, как закрывать connection!!!

    public static void connect() { // It's for testing DB calls
        try {
            //DriverManager.registerDriver(new SQLServerDriver());
            con = DriverManager.getConnection(CONNECTIONURL);
        } catch (Exception e) {
            System.out.println("fail:(");
            e.printStackTrace();
        }

        /*if (con != null)
            System.out.println("success!!!");
        else
            System.out.println("failed!!!");

        System.out.println("Identification: " + Login.identification(con, "89046401134", 6));
        System.out.println("CheckValidUser: " + Login.checkValidUser(con, "89046401134", "govjadq"));
        System.out.println("CheckValidLogin: " + Login.checkValidLogin(con, "govjados"));
        System.out.println("AddUser: " + Add.addUser(con, "govjadko", 111, 20, 1, "89046401155", "Java user 1", "/govjad/avatar"));*/

        /*
        Add.addQuestion(con, 3, "Едите ли вы после девяти?", 0, 0, 1, 2, "Да", "Нет");
        Clear.deleteDeletedFollows(con);
        Clear.deleteDeletedAnwsers(con);
        Clear.deleteDeletedFavorites(con);
        Clear.deleteDeletedPosts(con);
        Clear.deleteDeletedAll(con);*/

        //tablesReturning(); //Заменить нормальным вызовом функций

        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void tablesReturning() {
        ResultSet userInfo = UserPage.getUserInfo(con, 3, 1);
        try {
            if (userInfo != null) { //userInfo.next() allready done in getUserInfo
                for (int i = 1; i <= userInfo.getMetaData().getColumnCount(); i++)
                    System.out.print(userInfo.getMetaData().getColumnName(i) + ": " + userInfo.getString(i) + ";  ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*ResultSet posts = UserPage.getPosts(con, 3, 1, 2);
        try {
            while (posts.next()) {
                if (posts != null) {
                    for (int i = 1; i <= posts.getMetaData().getColumnCount(); i++)
                        System.out.print(posts.getMetaData().getColumnName(i) + ": " + posts.getString(i) + ";  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*ResultSet notifications = Notifications.getNewRecommendedQuestions(con, 3);
        try {
            while (notifications.next()) {
                if (notifications != null) { //userInfo allready done in getUserInfo
                    for (int i = 1; i <= notifications.getMetaData().getColumnCount(); i++)
                        System.out.print(notifications.getMetaData().getColumnName(i) + ": " + notifications.getString(i) + ";  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        /*ResultSet userList = PeopleList.getRecommendedStrangers(con, 1, 4, "gov");
        try {
            while (userList.next()) {
                if (userList != null) { //userInfo.next() allready done in getUserInfo
                    for (int i = 1; i <= userList.getMetaData().getColumnCount(); i++)
                        System.out.print(userList.getMetaData().getColumnName(i) + ": " + userList.getString(i) + ";  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*ResultSet results = Results.getAnsweredList(con, 4, 1, 5, 2, 0, 100, 1);
        try {
            while (results.next()) {
                if (results != null) { //userInfo.next() allready done in getUserInfo
                    for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                        System.out.print(results.getMetaData().getColumnName(i) + ": " + results.getString(i) + ";  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        ResultSet questions = QuestionsList.getHistory(con, 4, 4);
        try {
            while (questions.next()) {
                if (questions != null) { //userInfo allready done in getUserInfo
                    for (int i = 1; i <= questions.getMetaData().getColumnCount(); i++)
                        System.out.print(questions.getMetaData().getColumnName(i) + ": " + questions.getString(i) + ";  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Fix it

        /*ResultSet news = News.getNews(con, 2, 2);
        try {
            while (news.next()) {
                if (news != null) { //userInfo allready done in getUserInfo
                    for (int i = 1; i <= news.getMetaData().getColumnCount(); i++)
                        System.out.print(news.getMetaData().getColumnName(i) + ": " + news.getString(i) + ";  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*try {
            if (userInfo != null) userInfo.close();
            if (posts != null) posts.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

}




