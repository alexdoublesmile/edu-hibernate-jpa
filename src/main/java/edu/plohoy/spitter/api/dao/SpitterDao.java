package edu.plohoy.spitter.api.dao;

import edu.plohoy.spitter.api.domain.Spitter;

public interface SpitterDao {

    String SQL_INSERT_SPITTER =
            "insert into spitter (user_name, user_password, user_full_name, user_mail) values (?, ?, ?, ?)";
    String SQL_SELECT_SPITTER_BY_ID =
            "select user_id, user_name, user_password, user_full_name, user_mail from spitter where user_id=?";
    String SQL_UPDATE_SPITTER =
            "update spitter set user_name=?, user_password=?, user_full_name=? where user_id=?";
    String SQL_DELETE_SPITTER_BY_ID =
            "delete from spitter where user_id=?";

    void addSpitter(Spitter spitter);
    Spitter getSpitterById(long id);
    void updateSpitter(Spitter spitter, long id);
    void deleteSpitter(long id);
}
