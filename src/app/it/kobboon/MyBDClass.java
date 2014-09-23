package app.it.kobboon;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyBDClass extends SQLiteOpenHelper {
	String strName, string;
	private static final String DATABASE_NAME = "mydata075";
	private static final String TABLE_MEMBER = "numbers";
	private static final int DATABASE_VERSION = 1;

	public MyBDClass(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE  " + TABLE_MEMBER
				+ "(MemberID INTEGER  PRIMARY KEY AUTOINCREMENT,"
				+ " Name TEXT(100)," + " Tel TEXT(100));");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_MEMBER);
		onCreate(db);

	}

	// insert data
	public long InsertData(String strName, String strTel) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Tel", strTel);
			long l = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return l;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}

	}

	// select all Data
	public ArrayList<HashMap<String, String>> SelectAllData() {
		try {
			ArrayList<HashMap<String, String>> arrayList = 
					new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map;
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			
			String strSQl = "SELECT * FROM  "+ TABLE_MEMBER;
			Cursor cursor = db.rawQuery(strSQl, null);
			if (cursor!=null){
				if(cursor.moveToFirst()){
					do {
						map=new HashMap<String, String>();
						map.put("MemberID",cursor.getString(0));
						map.put("Name", cursor.getString(1));
						map.put("Tel", cursor.getString(2));
						arrayList.add(map);
					} while (cursor.moveToNext());
				}
			}
			cursor.close();
			db.close();
			return arrayList;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		

	}
}
