package fr.eisti.listviewexample.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQL extends SQLiteOpenHelper {

    private static final String CREATE_DB = "CREATE TABLE " +
            DBContract.Crypto.TABLE_NAME +
            "(" + DBContract.Crypto._ID + " INTEGER PRIMARY KEY," +
            DBContract.Crypto.COLUMN_NAME + DBContract.Crypto.COLUMN_NAME_TYPE +
            DBContract.Crypto.COLUMN_DESCRIPTION + DBContract.Crypto.COLUMN_DESCRIPTION_TYPE +
            ")";
    private static final String DELETE_DB = "DROP TABLE IF EXISTS " + DBContract.Crypto.TABLE_NAME;
    private static final String NAME_DB = "CryptoDB";
    private static final int VERSION_DB = 1;

    public MySQL(Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_DB);
        onCreate(sqLiteDatabase);
    }
}
