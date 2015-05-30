package com.ocr.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.ocr.LogUtils;

public class DataBaseHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static String DATABASE_NAME = "ocrdatabse";
	private String TABLE_TEXT = "texttable";
	private String KEY_ID = "_id";
	private String TEXT = "text";
	private String TIME = "time";
	private String CREATE_TABLE_TEXT = "CREATE TABLE IF NOT EXISTS " + TABLE_TEXT + "(" + KEY_ID + " integer primary key autoincrement," + TEXT + " TEXT," + TIME + " TEXT" + ");";

	private SQLiteDatabase db;

	public DataBaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_TEXT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public void insertText(ContentValues cv) {
		db = this.getWritableDatabase();
		db.insert(TABLE_TEXT, null, cv);
		db.close();
	}

	public Cursor retrieveText() {
		db = this.getReadableDatabase();
		Cursor mCursor = db.query(TABLE_TEXT, null, null, null, null, null, null);
		return mCursor;
	}

	public void delete(String id) {
		db = this.getWritableDatabase();
		int i = db.delete(TABLE_TEXT, KEY_ID + " = ?", new String[] { id });
		LogUtils.infoMsg("deleted Count" + i);
		db.close();
	}
}
