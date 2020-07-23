package edu.plohoy.spitter.api.dao;

import edu.plohoy.spitter.api.domain.Spitter;

import java.util.List;

public interface SpitterDao {

    String SQL_INSERT_SPITTER =
            "insert into spitter (user_name, user_password, user_full_name, user_mail) values (?, ?, ?, ?)";
    String SQL_SELECT_SPITTER_BY_ID =
            "select user_id, user_name, user_password, user_full_name, user_mail from spitter where user_id=?";
    String SQL_SELECT_ALL_SPITTERS =
            "select * from spitter";
    String SQL_UPDATE_SPITTER =
            "update spitter set user_name=?, user_password=?, user_full_name=? where user_id=?";
    String SQL_DELETE_SPITTER_BY_ID =
            "delete from spitter where user_id=?";

    String HQL_INSERT_SPITTER = "";
    String HQL_SELECT_SPITTER_BY_ID = "";
    String HQL_SELECT_ALL_SPITTERS = "";
    String HQL_UPDATE_SPITTER = "";
    String HQL_DELETE_SPITTER_BY_ID = "";

    String JPQL_INSERT_SPITTER = "";
    String JPQL_SELECT_SPITTER_BY_ID = "";
    String JPQL_SELECT_ALL_SPITTERS = "";
    String JPQL_UPDATE_SPITTER = "";
    String JPQL_DELETE_SPITTER_BY_ID = "";


    void addSpitter(Spitter spitter);
    Spitter getSpitterById(long id);
    void updateSpitter(Spitter spitter, long id);
    void deleteSpitter(long id);
    List<Spitter> getAllSpitters();
}
