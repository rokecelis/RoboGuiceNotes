package be.baes.notes.Activities;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import com.google.inject.Inject;

import be.baes.notes.R;
import be.baes.notes.Activities.Adapter.NotesAdapter;
import be.baes.notes.Controllers.OpenViewNoteItemClickListener;
import be.baes.notes.Controllers.OpenNewNoteClickListener;
import be.baes.notes.Dal.NotesSQLiteAdapter;
import be.baes.notes.Model.Note;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

public class NotesActivity extends RoboActivity {
	@Inject OpenNewNoteClickListener addNoteClickListener;
	@Inject OpenViewNoteItemClickListener editNoteClickListener;
	@InjectView(R.id.AddNewNoteButton) Button addNoteButton;
	@InjectView(R.id.NotesList) ListView listView;
	@Inject NotesSQLiteAdapter notesSQLiteAdapter;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
		
        Log.i("cbaes", "NotesActivity onCreate");
    
        List<Note> notes = notesSQLiteAdapter.fetchAllNotes();
		
		NotesAdapter notesAdapter = new NotesAdapter(this,R.layout.row,notes);
		listView.setAdapter(notesAdapter);
		Log.i("cbaes", "Number of notes: " + notes.size());
		
		this.listView.setOnItemClickListener(editNoteClickListener);
		this.addNoteButton.setOnClickListener(addNoteClickListener);
		Log.i("cbaes", "Setting addNoteClickListener");
	}

    
}
