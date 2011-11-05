package be.baes.notes.Controllers;

import be.baes.notes.Activities.EditNoteActivity;

import com.google.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class OpenNewNoteClickListener implements OnClickListener {
	@Inject Activity activity;
	
	@Override
	public void onClick(View arg0) {
		Log.i("cbaes","AddNote clicked");
		activity.startActivity(new Intent(activity, EditNoteActivity.class));
	}

}
