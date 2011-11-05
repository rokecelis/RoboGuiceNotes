package be.baes.notes.IoC;

import com.google.inject.AbstractModule;

import be.baes.notes.Dal.*;

public class NotesModule extends AbstractModule {
	
	public NotesModule()
	{
		
	}

	@Override
	protected void configure() {
		bind(NotesAdapter.class).to(NotesSQLiteAdapter.class);
	}

}
