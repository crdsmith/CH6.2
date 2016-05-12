package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.ButtocksWorkout;
import za.ac.cput.workoutplanapplicationrepo.repository.ButtocksWorkoutRepository;

/**
 * Created by SHiRO_333 on 2016-04-24.
 */
public class ButtocksWorkoutRepoImpl extends SQLiteOpenHelper implements ButtocksWorkoutRepository{
    public static final String TABLE_BUTTOCKS_WORKOUT = "buttocksWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_BUTTOCKS_W_NAME = "buttocksName";
    public static final int COLUMN_BUTTOCKS_W_ID = 114;
    public static final String COLUMN_BUTTOCKS_W_INFO = "buttocksInfo";
    public static final String COLUMN_BUTTOCKS_W_HINT = "buttocksHint";
    public static final String COLUMN_BUTTOCKS_W_TARGET = "buttocksTarget";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_BUTTOCKS_WORKOUT + "("
            + COLUMN_BUTTOCKS_W_NAME + " text not null, "
            + COLUMN_BUTTOCKS_W_ID + " int primary key, "
            + COLUMN_BUTTOCKS_W_INFO + " text not null, "
            + COLUMN_BUTTOCKS_W_HINT + " text not null, "
            + COLUMN_BUTTOCKS_W_TARGET + " text not null);";


    public ButtocksWorkoutRepoImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open() throws SQLException
    {
        db = this.getWritableDatabase();
    }

    public void close()
    {
        this.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUTTOCKS_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(ButtocksWorkout buttocksWorkout) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BUTTOCKS_W_NAME, buttocksWorkout.getButtocksWName());
        values.put(String.valueOf(COLUMN_BUTTOCKS_W_ID), buttocksWorkout.getButtocksWID());
        values.put(COLUMN_BUTTOCKS_W_INFO, buttocksWorkout.getButtocksWInfo());
        values.put(COLUMN_BUTTOCKS_W_HINT, buttocksWorkout.getButtocksWHint());
        values.put(COLUMN_BUTTOCKS_W_TARGET, buttocksWorkout.getButtocksWTarget());
        db.insert(TABLE_BUTTOCKS_WORKOUT, null, values);

    }

    @Override
    public ButtocksWorkout find(int buttocksWID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BUTTOCKS_WORKOUT, new String[]{COLUMN_BUTTOCKS_W_NAME,String.valueOf(COLUMN_BUTTOCKS_W_ID), COLUMN_BUTTOCKS_W_INFO, COLUMN_BUTTOCKS_W_HINT, COLUMN_BUTTOCKS_W_TARGET},
                COLUMN_BUTTOCKS_W_ID + " =?",
                new String[]{String.valueOf(buttocksWID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        ButtocksWorkout buttocksWorkout = new ButtocksWorkout();
        buttocksWorkout.setButtocksWName(cursor.getString(0));
        buttocksWorkout.setButtocksWID(cursor.getInt(1));
        buttocksWorkout.setButtocksWInfo(cursor.getString(2));
        buttocksWorkout.setButtocksWHint(cursor.getString(3));
        buttocksWorkout.setButtocksWTarget(cursor.getString(4));

        return buttocksWorkout;
    }


    @Override
    public void update(ButtocksWorkout buttocksWorkout) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_BUTTOCKS_W_NAME, buttocksWorkout.getButtocksWName());
        values.put(COLUMN_BUTTOCKS_W_INFO, buttocksWorkout.getButtocksWInfo());
        values.put(COLUMN_BUTTOCKS_W_HINT, buttocksWorkout.getButtocksWHint());
        values.put(COLUMN_BUTTOCKS_W_TARGET, buttocksWorkout.getButtocksWTarget());

        db.update(TABLE_BUTTOCKS_WORKOUT, values, COLUMN_BUTTOCKS_W_ID + "=?",
                new String[]{String.valueOf(buttocksWorkout.getButtocksWID())}
        );

    }

    @Override
    public void delete(ButtocksWorkout buttocksWorkout) {
        db.delete(TABLE_BUTTOCKS_WORKOUT, COLUMN_BUTTOCKS_W_ID + "=?", new String[]{String.valueOf(buttocksWorkout.getButtocksWID())});

    }
}

