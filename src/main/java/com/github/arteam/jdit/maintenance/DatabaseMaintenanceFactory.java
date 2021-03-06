package com.github.arteam.jdit.maintenance;


import org.jdbi.v3.core.Handle;

import java.sql.SQLException;

/**
 * Date: 1/1/16
 * Time: 6:54 PM
 * <p>
 * A factory for creating vendor-specific {@link DatabaseMaintenance} instances
 * based on the current database vendor name
 *
 * @author Artem Prigoda
 */
public final class DatabaseMaintenanceFactory {

    private static final String POSTGRESQL = "PostgreSQL";
    private static final String HSQLDB = "HSQL Database Engine";
    private static final String H2 = "H2";
    private static final String MYSQL = "MySQL";

    private DatabaseMaintenanceFactory() {
    }

    public static DatabaseMaintenance create(Handle handle) {
        String databaseVendor = getDatabaseVendor(handle);
        switch (databaseVendor) {
            case POSTGRESQL:
                return new PostgresDatabaseMaintenance(handle);
            case HSQLDB:
                return new HsqlDatabaseMaintenance(handle);
            case H2:
                return new H2DatabaseMaintenance(handle);
            case MYSQL:
                return new MySqlDatabaseMaintenance(handle);
            default:
                throw new UnsupportedOperationException(databaseVendor + " is not supported");
        }
    }

    private static String getDatabaseVendor(Handle handle) {
        try {
            return handle.getConnection().getMetaData().getDatabaseProductName();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
