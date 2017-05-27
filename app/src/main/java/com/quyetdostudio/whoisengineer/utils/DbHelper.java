package com.quyetdostudio.whoisengineer.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.quyetdostudio.whoisengineer.entity.Question;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by QUYET on 5/27/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private Context myContext;
    private String DB_PATH = "data/data/com.quyetdostudio.whoisengineer/databases/";
    private static String DB_NAME = "dbsqlite.db";
    private SQLiteDatabase myDataBase;

    public DbHelper(Context context) throws IOException {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
        boolean dbExist = checkDatabase();
        if (dbExist) {
            openDatabase();
        } else {
            System.out.println("Database doesn't exist");
            createDatabase();
        }
    }

    public void createDatabase() throws IOException {
        boolean dbExist = checkDatabase();
        if (dbExist) {
            //System.out.println(" Database exists.");
        } else {
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDatabase() {
        boolean checkDB = false;
        try {
            String path = DB_PATH + DB_NAME;
            File dbFile = new File(path);
            checkDB = dbFile.exists();
        } catch (SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkDB;
    }

    private void copyDatabase() throws IOException {
        //Open your local db as the input stream
        InputStream is = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream os = new FileOutputStream(outFileName);

        // transfer byte to 'is' to 'os'
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }

        //Close the streams
        os.flush();
        os.close();
        is.close();
        System.out.println("Database copy done");
    }

    public void openDatabase() throws SQLException {
        //Open the database
        String path = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if (myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Question> getQuestionList() {
        openDatabase();
        ArrayList<Question> questionList = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM questions", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Question question = new Question(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5));
            questionList.add(question);
            cursor.moveToNext();
        }
        cursor.close();
        return questionList;
    }
}
