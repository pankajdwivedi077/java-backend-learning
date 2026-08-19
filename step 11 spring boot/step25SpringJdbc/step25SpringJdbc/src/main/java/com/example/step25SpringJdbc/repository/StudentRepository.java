package com.example.step25SpringJdbc.repository;

import com.example.step25SpringJdbc.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/spring2";
    String user = "root";
    String password = "root";

    public void createStudent(Student st){

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

    public void updateStudent(Student st, Long id){

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

    public void deleteStudent(Long id){

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

    public Student getStudentById(Long id){

        String sql = """
               SELECT id, name, email, age FROM student WHERE id=?
                """;

        Student student = null;

        try(
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setLong(1, id);

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){

                     student = mapRow(resultSet);

                    System.out.println(student);
                }
            }

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> getAllStudent(){

        String sql = """
                SELECT id, name, email, age FROM student
                """;

        try(
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            try(ResultSet resultSet = statement.executeQuery()){

                List<Student> studentList = new ArrayList<>();

                while(resultSet.next()){

                    Student student = mapRow(resultSet);

                    studentList.add(student);
                }
                return studentList;
            }

        }catch (SQLException e){
            System.out.println("db connection failed");
            e.printStackTrace();
            return List.of();
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

}
