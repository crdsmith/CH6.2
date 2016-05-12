package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.ArmsWorkout;
import za.ac.cput.workoutplanapplicationrepo.repository.ArmsWorkoutRepository;

/**
 * Created by SHiRO_333 on 2016-04-24.
 */
public class ArmsWorkoutRepoImpl extends SQLiteOpenHelper implements ArmsWorkoutRepository{
    public static final String TABLE_ARMS_WORKOUT = "armsWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_ARMS_W_NAME = "armsName";
    public static final int COLUMN_ARMS_W_ID = 116;
    public static final String COLUMN_ARMS_W_INFO = "armsInfo";
    public static final String COLUMN_ARMS_W_HINT = "armsHint";
    public static final String COLUMN_ARMS_W_TARGET = "armsTarget";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_ARMS_WORKOUT + "("
            + COLUMN_ARMS_W_NAME + " text not null, "
            + COLUMN_ARMS_W_ID + " int primary key, "
            + COLUMN_ARMS_W_INFO + " text not null, "
            + COLUMN_ARMS_W_HINT + " text not null, "
            + COLUMN_ARMS_W_TARGET + " text not null);";


    public ArmsWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARMS_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(ArmsWorkout armsWorkout) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ARMS_W_NAME, armsWorkout.getArmsWName());
        values.put(String.valueOf(COLUMN_ARMS_W_ID), armsWorkout.getArmsWID());
        values.put(COLUMN_ARMS_W_INFO, armsWorkout.getArmsWInfo());
        values.put(COLUMN_ARMS_W_HINT, armsWorkout.getArmsWHint());
        values.put(COLUMN_ARMS_W_TARGET, armsWorkout.getArmsWTarget());
        db.insert(TABLE_ARMS_WORKOUT, null, values);

    }

    @Override
    public ArmsWorkout find(int armsWID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ARMS_WORKOUT, new String[]{COLUMN_ARMS_W_NAME,String.valueOf(COLUMN_ARMS_W_ID), COLUMN_ARMS_W_INFO, COLUMN_ARMS_W_HINT, COLUMN_ARMS_W_TARGET},
                COLUMN_ARMS_W_ID + " =?",
                new String[]{String.valueOf(armsWID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        ArmsWorkout armsWorkout = new ArmsWorkout();
        armsWorkout.setArmsWName(cursor.getString(0));
        armsWorkout.setArmsWID(cursor.getInt(1));
        armsWorkout.setArmsWInfo(cursor.getString(2));
        armsWorkout.setArmsWHint(cursor.getString(3));
        armsWorkout.setArmsWTarget(cursor.getString(4));

        return armsWorkout;
    }


    @Override
    public void update(ArmsWorkout armsWorkout) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ARMS_W_NAME, armsWorkout.getArmsWName());
        values.put(COLUMN_ARMS_W_INFO, armsWorkout.getArmsWInfo());
        values.put(COLUMN_ARMS_W_HINT, armsWorkout.getArmsWHint());
        values.put(COLUMN_ARMS_W_TARGET, armsWorkout.getArmsWTarget());

        db.update(TABLE_ARMS_WORKOUT, values, COLUMN_ARMS_W_ID + "=?",
                new String[]{String.valueOf(armsWorkout.getArmsWID())}
        );

    }

    @Override
    public void delete(ArmsWorkout armsWorkout) {
        db.delete(TABLE_ARMS_WORKOUT, COLUMN_ARMS_W_ID + "=?", new String[]{String.valueOf(armsWorkout.getArmsWID())});

    }
}

