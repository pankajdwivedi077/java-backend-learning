package com.example.step25SpringJdbc.repository;

import com.example.step25SpringJdbc.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    // spring do this automatically
//    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

//    private StudentRowMapper studentRowMapper = new StudentRowMapper();

    // spring itself do mapping with this special class
//    private RowMapper<Student> rowMapper =
//            new BeanPropertyRowMapper<>(Student.class);

    @Autowired
    public StudentRepository(JdbcTemplate template){
//        this.dataSource = dataSource;
        this.jdbcTemplate = template;
    }

//    @PostConstruct
//     public void init(){
//        System.out.println(dataSource.getClass());
//    }

//    String url = "jdbc:mysql://localhost:3306/spring2";
//    String user = "root";
//    String password = "root";

    public void createStudent(Student st){

        String sql = """
                       INSERT INTO student(name, email, age)
                       VALUES(?,?,?)
                    """;
        try{

            int rowAffected = jdbcTemplate.update(sql, st.getName(), st.getEmail(), st.getAge());

            if(rowAffected == 1){
                System.out.println("created successful");
            }else{
                System.out.println("failed");
            }
        }catch(DuplicateKeyException de){
//            throw new EmailAlreadyExistException("Email exist");
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

        int result = jdbcTemplate.update(sql, st.getName(), st.getEmail(), st.getAge(), id);

        if(result == 1){
            System.out.println("update successful");
        }else{
            System.out.println("update failed");
        }

    }

    public void deleteStudent(Long id){

        String sql = """
                DELETE FROM student WHERE id=?
                """;

        int result = jdbcTemplate.update(sql, id);

        if(result == 1){
            System.out.println("delete successful");
        }else{
            System.out.println("delete failed");
        }

    }

    public Student getStudentById(Long id){

        String sql = """
               SELECT id, name, email, age FROM student WHERE id=?
                """;

        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }

    public List<Student> getAllStudent(){

        String sql = """
                SELECT id, name, email, age FROM student
                """;

        List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());

        return studentList;

    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student st = new Student();
        st.setId(resultSet.getLong("id"));
        st.setName(resultSet.getString("name"));
        st.setEmail(resultSet.getString("email"));
        st.setAge(resultSet.getInt("age"));
        return  st;
    }


}
