package za.ac.cput.workoutplanapplicationrepo.repository.Impl;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.ac.cput.workoutplanapplicationrepo.domain.User;
import za.ac.cput.workoutplanapplicationrepo.repository.UserRepository;

/**
 *
 */
public class UserRepositoryImpl extends SQLiteOpenHelper implements UserRepository{
    public static final String TABLE_USER = "user";
    public static final String DATABASE_NAME = "workoutplanapplicationrepo";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_SCREENNAME = "screenName";
    public static final String COLUMN_PASSWORD = "password";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_USER + "("
            + COLUMN_EMAIL + " text not null, "
            + COLUMN_SCREENNAME + " text unique screenName, "
            + COLUMN_PASSWORD + " text not null);";


    public UserRepositoryImpl(Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    @Override
    public void create(User user) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_SCREENNAME, user.getScreenName());
        values.put(COLUMN_PASSWORD, user.getPassword());
        db.insert(TABLE_USER, null, values);

    }

    @Override
    public User find(String screenName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[]{COLUMN_EMAIL,COLUMN_SCREENNAME,COLUMN_PASSWORD},
                COLUMN_SCREENNAME + " =?",
                new String[]{String.valueOf(screenName)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        User user = new User();
        user.setEmail(cursor.getString(0));
        user.setScreenName(cursor.getString(1));
        user.setPassword(cursor.getString(2));

        return user;
    }


    @Override
    public void update(User user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());

        db.update(TABLE_USER, values, COLUMN_SCREENNAME + "=?",
                new String[]{String.valueOf(user.getScreenName())}
        );

    }

    @Override
    public void delete(User user) {
            db.delete(TABLE_USER, COLUMN_SCREENNAME + "=?", new String[]{String.valueOf(user.getScreenName())});

    }
}
