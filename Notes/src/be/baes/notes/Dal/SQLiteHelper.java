package be.baes.notes.Dal;

import com.google.inject.Inject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "applicationData";
	private static final int DATABASE_VERSION = 1;
	
	//DatabaseSQLStatement
	private static final String DATABASE_CREATE = 
			"Create table notes(" +
			"_id integer primary key autoincrement, " +
			"title text not null, " +
			"note text not null)";
	
	@Inject
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public SQLiteHelper(Context context, String databasename) {
		super(context, databasename, null, DATABASE_VERSION);
	}

	/* (non-Javadoc)
	 * @see be.baes.notes.Dal.DatabaseHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("cbaes","Creating database");
		db.execSQL(DATABASE_CREATE);
	}

	/* (non-Javadoc)
	 * @see be.baes.notes.Dal.DatabaseHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("cbaes","upgrading database database");
		db.execSQL("DROP TABLE IF EXISTS notes");
		onCreate(db);
	}
	
	public SQLiteDatabase getWritableDatabase()
	{
		return super.getWritableDatabase();
	}

	public void close()
	{
		super.close();
	}

}
