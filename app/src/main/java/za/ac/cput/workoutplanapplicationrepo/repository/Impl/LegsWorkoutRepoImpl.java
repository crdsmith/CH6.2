package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.LegsWorkout;
import za.ac.cput.workoutplanapplicationrepo.repository.LegsWorkoutRepository;

/**
 * Created by SHiRO_333 on 2016-04-24.
 */
public class LegsWorkoutRepoImpl extends SQLiteOpenHelper implements LegsWorkoutRepository{
    public static final String TABLE_LEGS_WORKOUT = "legsWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_LEGS_W_NAME = "legsName";
    public static final int COLUMN_LEGS_W_ID = 112;
    public static final String  COLUMN_LEGS_W_INFO = "legsInfo";
    public static final String  COLUMN_LEGS_W_HINT = "legsHint";
    public static final String  COLUMN_LEGS_W_TARGET = "legsTarget";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_LEGS_WORKOUT + "("
            + COLUMN_LEGS_W_NAME + " text not null, "
            + COLUMN_LEGS_W_ID + " int primary key, "
            + COLUMN_LEGS_W_INFO + " text not null, "
            + COLUMN_LEGS_W_HINT + " text not null, "
            + COLUMN_LEGS_W_TARGET + " text not null);";


    public LegsWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEGS_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(LegsWorkout legsWorkout) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEGS_W_NAME, legsWorkout.getLegsWName());
        values.put(String.valueOf(COLUMN_LEGS_W_ID), legsWorkout.getLegsWID());
        values.put(COLUMN_LEGS_W_INFO, legsWorkout.getLegsWInfo());
        values.put(COLUMN_LEGS_W_HINT, legsWorkout.getLegsWHint());
        values.put(COLUMN_LEGS_W_TARGET, legsWorkout.getLegsWTarget());
        db.insert(TABLE_LEGS_WORKOUT, null, values);

    }

    @Override
    public LegsWorkout find(int legsWID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LEGS_WORKOUT, new String[]{COLUMN_LEGS_W_NAME,String.valueOf(COLUMN_LEGS_W_ID),COLUMN_LEGS_W_INFO,COLUMN_LEGS_W_HINT,COLUMN_LEGS_W_TARGET},
                COLUMN_LEGS_W_ID + " =?",
                new String[]{String.valueOf(legsWID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        LegsWorkout shouldersWorkout = new LegsWorkout();
        shouldersWorkout.setLegsWName(cursor.getString(0));
        shouldersWorkout.setLegsWID(cursor.getInt(1));
        shouldersWorkout.setLegsWInfo(cursor.getString(2));
        shouldersWorkout.setLegsWHint(cursor.getString(3));
        shouldersWorkout.setLegsWTarget(cursor.getString(4));

        return shouldersWorkout;
    }


    @Override
    public void update(LegsWorkout legsWorkout) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEGS_W_NAME, legsWorkout.getLegsWName());
        values.put(COLUMN_LEGS_W_INFO, legsWorkout.getLegsWInfo());
        values.put(COLUMN_LEGS_W_HINT, legsWorkout.getLegsWHint());
        values.put(COLUMN_LEGS_W_TARGET, legsWorkout.getLegsWTarget());

        db.update(TABLE_LEGS_WORKOUT, values, COLUMN_LEGS_W_ID + "=?",
                new String[]{String.valueOf(legsWorkout.getLegsWID())}
        );

    }

    @Override
    public void delete(LegsWorkout legsWorkout) {
        db.delete(TABLE_LEGS_WORKOUT, COLUMN_LEGS_W_ID + "=?", new String[]{String.valueOf(legsWorkout.getLegsWID())});

    }
}

