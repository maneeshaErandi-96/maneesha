package com.example.tipd;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Target;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "hscode.db";
    public static final String TABLENAME = "hsproduct";


    public static final String col_1 = "hsCode";
    public static final String col_2 = "hsDescription";
    public static final String col_3 = "unit";
    public static final String col_4 = "vat";
    public static final String col_5 = "CustomsDuty";
    public static final String col_6 = "Surcharge";
    public static final String col_7 = "pal";
    public static final String col_8 = "ExciseDuty";
    public static final String col_9 = "RIDL";
    public static final String col_10 = "CessLevy";
    public static final String col_11 = "SRL";
    public static final String col_12 = "NBT";
    public static final String col_13 = "id";
    private final Context myContext;

    public DBHelper(Context context) {
        super(context, "hscode.db", null, 1);
        this.myContext = context;
    }

    private SQLiteDatabase myDataBase;
    private static final String DATABASE_NAME = "hscode.db";
    public final static String DATABASE_PATH = "/data/data/com.example.tipd/databases/";
    public static final int DATABASE_VERSION = 1;





    //Create a empty database on the system
    public void createDatabase() throws IOException
    {

        boolean dbExist = checkDataBase();

        if(dbExist)
        {
            Log.v("DB Exists", "db exists");
            // By calling this method here onUpgrade will be called on a
            // writeable database, but only if the version number has been
            // bumped
            //onUpgrade(myDataBase, DATABASE_VERSION_old, DATABASE_VERSION);
        }

        boolean dbExist1 = checkDataBase();
        if(!dbExist1)
        {
            this.getReadableDatabase();
            try
            {
                this.close();
                copyDataBase();
            }
            catch (IOException e)
            {
                throw new Error("Error copying database");
            }
        }

    }
    //Check database already exist or not
    private boolean checkDataBase()
    {
        boolean checkDB = false;
        try
        {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            File dbfile = new File(myPath);
            checkDB = dbfile.exists();
        }
        catch(SQLiteException e)
        {
        }
        return checkDB;
    }
    //Copies your database from your local assets-folder to the just created empty database in the system folder
    private void copyDataBase() throws IOException
    {

        InputStream mInput = myContext.getAssets().open(DATABASE_NAME);
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[2024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }
    //delete database
    public void db_delete()
    {
        File file = new File(DATABASE_PATH + DATABASE_NAME);
        if(file.exists())
        {
            file.delete();
            System.out.println("delete database file.");
        }
    }
    //Open database
    public void openDatabase() throws SQLException
    {
        String myPath = DATABASE_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void closeDataBase()throws SQLException
    {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
        {
            Log.v("Database Upgrade", "Database version higher than old.");
            db_delete();
        }

    }
    public  Boolean checkUserName(String UserName){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from login where UserName = ?",new String[] {UserName});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUserNamePassword(String UserName,String Password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from login where UserName = ? and Password= ?",new String[] {UserName,Password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;



    }



}
 /*   @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table login(UserName Text primary key, Password Text)");
        MyDB.execSQL("create Table " + TABLENAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, hsCode TEXT,hsDescription TEXT, unit TEXT, vat TEXT,CustomsDuty TEXT,Surcharge TEXT,pal TEXT,CessLevy TEXT, ExciseDuty TEXT, RIDL TEXT,SRL TEXT,NBT TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists login");
        MyDB.execSQL("drop Table if exists "+TABLENAME);
        onCreate(MyDB);
    }

    public  Boolean checkUserName(String UserName){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from login where UserName = ?",new String[] {UserName});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUserNamePassword(String UserName,String Password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from login where UserName = ? and Password= ?",new String[] {UserName,Password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;



    }
}*/
