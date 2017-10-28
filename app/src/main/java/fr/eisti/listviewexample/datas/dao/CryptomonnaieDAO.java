package fr.eisti.listviewexample.datas.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.eisti.listviewexample.datas.Cryptomonnaie;
import fr.eisti.listviewexample.datas.DBContract;
import fr.eisti.listviewexample.datas.MySQLHelper;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ErwanLBP on 28/10/17.
 */

public class CryptomonnaieDAO {

    public static List<Cryptomonnaie> findAll(MySQLHelper helper) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DBContract.Crypto.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();

        List<Cryptomonnaie> resList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            resList.add(new Cryptomonnaie(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return resList;
    }

    public static Cryptomonnaie find(SQLiteOpenHelper helper, long id) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DBContract.Crypto.TABLE_NAME, null, DBContract.Crypto._ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor.getCount() < 1) {
            return null;
        }
        cursor.moveToFirst();
        Cryptomonnaie res = new Cryptomonnaie(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        cursor.close();

        return res;
    }

    public static Cryptomonnaie insert(SQLiteOpenHelper helper, Cryptomonnaie cryptomonnaie) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.Crypto.COLUMN_NAME, cryptomonnaie.getName());
        contentValues.put(DBContract.Crypto.COLUMN_DESCRIPTION, cryptomonnaie.getDescription());

        int id = (int) db.insert(DBContract.Crypto.TABLE_NAME, null, contentValues);
        if (id == -1) {
            return null;
        }

        cryptomonnaie.setID(id);
        return cryptomonnaie;
    }

    public static boolean delete(SQLiteOpenHelper helper, Cryptomonnaie cryptomonnaie) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int nbDel = db.delete(DBContract.Crypto.TABLE_NAME, DBContract.Crypto._ID + " = ?", new String[]{String.valueOf(cryptomonnaie.getID())});
        return nbDel >= 1;
    }

    public static boolean update(SQLiteOpenHelper helper, Cryptomonnaie cryptomonnaie) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.Crypto.COLUMN_NAME, cryptomonnaie.getName());
        values.put(DBContract.Crypto.COLUMN_DESCRIPTION, cryptomonnaie.getDescription());

        int nbUpdated = db.update(DBContract.Crypto.TABLE_NAME, values, DBContract.Crypto._ID + " = ?", new String[]{String.valueOf(cryptomonnaie.getID())});
        return nbUpdated >= 1;
    }
}
