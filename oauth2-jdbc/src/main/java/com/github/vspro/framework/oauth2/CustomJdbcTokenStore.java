package com.github.vspro.framework.oauth2;

import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created  on 2018/6/12.
 */
public class CustomJdbcTokenStore extends JdbcTokenStore {

    public CustomJdbcTokenStore(DataSource dataSource) {
        super(dataSource);
    }


    @Override
    protected String extractTokenKey(String value) {
        if (value == null) {
            return null;
        }
        return value;
    }
}
