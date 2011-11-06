package be.baes.notes.Controllers;

import be.baes.notes.Activities.NotesActivity;
import be.baes.notes.Dal.NotesSQLiteAdapter;

import com.google.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


public class DeleteNoteClickListener implements OnClickListener {
	@Inject NotesSQLiteAdapter notesSQLiteAdapter;
	@Inject Activity activity;
	
	@Override
	public void onClick(View arg0) {
		Bundle bundle = activity.getIntent().getExtras();
		if(bundle != null)
		{
			Long rowId = bundle.getLong("rowId");
        	Log.i("cbaes", "rowId: "+ rowId);
        	Log.i("cbaes","Delete note: " + notesSQLiteAdapter.deleteNote(rowId));
		}
		activity.startActivity(new Intent(activity, NotesActivity.class));
		
	}

}
