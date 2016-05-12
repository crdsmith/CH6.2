package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.ChestWorkout;
import za.ac.cput.workoutplanapplicationrepo.repository.ChestWorkoutRepository;

/**
 * Created by SHiRO_333 on 2016-04-24.
 */
public class ChestWorkoutRepoImpl extends SQLiteOpenHelper implements ChestWorkoutRepository{
    public static final String TABLE_CHEST_WORKOUT = "chestWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_CHEST_W_NAME = "chestName";
    public static final int COLUMN_CHEST_W_ID = 113;
    public static final String COLUMN_CHEST_W_INFO = "chestInfo";
    public static final String COLUMN_CHEST_W_HINT = "chestHint";
    public static final String COLUMN_CHEST_W_TARGET = "chestTarget";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_CHEST_WORKOUT + "("
            + COLUMN_CHEST_W_NAME + " text not null, "
            + COLUMN_CHEST_W_ID + " int primary key, "
            + COLUMN_CHEST_W_INFO + " text not null, "
            + COLUMN_CHEST_W_HINT + " text not null, "
            + COLUMN_CHEST_W_TARGET + " text not null);";


    public ChestWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHEST_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(ChestWorkout chestWorkout) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CHEST_W_NAME, chestWorkout.getChestWName());
        values.put(String.valueOf(COLUMN_CHEST_W_ID), chestWorkout.getChestWHint());
        values.put(COLUMN_CHEST_W_INFO, chestWorkout.getChestWInfo());
        values.put(COLUMN_CHEST_W_HINT, chestWorkout.getChestWHint());
        values.put(COLUMN_CHEST_W_TARGET, chestWorkout.getChestWTarget());
        db.insert(TABLE_CHEST_WORKOUT, null, values);

    }

    @Override
    public ChestWorkout find(int chestWID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CHEST_WORKOUT, new String[]{COLUMN_CHEST_W_NAME,String.valueOf(COLUMN_CHEST_W_ID), COLUMN_CHEST_W_INFO, COLUMN_CHEST_W_HINT, COLUMN_CHEST_W_TARGET},
                COLUMN_CHEST_W_ID + " =?",
                new String[]{String.valueOf(chestWID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        ChestWorkout chestWorkout = new ChestWorkout();
        chestWorkout.setChestWName(cursor.getString(0));
        chestWorkout.setChestWID(cursor.getInt(1));
        chestWorkout.setChestWInfo(cursor.getString(2));
        chestWorkout.setChestWHint(cursor.getString(3));
        chestWorkout.setChestWTarget(cursor.getString(4));

        return chestWorkout;
    }


    @Override
    public void update(ChestWorkout chestWorkout) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CHEST_W_NAME, chestWorkout.getChestWName());
        values.put(COLUMN_CHEST_W_INFO, chestWorkout.getChestWInfo());
        values.put(COLUMN_CHEST_W_HINT, chestWorkout.getChestWHint());
        values.put(COLUMN_CHEST_W_TARGET, chestWorkout.getChestWTarget());

        db.update(TABLE_CHEST_WORKOUT, values, COLUMN_CHEST_W_ID + "=?",
                new String[]{String.valueOf(chestWorkout.getChestWID())}
        );

    }

    @Override
    public void delete(ChestWorkout chestWorkout) {
        db.delete(TABLE_CHEST_WORKOUT, COLUMN_CHEST_W_ID + "=?", new String[]{String.valueOf(chestWorkout.getChestWID())});

    }
}

