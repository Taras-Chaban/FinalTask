package com.finalTask.tsk.DB;

public class DBManager {

    private static DBManager instance;

    private DBManager() {}


    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }
}
