package be.baes.notes.Controllers;

import com.google.inject.Inject;

import be.baes.notes.Activities.ViewNoteActivity;
import be.baes.notes.Model.Note;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class OpenViewNoteItemClickListener implements OnItemClickListener {
	@Inject Activity activity;
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Log.i("cbaes", "Item: " + arg2);
		Note note = (Note)arg0.getAdapter().getItem(arg2);
		Log.i("cbaes", "Id: " + note.getId());
		Log.i("cbaes", "Title: " + note.getTitle());
		Log.i("cbaes", "Note: " + note.getNote());
		Intent intent = new Intent(activity,ViewNoteActivity.class);
		Bundle bundle = new Bundle();
		bundle.putLong("rowId",note.getId());
		intent.putExtras(bundle);
		activity.startActivity(intent);		
	}


}
