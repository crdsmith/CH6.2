package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.AbdomenWorkout;
import za.ac.cput.workoutplanapplicationrepo.repository.AbdomenWorkoutRepository;

/**
 *
 */
public class AbdomenWorkoutRepoImpl extends SQLiteOpenHelper implements AbdomenWorkoutRepository{
    public static final String TABLE_ABDOMEN_WORKOUT = "abdomenWorkout";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_ABDOMEN_W_NAME = "abdomenName";
    public static final int COLUMN_ABDOMEN_W_ID = 117;
    public static final String COLUMN_ABDOMEN_W_INFO = "abdomenInfo";
    public static final String COLUMN_ABDOMEN_W_HINT = "abdomenHint";
    public static final String  COLUMN_ABDOMEN_W_TARGET = "abdomenTarget";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_ABDOMEN_WORKOUT + "("
            + COLUMN_ABDOMEN_W_NAME + " text not null, "
            + COLUMN_ABDOMEN_W_ID + " int primary key, "
            + COLUMN_ABDOMEN_W_INFO + " text not null, "
            + COLUMN_ABDOMEN_W_HINT + " text not null, "
            + COLUMN_ABDOMEN_W_TARGET + " text not null);";


    public AbdomenWorkoutRepoImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ABDOMEN_WORKOUT);
        onCreate(db);
    }

    @Override
    public void create(AbdomenWorkout abdomenWorkout) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ABDOMEN_W_NAME, abdomenWorkout.getAbsWName());
        values.put(String.valueOf(COLUMN_ABDOMEN_W_ID), abdomenWorkout.getAbsWID());
        values.put(COLUMN_ABDOMEN_W_INFO, abdomenWorkout.getAbsWInfo());
        values.put(COLUMN_ABDOMEN_W_HINT, abdomenWorkout.getAbsWHint());
        values.put(COLUMN_ABDOMEN_W_TARGET, abdomenWorkout.getAbsWTarget());
        db.insert(TABLE_ABDOMEN_WORKOUT, null, values);

    }

    @Override
    public AbdomenWorkout find(int abdomenWID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ABDOMEN_WORKOUT, new String[]{COLUMN_ABDOMEN_W_NAME,String.valueOf(COLUMN_ABDOMEN_W_ID), COLUMN_ABDOMEN_W_INFO, COLUMN_ABDOMEN_W_HINT,COLUMN_ABDOMEN_W_TARGET},
                COLUMN_ABDOMEN_W_ID + " =?",
                new String[]{String.valueOf(abdomenWID)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        AbdomenWorkout abdomenWorkout = new AbdomenWorkout();
        abdomenWorkout.setAbsWName(cursor.getString(0));
        abdomenWorkout.setAbsWID(cursor.getInt(1));
        abdomenWorkout.setAbsWInfo(cursor.getString(2));
        abdomenWorkout.setAbsWHint(cursor.getString(3));
        abdomenWorkout.setAbsWTarget(cursor.getString(4));

        return abdomenWorkout;
    }


    @Override
    public void update(AbdomenWorkout abdomenWorkout) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ABDOMEN_W_NAME, abdomenWorkout.getAbsWName());
        values.put(COLUMN_ABDOMEN_W_INFO, abdomenWorkout.getAbsWInfo());
        values.put(COLUMN_ABDOMEN_W_HINT, abdomenWorkout.getAbsWHint());
        values.put(COLUMN_ABDOMEN_W_TARGET, abdomenWorkout.getAbsWTarget());

        db.update(TABLE_ABDOMEN_WORKOUT, values, COLUMN_ABDOMEN_W_ID + "=?",
                new String[]{String.valueOf(abdomenWorkout.getAbsWID())}
        );

    }

    @Override
    public void delete(AbdomenWorkout abdomenWorkout) {
        db.delete(TABLE_ABDOMEN_WORKOUT, COLUMN_ABDOMEN_W_ID + "=?", new String[]{String.valueOf(abdomenWorkout.getAbsWID())});

    }
}

