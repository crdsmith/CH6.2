package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.CustomWorkoutSchedule;
import za.ac.cput.workoutplanapplicationrepo.repository.CustomWorkoutRepository;

/**
 * Created by SHiRO_333 on 2016-04-24.
 */
public class CustomWorkoutRepoImpl extends SQLiteOpenHelper implements CustomWorkoutRepository{
    public static final String TABLE_CUSTOM_WORKOUT = "customWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final int COLUMN_CUST_NUM_CYCLES = 5;
    public static final boolean COLUMN_RANDOM = true;
    public static final int COLUMN_CUST_ID = 1111;
    public static final int COLUMN_CUST_CYCLE_ITERATION = 3;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_CUSTOM_WORKOUT + "("
            + COLUMN_CUST_NUM_CYCLES + " int not null, "
            + COLUMN_RANDOM + " boolean not null, "
            + COLUMN_CUST_ID + " int primary key, "
            + COLUMN_CUST_CYCLE_ITERATION + " int not null);";


    public CustomWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOM_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(CustomWorkoutSchedule customWorkoutSchedule) {
        open();
        ContentValues values = new ContentValues();
        values.put(String.valueOf(COLUMN_CUST_NUM_CYCLES), customWorkoutSchedule.getCustNumberOfCycles());
        values.put(String.valueOf(COLUMN_RANDOM), customWorkoutSchedule.isRandomWorkout());
        values.put(String.valueOf(COLUMN_CUST_ID), customWorkoutSchedule.getCustScheduleID());
        values.put(String.valueOf(COLUMN_CUST_CYCLE_ITERATION), customWorkoutSchedule.getCustCycleIteration());
        db.insert(TABLE_CUSTOM_WORKOUT, null, values);

    }

    @Override
    public CustomWorkoutSchedule find(int custScheduleID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CUSTOM_WORKOUT, new String[]{String.valueOf(COLUMN_CUST_NUM_CYCLES),String.valueOf(COLUMN_RANDOM),String.valueOf(COLUMN_CUST_ID),String.valueOf(COLUMN_CUST_CYCLE_ITERATION)},
                COLUMN_CUST_ID + " =?",
                new String[]{String.valueOf(custScheduleID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        CustomWorkoutSchedule customWorkoutSchedule = new CustomWorkoutSchedule();
        customWorkoutSchedule.setCustNumberOfCycles(cursor.getInt(0));
        customWorkoutSchedule.setRandomWorkout(cursor.getInt(1));
        customWorkoutSchedule.setCustScheduleID(cursor.getInt(2));
        customWorkoutSchedule.setCustCycleIteration(cursor.getInt(3));
        return customWorkoutSchedule;
    }


    @Override
    public void update(CustomWorkoutSchedule customWorkoutSchedule) {
        ContentValues values = new ContentValues();
        values.put(String.valueOf(COLUMN_CUST_NUM_CYCLES), customWorkoutSchedule.getCustNumberOfCycles());
        values.put(String.valueOf(COLUMN_RANDOM), customWorkoutSchedule.isRandomWorkout());
        values.put(String.valueOf(COLUMN_CUST_CYCLE_ITERATION), customWorkoutSchedule.getCustCycleIteration());

        db.update(TABLE_CUSTOM_WORKOUT, values, COLUMN_CUST_ID + "=?",
                new String[]{String.valueOf(customWorkoutSchedule.getCustScheduleID())}
        );

    }

    @Override
    public void delete(CustomWorkoutSchedule customWorkoutSchedule) {
        db.delete(TABLE_CUSTOM_WORKOUT, COLUMN_CUST_ID + "=?", new String[]{String.valueOf(customWorkoutSchedule.getCustScheduleID())});

    }
}

