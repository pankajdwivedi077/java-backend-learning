package org.example.repository;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/spring2";
    String user = "root";
    String password = "root";

    Connection connection = null;
    PreparedStatement preparedStatement;

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

            preparedStatement = connection.prepareStatement(sql);

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
               preparedStatement.close();
           }catch(SQLException e){
               e.printStackTrace();

           }
           try{
               connection.close();
           }catch(SQLException e){
               e.printStackTrace();
           }
        }
    }

    // try with resource way no need to use finally
    public void createUser4(Student st){

        String sql = """
                       INSERT INTO student(name, email, age)
                       VALUES(?,?,?)
                    """;

        try (
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

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
        }
    }

    public void updateUser2(Student st, Long id){

        String sql = """
                  UPDATE student
                  SET name = ?
                      email = ?
                      age = ?
                  WHERE id = ?    
                """;

        try (
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                ) {

            preparedStatement1.setString(1, st.getName());
            preparedStatement1.setString(2, st.getEmail());
            preparedStatement1.setInt(3, st.getAge());
            preparedStatement1.setLong(4,id);

            int result = preparedStatement1.executeUpdate();

            if(result == 1){
                System.out.println("update successful");
            }else{
                System.out.println("update failed");
            }

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    public void deleteUser2(Long id){

        String sql = """
                DELETE FROM student WHERE id=?
                """;

        try(
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement statement = connection.prepareStatement(sql);
                ){

            statement.setLong(1, id);

            int result = statement.executeUpdate();

            if(result == 1){
                System.out.println("delete successful");
            }else{
                System.out.println("delete failed");
            }

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    public void getUserById2(Long id){

        String sql = """
               SELECT id, name, email, age FROM student WHERE id=?
                """;

        try(
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement statement = connection.prepareStatement(sql);
                ){

            statement.setLong(1, id);

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){

                    Student student = mapRow(resultSet);

                    System.out.println(student);
                }
            }

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

    public void getAllStudent(){

        String sql = """
                SELECT id, name, email, age FROM student
                """;

        try(
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){

                    Student student = mapRow(resultSet);

                    System.out.println(student);
                }
            }

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
    }

}
