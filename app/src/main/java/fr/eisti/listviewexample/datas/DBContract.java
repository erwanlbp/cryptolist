package fr.eisti.listviewexample.datas;

import android.provider.BaseColumns;

public class DBContract {

    public DBContract() {
    }

    public static class Crypto implements BaseColumns {
        public static final String TABLE_NAME = "cryptomonnaies";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NAME_TYPE = "TEXT NOT NULL";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DESCRIPTION_TYPE = "TEXT NOT NULL";
    }
}
