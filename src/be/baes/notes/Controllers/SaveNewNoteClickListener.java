package be.baes.notes.Controllers;

import roboguice.inject.InjectView;
import be.baes.notes.R;
import be.baes.notes.Activities.NotesActivity;
import be.baes.notes.Dal.NotesSQLiteAdapter;

import com.google.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class SaveNewNoteClickListener implements OnClickListener {
	@Inject NotesSQLiteAdapter notesSQLiteAdapter;
	@InjectView(R.id.InputTitle) EditText inputTitle;
	@InjectView(R.id.InputNote) EditText inputNote;
	@Inject Activity activity;
		
	@Override
	public void onClick(View arg0) {
		Log.i("cbaes", "SaveButton clicked");
		Log.i("cbaes","InputTitle: " + inputTitle.getText().toString());
		Log.i("cbaes","InputNote: " + inputNote.getText().toString());
		Bundle bundle = activity.getIntent().getExtras();
		if(bundle != null)
		{
			Long rowId = bundle.getLong("rowId");
        	Log.i("cbaes", "rowId: "+ rowId);
        	Log.i("cbaes","Update note: " + notesSQLiteAdapter.updateNote(rowId, inputTitle.getText().toString(),inputNote.getText().toString()));
		}
		else
		{
			Log.i("cbaes","New note: " + notesSQLiteAdapter.createNote(inputTitle.getText().toString(),inputNote.getText().toString()));
		}
		activity.startActivity(new Intent(activity, NotesActivity.class));
	}

}
