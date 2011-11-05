package be.baes.notes.Activities.Adapter;

import java.util.List;

import be.baes.notes.R;
import be.baes.notes.Model.Note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesAdapter extends ArrayAdapter<Note> 
{

	int resource;
	String response;
	Context context;

	public NotesAdapter(Context context, int resource, List<Note> items) 
	{
		super(context, resource, items);
		this.resource=resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LinearLayout noteView;
		Note note = getItem(position);

		if(convertView==null)
		{
			noteView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi;
			vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, noteView, true);
		}
		else
		{
			noteView = (LinearLayout) convertView;
		}
		TextView rowId =(TextView)noteView.findViewById(R.id.rowId);
		TextView rowTitle =(TextView)noteView.findViewById(R.id.rowTitle);
		TextView rowText =(TextView)noteView.findViewById(R.id.rowText);

		rowId.setText(note.getId().toString());
		rowTitle.setText(note.getTitle());
		rowText.setText(note.getNote());
		return noteView;
	}

}
