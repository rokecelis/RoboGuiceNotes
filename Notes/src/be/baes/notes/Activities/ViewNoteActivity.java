package be.baes.notes.Activities;

import com.google.inject.Inject;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import be.baes.notes.R;
import be.baes.notes.Controllers.DeleteNoteClickListener;
import be.baes.notes.Controllers.OpenEditNoteClickListener;
import be.baes.notes.Controllers.OpenNotesListClickListener;
import be.baes.notes.Dal.NotesSQLiteAdapter;
import be.baes.notes.Model.Note;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class ViewNoteActivity extends RoboActivity {
	@InjectView(R.id.textTitle) TextView textTitle;
	@InjectView(R.id.textText) TextView textText;
	@InjectView(R.id.backButton) Button backButton;
	@InjectView(R.id.editButton) Button editButton;
	@InjectView(R.id.deleteButton) Button deleteButton;
	@Inject NotesSQLiteAdapter notesSQLiteAdapter;
	@Inject OpenNotesListClickListener openNotesClickListener;
	@Inject OpenEditNoteClickListener openEditNoteClickListener;
	@Inject DeleteNoteClickListener deleteNoteClickListener;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.viewnote);
		
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
        	Long rowId = bundle.getLong("rowId");
        	Log.i("cbaes", "rowId: "+ rowId);
        	activateViewNote(rowId);
        }
        backButton.setOnClickListener(openNotesClickListener);
        editButton.setOnClickListener(openEditNoteClickListener);
        deleteButton.setOnClickListener(deleteNoteClickListener);
    }
    
	public void activateViewNote(long noteId)
	{
		Note note = notesSQLiteAdapter.fetchNote(noteId);
		Log.i("cbaes", "Id: " + note.getId());
		Log.i("cbaes", "Title: " + note.getTitle());
		Log.i("cbaes", "Note: " + note.getNote());
		textTitle.setText(note.getTitle());
		textText.setText(note.getNote());
	}
}
