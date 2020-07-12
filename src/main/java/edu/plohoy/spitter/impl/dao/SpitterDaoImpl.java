package edu.plohoy.spitter.impl.dao;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SpitterDaoImpl implements SpitterDao {
    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (user_name, user_password, user_full_name, user_mail) values (?, ?, ?, ?)";
    private static final String SQL_SELECT_SPITTER_BY_ID =
            "select user_id, user_name, user_password, user_full_name, user_mail from spitter where user_id=?";
    private static final String SQL_UPDATE_SPITTER =
            "update spitter set user_name=?, user_password=?, user_full_name=? where user_id=?";
    private static final String SQL_DELETE_SPITTER_BY_ID =
            "delete from spitter where user_id=?";
    private JdbcTemplate jdbcTemplate;
    private Map<String, Object> params;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addSpitter(Spitter spitter) {
//        params = new HashMap<>();
//        params.put("userName", spitter.getUserName());
//        params.put("userPassword", spitter.getPassword());
//        params.put("userFullName", spitter.getFullName());
//        params.put("userMail", spitter.getEmail());

        jdbcTemplate.update(
                SQL_INSERT_SPITTER,
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail()
        );
//        spitter.setId();
//        System.out.println(String.format("Spitter \"%s\" was added!", spitter.getUserName()));
    }

    public Spitter getSpitterById(long id) {

//        System.out.println(String.format("Spitter with id=%d was taken!", id));
        return jdbcTemplate.query(SQL_SELECT_SPITTER_BY_ID, resultSet -> {
            Spitter spitter = new Spitter();
            if (resultSet.next()) {
                spitter.setId(resultSet.getLong(1));
                spitter.setUserName(resultSet.getString(2));
                spitter.setPassword(resultSet.getString(3));
                spitter.setFullName(resultSet.getString(4));
                spitter.setEmail(resultSet.getString(5));
            }

            return spitter;
        }, id);
    }

    public void updateSpitter(Spitter spitter, long id) {
        jdbcTemplate.update(SQL_UPDATE_SPITTER, spitter.getUserName(), spitter.getPassword(), spitter.getFullName(), id);
//        System.out.println(String.format("Spitter №%d \"%s\" will be updated to №%d!", spitter.getId(), spitter.getUserName(), id));
//        spitter.setId(id);
//        System.out.println(String.format("Spitter \"%s\" was successfully updated to №%d!", spitter.getUserName(), spitter.getId()));
    }

    public void deleteSpitter(long id) {
        jdbcTemplate.update(SQL_DELETE_SPITTER_BY_ID, id);
//        System.out.println(String.format("Spitter №%d was deleted!", id));
    }
}
