package be.baes.notes.Activities;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import com.google.inject.Inject;

import be.baes.notes.R;
import be.baes.notes.Controllers.OpenNotesListClickListener;
import be.baes.notes.Controllers.SaveNewNoteClickListener;
import be.baes.notes.Dal.NotesSQLiteAdapter;
import be.baes.notes.Model.Note;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class EditNoteActivity extends RoboActivity {
	@Inject OpenNotesListClickListener cancelEditNoteClickListener;
	@Inject SaveNewNoteClickListener saveNoteClickListener;
	@Inject Activity activity;
	@InjectView(R.id.saveButton) Button saveButton;
	@InjectView(R.id.cancelButton) Button cancelButton;
	@InjectView(R.id.InputTitle) EditText inputTitle;
	@InjectView(R.id.InputNote) EditText inputNote;
	@Inject NotesSQLiteAdapter notesSQLiteAdapter;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity.setContentView(R.layout.editnote);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
        	Long rowId = bundle.getLong("rowId");
        	Log.i("cbaes", "rowId: "+ rowId);
        	activateEditNote(rowId);
        }
        else
        {
        	activateEditNote();
        }
    }
    
	public void activateEditNote()
	{
		activity.setContentView(R.layout.editnote);
		
		this.saveButton.setOnClickListener(saveNoteClickListener);
		this.cancelButton.setOnClickListener(cancelEditNoteClickListener);
	}
	
	public void activateEditNote(long noteId)
	{
		activateEditNote();
		Note note = notesSQLiteAdapter.fetchNote(noteId);
		Log.i("cbaes", "Id: " + note.getId());
		Log.i("cbaes", "Title: " + note.getTitle());
		Log.i("cbaes", "Note: " + note.getNote());
		inputTitle.setText(note.getTitle());
		inputNote.setText(note.getNote());
	}
	
}
