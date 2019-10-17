package com.lemycanh.geoquiz;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GreenDaoGenerator {
    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        Schema schema = new Schema(1, "com.lemycanh.geoquiz4"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"../app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {
        Entity user = schema.addEntity("Question");
        user.addLongProperty("id").primaryKey().autoincrement();
        user.addStringProperty("content").notNull();
        user.addBooleanProperty("answer");
        return user;
    }
}
