package fr.eisti.listviewexample.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.eisti.listviewexample.Cryptomonnaie;
import fr.eisti.listviewexample.DB.DBContract;
import fr.eisti.listviewexample.DB.MySQL;

public class DBProvider {

    private MySQL helper;

    public DBProvider() {
    }

    private SQLiteDatabase getReadableDB(Context context) {
        this.helper = new MySQL(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        return db;
    }

    private SQLiteDatabase getWritalbeDB(Context context) {
        this.helper = new MySQL(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        return db;
    }

    public List<Cryptomonnaie> selectCryptoList(Context context) {
        List<Cryptomonnaie> cryptomonnaieList = new ArrayList<>();

        SQLiteDatabase db = getReadableDB(context);
        Cursor cursor = db.query(DBContract.Crypto.TABLE_NAME, new String[]{DBContract.Crypto.COLUMN_NAME, DBContract.Crypto.COLUMN_DESCRIPTION}, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Cryptomonnaie cryptomonnaie = new Cryptomonnaie(cursor.getString(1), cursor.getString(2));
            cryptomonnaieList.add(cryptomonnaie);
            cursor.moveToNext();
        }
        cursor.close();
        this.helper.close();
        return cryptomonnaieList;
    }

    public Cryptomonnaie selectCryptoDetail(Context context, String name) {
        Cryptomonnaie cryptomonnaie = new Cryptomonnaie();

        SQLiteDatabase db = getReadableDB(context);
        Cursor cursor = db.query(DBContract.Crypto.TABLE_NAME, new String[]{DBContract.Crypto.COLUMN_DESCRIPTION}, "name = " + name, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cryptomonnaie.setName(cursor.getString(1));
            cryptomonnaie.setName(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        this.helper.close();
        return cryptomonnaie;
    }

    public int selectCryptoID(Context context, String name) {
        int cryptoID = Integer.parseInt(null);

        SQLiteDatabase db = getReadableDB(context);
        Cursor cursor = db.query(DBContract.Crypto.TABLE_NAME, new String[]{"_ID"}, "name = " + name, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cryptoID = Integer.parseInt(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        this.helper.close();
        return cryptoID;
    }

    public void deleteCryptomonnaie(Context context, String name) {
        int cryptoID = selectCryptoID(context, name);

        SQLiteDatabase db = getWritalbeDB(context);
        db.delete(DBContract.Crypto.TABLE_NAME, "_ID = ?", new String[]{String.valueOf(cryptoID)});
        this.helper.close();
    }

    public void updateCryptomonnaie(Context context, String currentName, String newName, String newDescription) {
        int cryptoID = selectCryptoID(context, currentName);

        SQLiteDatabase db = getWritalbeDB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", newName);
        contentValues.put("description", newDescription);
        db.update(DBContract.Crypto.TABLE_NAME, contentValues, "_ID=?", new String[]{String.valueOf(cryptoID)});
        db.delete(DBContract.Crypto.TABLE_NAME, "_ID=?", new String[]{String.valueOf(cryptoID)});
        this.helper.close();
    }

    public int addCryptomonnaie(Context context, Cryptomonnaie cryptomonnaie) {
        SQLiteDatabase db = getWritalbeDB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", cryptomonnaie.getName());
        contentValues.put("description", cryptomonnaie.getDescription());
        int id = (int) db.insert(DBContract.Crypto.TABLE_NAME, null, contentValues);
        this.helper.close();

        return id;
    }


}
