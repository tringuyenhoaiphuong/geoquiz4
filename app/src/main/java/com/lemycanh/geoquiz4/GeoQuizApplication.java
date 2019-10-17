package com.lemycanh.geoquiz4;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by lemycanh on 17/10/2019.
 */

public class GeoQuizApplication extends Application {
    private DaoSession daoSession;
    private static GeoQuizApplication _instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"users-db"); //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static GeoQuizApplication Instance() {
        return _instance;
    }
}
