/*
 * This file is generated by jOOQ.
 */
package com.example.models.tables;


import com.example.models.Indexes;
import com.example.models.Public;
import com.example.models.tables.records.UsersRecord;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = 2005155552;

    /**
     * The reference instance of <code>public.users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    /**
     * The column <code>public.users.user_id</code>.
     */
    public final TableField<UsersRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('users_user_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.users.username</code>.
     */
    public final TableField<UsersRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.password</code>.
     */
    public final TableField<UsersRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.salt</code>.
     */
    public final TableField<UsersRecord, String> SALT = createField("salt", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.users.firstname</code>.
     */
    public final TableField<UsersRecord, String> FIRSTNAME = createField("firstname", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.lastname</code>.
     */
    public final TableField<UsersRecord, String> LASTNAME = createField("lastname", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.email</code>.
     */
    public final TableField<UsersRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.status</code>.
     */
    public final TableField<UsersRecord, Short> STATUS = createField("status", org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>public.users.createdon</code>.
     */
    public final TableField<UsersRecord, OffsetDateTime> CREATEDON = createField("createdon", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.users.mobile</code>.
     */
    public final TableField<UsersRecord, Long> MOBILE = createField("mobile", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.users.changedon</code>.
     */
    public final TableField<UsersRecord, OffsetDateTime> CHANGEDON = createField("changedon", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * Create a <code>public.users</code> table reference
     */
    public Users() {
        this(DSL.name("users"), null);
    }

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    public Users(Name alias) {
        this(alias, USERS);
    }

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USERS_EMAIL_KEY, Indexes.USERS_PKEY, Indexes.USERS_USERNAME_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UsersRecord, Integer> getIdentity() {
        return Internal.createIdentity(com.example.models.tables.Users.USERS, com.example.models.tables.Users.USERS.USER_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Internal.createUniqueKey(com.example.models.tables.Users.USERS, "users_pkey", com.example.models.tables.Users.USERS.USER_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersRecord>>asList(
              Internal.createUniqueKey(com.example.models.tables.Users.USERS, "users_pkey", com.example.models.tables.Users.USERS.USER_ID)
            , Internal.createUniqueKey(com.example.models.tables.Users.USERS, "users_username_key", com.example.models.tables.Users.USERS.USERNAME)
            , Internal.createUniqueKey(com.example.models.tables.Users.USERS, "users_email_key", com.example.models.tables.Users.USERS.EMAIL)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(Name name) {
        return new Users(name, null);
    }
}
