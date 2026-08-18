package org.example.repository;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/spring2";
    String user = "root";
    String password = "root";

    Connection connection = null;

    public void createUser(){

        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("db connected");

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO student(name, email, age) " +
                    "VALUES('Raj', 'raj@gmail.com', 21)";

           int result = statement.executeUpdate(sql);

           if(result == 1){
               System.out.println("created op successful");
           }else{
               System.out.println("op failed");
           }

            connection.close();

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    public void updateUser(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("db connected");

            Statement statement = connection.createStatement();

            String sql = "UPDATE  student SET age=30 WHERE id=1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("update successful");
            }else{
                System.out.println("update failed");
            }

            connection.close();

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    public void deleteUser(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("db connected");

            Statement statement = connection.createStatement();

            String sql = "DELETE FROM student WHERE id=1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("delete successful");
            }else{
                System.out.println("delete failed");
            }

            connection.close();

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    public void getUserById(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("db connected");

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age FROM student WHERE id=1";

            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();

            Student student = mapRow(resultSet);

            System.out.println(student);

            connection.close();

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    public void completeCRUD(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("db connected");

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age FROM student WHERE ID=1";

            boolean result =  statement.execute(sql);

            if(result){
                ResultSet resultSet = statement.getResultSet();
            }else{
                int rowAffected = statement.getUpdateCount();
            }

            connection.close();

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student st = new Student();
        st.setId(resultSet.getLong("id"));
        st.setName(resultSet.getString("name"));
        st.setEmail(resultSet.getString("email"));
        st.setAge(resultSet.getInt("age"));
        return  st;
    }

    public void createUser2(Student st){

        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("db connected");

            Statement statement = connection.createStatement();

            String sql = """
                        INSERT INTO student(name, email, age)
                        VALUES('%s', '%s', '%d')
                    """.formatted(st.getName(), st.getEmail(), st.getAge());

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("created op successful");
            }else{
                System.out.println("op failed");
            }

            connection.close();

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    // most used way prepare statement
    public void createUser3(Student st){

        try{
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("db connected");

            String sql = """
                       INSERT INTO student(name, email, age)
                       VALUES(?,?,?)
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, st.getName());
            preparedStatement.setString(2, st.getEmail());
            preparedStatement.setInt(3, st.getAge());

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 1){
                System.out.println("created successful");
            }else{
                System.out.println("failed");
            }

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }finally {
           try{
               connection.close();
           }catch(SQLException e){
               e.printStackTrace();
           }
        }
    }



}
