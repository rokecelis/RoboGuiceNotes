package be.baes.notes.test.Model;

import be.baes.notes.Model.Note;
import junit.framework.Assert;
import junit.framework.TestCase;

public class NoteTest extends TestCase {

	private Note note;
	
	protected void setUp() throws Exception {
		super.setUp();
		note = new Note((Long) 0l,"","");
	}
	
	public void testIfIdCanBeSetAndRetrieved()
	{
		note.setId((Long) 1l);
		Assert.assertEquals((Long)1l, note.getId());
	}
	
	public void testIfTitleCanBeSetAndRetrieved()
	{
		note.setTitle("test");
		Assert.assertEquals("test", note.getTitle());
	}
	
	public void testIfNoteCanBeSetAndRetrieved()
	{
		note.setNote("test");
		Assert.assertEquals("test", note.getNote());
	}

}
