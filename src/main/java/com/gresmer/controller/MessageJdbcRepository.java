package com.gresmer.controller;

import com.gresmer.model.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MessageJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public OutputMessage findById(long id) {
        return jdbcTemplate.queryForObject("select * from message where id=?", new Object[] {
                id
        },
        new BeanPropertyRowMapper<>(OutputMessage.class));
    }

    public List<OutputMessage> findAll() {
        return jdbcTemplate.query("SELECT * FROM message", new OutputMessageRowMapper());
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from message where id=?", new Object[] {
                id
        });
    }

    public int insert(OutputMessage message) {
        return jdbcTemplate.update("insert into message (from, text, time) " + "values(?,  ?, ?)",
                new Object[] {
                        message.getFrom(), message.getText(), message.getTime()
                });
    }

}

class OutputMessageRowMapper implements RowMapper<OutputMessage> {

    @Override
    public OutputMessage mapRow(ResultSet resultSet, int i) throws SQLException {
        OutputMessage outputMessage = new OutputMessage();
        outputMessage.setFrom(resultSet.getNString("from"));
        outputMessage.setText(resultSet.getNString("text"));
        outputMessage.setTime(resultSet.getNString("time"));
        return outputMessage;
    }
}
