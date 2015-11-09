package org.robovm.store.service;

import junit.framework.Assert;
import org.junit.Test;
import org.robovm.store.model.db.CountryEntity;
import org.roylance.yaorm.services.IConnectionSourceFactory;
import org.roylance.yaorm.services.IGranularDatabaseService;
import org.roylance.yaorm.services.ISqlGeneratorService;
import org.roylance.yaorm.services.jdbc.JDBCGranularDatabaseService;
import org.roylance.yaorm.services.sqlite.SQLiteConnectionSourceFactory;
import org.roylance.yaorm.services.sqlite.SQLiteGeneratorService;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StoreContextTest {
    @Test
    public void simpleInstantiateTest() throws Exception {
        // arrange
        // create a unique file
        final File databaseFile = new File(UUID.randomUUID().toString().replace("-", ""));

        final IConnectionSourceFactory sourceConnection = new SQLiteConnectionSourceFactory(databaseFile.getAbsolutePath());
        final IGranularDatabaseService granularDatabaseService = new JDBCGranularDatabaseService(sourceConnection.getConnectionSource(), false);

        try  {
            final ISqlGeneratorService sqlGeneratorService = new SQLiteGeneratorService();
            final StoreContext storeContext = StoreContext.factory(sqlGeneratorService, granularDatabaseService);

            storeContext.handleMigrations(0);

            final CountryEntity utahCountryState = new CountryEntity();
            utahCountryState.setCode("US");
            utahCountryState.setName("US");
            utahCountryState.setState("UT");

            final CountryEntity caliCountryState = new CountryEntity();
            caliCountryState.setCode("US");
            caliCountryState.setName("US");
            caliCountryState.setState("CA");

            final List<CountryEntity> insertList = new ArrayList<>();
            insertList.add(utahCountryState);
            insertList.add(caliCountryState);

            storeContext.getCountryService().bulkInsert(insertList);

            // act
            final List<CountryEntity> savedCountryEntities = storeContext.getCountryService().getAll();

            // assert
            Assert.assertEquals(2, savedCountryEntities.size());

        }
        finally {
            granularDatabaseService.close();

            // clean up after ourselves
            databaseFile.delete();
        }
    }
}
