package edu.plohoy.spitter.impl.dao;

import edu.plohoy.spitter.api.dao.SpitterDao;
import edu.plohoy.spitter.api.domain.Spitter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCSpitterDaoImpl implements SpitterDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(
                SQL_INSERT_SPITTER,
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail()
        );
    }

    @Override
    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_SPITTER_BY_ID,
                this::mapRowToSpitter,
                id
        );
    }

    @Override
    public void updateSpitter(Spitter spitter, long id) {
        jdbcTemplate.update(
                SQL_UPDATE_SPITTER,
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName(),
                id
        );
    }

    @Override
    public void deleteSpitter(long id) {
        jdbcTemplate.update(
                SQL_DELETE_SPITTER_BY_ID,
                id
        );
    }

    @Override
    public List<Spitter> getAllSpitters() {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_ALL_SPITTERS,
                this::mapRowToSpitterList
        );
    }

    private Spitter mapRowToSpitter(ResultSet rs, int rowNum) throws SQLException {
        Spitter spitter = new Spitter();
        spitter.setId(rs.getLong("user_id"));
        spitter.setUserName(rs.getString("user_name"));
        spitter.setPassword(rs.getString("user_password"));
        spitter.setFullName(rs.getString("user_full_name"));
        spitter.setEmail(rs.getString("user_mail"));

        return spitter;
    }

    private List<Spitter> mapRowToSpitterList(ResultSet rs, int rowNum) throws SQLException {
        List<Spitter> spitters = new ArrayList<>();
        spitters.add(mapRowToSpitter(rs, rowNum));
        while (rs.next()) {
            spitters.add(mapRowToSpitter(rs, rowNum));
        }
        return spitters;
    }
}
