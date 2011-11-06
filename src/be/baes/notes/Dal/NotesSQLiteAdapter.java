package be.baes.notes.Dal;

import java.util.ArrayList;
import java.util.List;

import be.baes.notes.Model.Note;

import com.google.inject.Inject;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class NotesSQLiteAdapter implements NotesAdapter {
	@Inject SQLiteHelper dbHelper;
	@Inject Application context;
	private SQLiteDatabase db;
	public static final String KEY_ROWID= "_id";
	public static final String KEY_TITLE = "title";
	public static final String KEY_NOTE = "note";
	public static final String DATABASE_TABLE = "notes";

	public NotesSQLiteAdapter()
	{
		Log.i("cbaes", "New instance of NotesSQLiteAdapter");
		open();
	}
	
	private void open() throws SQLException
	{
		if(context == null) Log.i("cbaes", "activity is still null");
		this.dbHelper = new SQLiteHelper(context);
		if(dbHelper == null) Log.i("cbaes", "dbHelper is still null");
		Log.i("cbaes", "getWritableDatabase");
		try
		{
			db = dbHelper.getWritableDatabase();
		}
		catch (Exception ex)
		{
			Log.i("cbaes", "getWritableDatabase error: " + ex.getMessage());
		}
	}
	
	@Override
	protected void finalize() throws Throwable 
	{
		Log.i("cbaes", "finalizing NotesSQLiteAdapter");
	    try 
	    {
	    	dbHelper.close();        // close open files
	    } 
	    finally 
	    {
	        super.finalize();
	    }
	}
	
	//create a new note, returns the note id
	/* (non-Javadoc)
	 * @see be.baes.notes.Dal.NotesAdapter#createNote(java.lang.String, java.lang.String)
	 */
	@Override
	public long createNote(String title, String note)
	{
		Log.i("cbaes","Creating note");
		open();
		ContentValues initValues = createContentValues(title, note);
		return db.insert(DATABASE_TABLE, null, initValues);
		
	}

	/* (non-Javadoc)
	 * @see be.baes.notes.Dal.NotesAdapter#updateNote(long, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateNote(long rowId, String title, String note)
	{
		Log.i("cbaes","Updating note");
		open();
		ContentValues updateValues = createContentValues(title, note);
		return db.update(DATABASE_TABLE, updateValues, KEY_ROWID + "=" + rowId, null)>0;
	}
	
	/* (non-Javadoc)
	 * @see be.baes.notes.Dal.NotesAdapter#deleteNote(long)
	 */
	@Override
	public boolean deleteNote(long rowId)
	{
		Log.i("cbaes","Deleting note");
		open();
		return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null)>0;
	}
	
	/* (non-Javadoc)
	 * @see be.baes.notes.Dal.NotesAdapter#fetchAllNotes()
	 */
	@Override
	public List<Note> fetchAllNotes()
	{
		List<Note> result = null;
		Log.i("cbaes","Fetching all notes");
		open();
		Cursor cursor = db.query(DATABASE_TABLE, new String[]{KEY_ROWID, KEY_TITLE, KEY_NOTE}, null, null, null, null, null);
		if(cursor != null)
		{
			result = new ArrayList<Note>();
			while (cursor.moveToNext()) 
			{ 
				result.add(new Note(cursor.getLong(0),cursor.getString(1),cursor.getString(2)));
			}
		}
		cursor.close();
		return result;
	}
	
	/* (non-Javadoc)
	 * @see be.baes.notes.Dal.NotesAdapter#fetchNote(long)
	 */
	@Override
	public Note fetchNote(long rowId) throws SQLException
	{
		Log.i("cbaes","Fetching note");
		Note result = null;
		open();
		Cursor cursor = db.query(DATABASE_TABLE, new String[]{KEY_ROWID, KEY_TITLE, KEY_NOTE}, KEY_ROWID + "=" + rowId, null, null, null, null);
		if(cursor != null)
		{
			cursor.moveToFirst();
			result = new Note(cursor.getLong(0),cursor.getString(1),cursor.getString(2));
		}
		cursor.close();
		return result;
	}	
	
	private ContentValues createContentValues(String title, String note) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(KEY_TITLE, title);
		values.put(KEY_NOTE, note);
		return values;
	}
	
	
}
