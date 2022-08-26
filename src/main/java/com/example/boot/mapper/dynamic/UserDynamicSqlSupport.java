package com.example.boot.mapper.dynamic;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UserDynamicSqlSupport {
    public static final User user = new User();

    /**
     * 主键
     */
    public static final SqlColumn<Integer> id = user.id;

    /**
     * 名称
     */
    public static final SqlColumn<String> name = user.name;

    public static final class User extends AliasableSqlTable<User> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public User() {
            super("user", User::new);
        }
    }
}