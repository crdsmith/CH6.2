package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.BackWorkout;
import za.ac.cput.workoutplanapplicationrepo.repository.BackWorkoutRepository;

/**
 * Created by SHiRO_333 on 2016-04-24.
 */
public class BackWorkoutRepoImpl extends SQLiteOpenHelper implements BackWorkoutRepository{
    public static final String TABLE_BACK_WORKOUT = "backWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_BACK_W_NAME = "backName";
    public static final int COLUMN_BACK_W_ID = 115;
    public static final String COLUMN_BACK_W_INFO = "backInfo";
    public static final String COLUMN_BACK_W_HINT = "backHint";
    public static final String COLUMN_BACK_W_TARGET = "backTarget";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_BACK_WORKOUT + "("
            + COLUMN_BACK_W_NAME + " text not null, "
            + COLUMN_BACK_W_ID + " int primary key, "
            + COLUMN_BACK_W_INFO + " text not null, "
            + COLUMN_BACK_W_HINT + " text not null, "
            + COLUMN_BACK_W_TARGET + " text not null);";


    public BackWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BACK_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(BackWorkout backWorkout) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BACK_W_NAME, backWorkout.getBackWName());
        values.put(String.valueOf(COLUMN_BACK_W_ID), backWorkout.getBackWID());
        values.put(COLUMN_BACK_W_INFO, backWorkout.getBackWInfo());
        values.put(COLUMN_BACK_W_HINT, backWorkout.getBackWHint());
        values.put(COLUMN_BACK_W_TARGET, backWorkout.getBackWTarget());
        db.insert(TABLE_BACK_WORKOUT, null, values);

    }

    @Override
    public BackWorkout find(int backWID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BACK_WORKOUT, new String[]{COLUMN_BACK_W_NAME,String.valueOf(COLUMN_BACK_W_ID), COLUMN_BACK_W_INFO, COLUMN_BACK_W_HINT, COLUMN_BACK_W_TARGET},
                COLUMN_BACK_W_ID + " =?",
                new String[]{String.valueOf(backWID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        BackWorkout backWorkout = new BackWorkout();
        backWorkout.setBackWName(cursor.getString(0));
        backWorkout.setBackWID(cursor.getInt(1));
        backWorkout.setBackWInfo(cursor.getString(2));
        backWorkout.setBackWHint(cursor.getString(3));
        backWorkout.setBackWTarget(cursor.getString(4));

        return backWorkout;
    }


    @Override
    public void update(BackWorkout backWorkout) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_BACK_W_NAME, backWorkout.getBackWName());
        values.put(COLUMN_BACK_W_INFO, backWorkout.getBackWInfo());
        values.put(COLUMN_BACK_W_HINT, backWorkout.getBackWHint());
        values.put(COLUMN_BACK_W_TARGET, backWorkout.getBackWTarget());

        db.update(TABLE_BACK_WORKOUT, values, COLUMN_BACK_W_ID + "=?",
                new String[]{String.valueOf(backWorkout.getBackWID())}
        );

    }

    @Override
    public void delete(BackWorkout backWorkout) {
        db.delete(TABLE_BACK_WORKOUT, COLUMN_BACK_W_ID + "=?", new String[]{String.valueOf(backWorkout.getBackWID())});

    }
}

