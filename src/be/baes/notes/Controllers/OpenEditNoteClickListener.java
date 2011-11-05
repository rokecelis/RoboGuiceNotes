package be.baes.notes.Controllers;

import com.google.inject.Inject;

import be.baes.notes.Activities.EditNoteActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class OpenEditNoteClickListener implements OnClickListener {
	@Inject Activity activity;
	
	@Override
	public void onClick(View arg0) {
		Intent intent = new Intent(activity,EditNoteActivity.class);
		Bundle bundle = activity.getIntent().getExtras();
		intent.putExtras(bundle);
		activity.startActivity(intent);				
	}


}
