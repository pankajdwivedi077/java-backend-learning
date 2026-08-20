package com.example.step25SpringJdbc.repository;

import com.example.step25SpringJdbc.model.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public @Nullable Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student st = new Student();

        st.setId(rs.getLong("id"));
        st.setName(rs.getString("name"));
        st.setEmail(rs.getString("email"));
        st.setAge(rs.getInt("age"));

        return  st;
    }
}
