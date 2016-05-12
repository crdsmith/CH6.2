package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.ShouldersWorkout;
import za.ac.cput.workoutplanapplicationrepo.repository.ShouldersWorkoutRepository;

/**
 *
 */
public class ShoulderWorkoutRepoImpl extends SQLiteOpenHelper implements ShouldersWorkoutRepository{
    public static final String TABLE_SHOULDERS_WORKOUT = "shouldersWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_SHOULDERS_W_NAME = "shouldersName";
    public static final int COLUMN_SHOULDERS_W_ID = 111;
    public static final String  COLUMN_SHOULDERS_W_INFO = "shouldersInfo";
    public static final String  COLUMN_SHOULDERS_W_HINT = "shouldersHint";
    public static final String  COLUMN_SHOULDERS_W_TARGET = "shouldersTarget";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_SHOULDERS_WORKOUT + "("
            + COLUMN_SHOULDERS_W_NAME + " text not null, "
            + COLUMN_SHOULDERS_W_ID + " int primary key, "
            + COLUMN_SHOULDERS_W_INFO + " text not null, "
            + COLUMN_SHOULDERS_W_HINT + " text not null, "
            + COLUMN_SHOULDERS_W_TARGET + " text not null);";


    public ShoulderWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOULDERS_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(ShouldersWorkout shouldersWorkout) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SHOULDERS_W_NAME, shouldersWorkout.getShouldersWName());
        values.put(String.valueOf(COLUMN_SHOULDERS_W_ID), shouldersWorkout.getShouldersWID());
        values.put(COLUMN_SHOULDERS_W_INFO, shouldersWorkout.getShouldersWInfo());
        values.put(COLUMN_SHOULDERS_W_HINT, shouldersWorkout.getShouldersWHint());
        values.put(COLUMN_SHOULDERS_W_TARGET, shouldersWorkout.getShouldersWTarget());
        db.insert(TABLE_SHOULDERS_WORKOUT, null, values);

    }

    @Override
    public ShouldersWorkout find(int shouldersWID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_SHOULDERS_WORKOUT, new String[]{COLUMN_SHOULDERS_W_NAME,String.valueOf(COLUMN_SHOULDERS_W_ID),COLUMN_SHOULDERS_W_INFO,COLUMN_SHOULDERS_W_HINT,COLUMN_SHOULDERS_W_TARGET},
                COLUMN_SHOULDERS_W_ID + " =?",
                new String[]{String.valueOf(shouldersWID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        ShouldersWorkout shouldersWorkout = new ShouldersWorkout();
        shouldersWorkout.setShouldersWName(cursor.getString(0));
        shouldersWorkout.setShouldersWID(cursor.getInt(1));
        shouldersWorkout.setShouldersWInfo(cursor.getString(2));
        shouldersWorkout.setShouldersWHint(cursor.getString(3));
        shouldersWorkout.setShouldersWTarget(cursor.getString(4));

        return shouldersWorkout;
    }


    @Override
    public void update(ShouldersWorkout shouldersWorkout) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SHOULDERS_W_NAME, shouldersWorkout.getShouldersWName());
        values.put(COLUMN_SHOULDERS_W_INFO, shouldersWorkout.getShouldersWInfo());
        values.put(COLUMN_SHOULDERS_W_HINT, shouldersWorkout.getShouldersWHint());
        values.put(COLUMN_SHOULDERS_W_TARGET, shouldersWorkout.getShouldersWTarget());

        db.update(TABLE_SHOULDERS_WORKOUT, values, COLUMN_SHOULDERS_W_ID + "=?",
                new String[]{String.valueOf(shouldersWorkout.getShouldersWID())}
        );

    }

    @Override
    public void delete(ShouldersWorkout shouldersWorkout) {
        db.delete(TABLE_SHOULDERS_WORKOUT, COLUMN_SHOULDERS_W_ID + "=?", new String[]{String.valueOf(shouldersWorkout.getShouldersWID())});

    }
}

