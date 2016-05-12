package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.GeneratedWorkoutSchedule;
import za.ac.cput.workoutplanapplicationrepo.repository.GeneratedWorkoutRepository;

/**
 * Created by SHiRO_333 on 2016-04-24.
 */
public class GeneratedWorkoutRepoImpl extends SQLiteOpenHelper implements GeneratedWorkoutRepository{
    public static final String TABLE_GENERATED_WORKOUT = "generatedWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final int COLUMN_GEN_NUM_CYCLES = 4;
    public static final int COLUMN_GEN_ID = 1112;
    public static final int COLUMN_GEN_CYCLE_ITERATION = 2;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_GENERATED_WORKOUT + "("
            + COLUMN_GEN_NUM_CYCLES + " int not null, "
            + COLUMN_GEN_ID + " int primary key, "
            + COLUMN_GEN_CYCLE_ITERATION + " int not null);";


    public GeneratedWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GENERATED_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(GeneratedWorkoutSchedule generatedWorkoutSchedule) {
        open();
        ContentValues values = new ContentValues();
        values.put(String.valueOf(COLUMN_GEN_NUM_CYCLES), generatedWorkoutSchedule.getGenNumberOfCycles());
        values.put(String.valueOf(COLUMN_GEN_ID), generatedWorkoutSchedule.getGenScheduleID());
        values.put(String.valueOf(COLUMN_GEN_CYCLE_ITERATION), generatedWorkoutSchedule.getGenCycleIteration());
        db.insert(TABLE_GENERATED_WORKOUT, null, values);

    }

    @Override
    public GeneratedWorkoutSchedule find(int genScheduleID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_GENERATED_WORKOUT, new String[]{String.valueOf(COLUMN_GEN_NUM_CYCLES),String.valueOf(COLUMN_GEN_ID),String.valueOf(COLUMN_GEN_CYCLE_ITERATION)},
                COLUMN_GEN_ID + " =?",
                new String[]{String.valueOf(genScheduleID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        GeneratedWorkoutSchedule generatedWorkoutSchedule = new GeneratedWorkoutSchedule();
        generatedWorkoutSchedule.setGenNumberOfCycles(cursor.getInt(0));
        generatedWorkoutSchedule.setGenScheduleID(cursor.getInt(1));
        generatedWorkoutSchedule.setGenCycleIteration(cursor.getInt(2));
        return generatedWorkoutSchedule;
    }


    @Override
    public void update(GeneratedWorkoutSchedule generatedWorkoutSchedule) {
        ContentValues values = new ContentValues();
        values.put(String.valueOf(COLUMN_GEN_NUM_CYCLES), generatedWorkoutSchedule.getGenNumberOfCycles());
        values.put(String.valueOf(COLUMN_GEN_CYCLE_ITERATION), generatedWorkoutSchedule.getGenCycleIteration());

        db.update(TABLE_GENERATED_WORKOUT, values, COLUMN_GEN_ID + "=?",
                new String[]{String.valueOf(generatedWorkoutSchedule.getGenScheduleID())}
        );

    }

    @Override
    public void delete(GeneratedWorkoutSchedule generatedWorkoutSchedule) {
        db.delete(TABLE_GENERATED_WORKOUT, COLUMN_GEN_ID + "=?", new String[]{String.valueOf(generatedWorkoutSchedule.getGenScheduleID())});

    }
}

