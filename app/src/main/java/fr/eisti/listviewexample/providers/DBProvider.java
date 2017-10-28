package fr.eisti.listviewexample.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.datas.DBContract;
import fr.eisti.listviewexample.datas.MySQL;

public class DBProvider {

    private MySQL helper;

    public DBProvider() {
    }

    private SQLiteDatabase getReadableDB(Context context) {
        this.helper = new MySQL(context);
        return helper.getReadableDatabase();
    }

    private SQLiteDatabase getWritalbeDB(Context context) {
        this.helper = new MySQL(context);
        return helper.getWritableDatabase();
    }

    public List<Cryptomonnaie> selectCryptoList(Context context) {
        List<Cryptomonnaie> cryptomonnaieList = new ArrayList<>();

        SQLiteDatabase db = getReadableDB(context);
        Cursor cursor = db.query(DBContract.Crypto.TABLE_NAME, new String[]{"_ID", DBContract.Crypto.COLUMN_NAME, DBContract.Crypto.COLUMN_DESCRIPTION}, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Cryptomonnaie cryptomonnaie = new Cryptomonnaie(Integer.parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3));
            cryptomonnaieList.add(cryptomonnaie);
            cursor.moveToNext();
        }
        cursor.close();
        this.helper.close();
        return cryptomonnaieList;
    }

    public Cryptomonnaie selectCryptoDetail(Context context, long ID) {
        Cryptomonnaie cryptomonnaie = new Cryptomonnaie();

        SQLiteDatabase db = getReadableDB(context);
        Cursor cursor = db.query(DBContract.Crypto.TABLE_NAME, new String[]{DBContract.Crypto.COLUMN_DESCRIPTION}, "_ID = " + ID, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cryptomonnaie.setDescription(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        this.helper.close();
        return cryptomonnaie;
    }

    public void deleteCryptomonnaie(Context context, long ID) {
        SQLiteDatabase db = getWritalbeDB(context);
        db.delete(DBContract.Crypto.TABLE_NAME, "_ID = ?", new String[]{String.valueOf(ID)});
        this.helper.close();
    }

    public void updateCryptomonnaie(Context context, long ID, String newName, String newDescription) {
        SQLiteDatabase db = getWritalbeDB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", newName);
        contentValues.put("description", newDescription);
        db.update(DBContract.Crypto.TABLE_NAME, contentValues, "_ID=?", new String[]{String.valueOf(ID)});
        db.delete(DBContract.Crypto.TABLE_NAME, "_ID=?", new String[]{String.valueOf(ID)});
        this.helper.close();
    }

    public long addCryptomonnaie(Context context, Cryptomonnaie cryptomonnaie) {
        SQLiteDatabase db = getWritalbeDB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", cryptomonnaie.getName());
        contentValues.put("description", cryptomonnaie.getDescription());
        long id = db.insert(DBContract.Crypto.TABLE_NAME, null, contentValues);
        this.helper.close();

        return id;
    }


}
