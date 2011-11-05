package be.baes.notes.Dal;

import java.util.List;

import android.database.SQLException;

public interface NotesAdapter {

	//retrieves a database
	public abstract void open() throws SQLException;

	//close the dbHelper
	public abstract void close();

	//create a new note, returns the note id
	public abstract long createNote(String title, String note);

	public abstract boolean updateNote(long rowId, String title, String note);

	public abstract boolean deleteNote(long rowId);

	public abstract List<be.baes.notes.Model.Note> fetchAllNotes();

	public abstract be.baes.notes.Model.Note fetchNote(long rowId) throws SQLException;

}