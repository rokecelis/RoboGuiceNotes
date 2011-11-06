package be.baes.notes.test.Model;

import be.baes.notes.Model.Note;
import junit.framework.Assert;
import junit.framework.TestCase;

public class NoteTest extends TestCase {

	private Note note;
	
	protected void setUp() throws Exception {
		super.setUp();
		note = new Note(0l,"","");
	}
	
	public void testIfIdCanBeSetAndRetrieved()
	{
		note.setId(1l);
		assertEquals((Long)1l, note.getId());
	}
	
	public void testIfTitleCanBeSetAndRetrieved()
	{
		note.setTitle("test");
		assertEquals("test", note.getTitle());
	}
	
	public void testIfNoteCanBeSetAndRetrieved()
	{
		note.setNote("test");
		assertEquals("test", note.getNote());
	}
	
	public void testIf2NotesAreEqualIfTheIdIsNotEqual()
	{
		Note note2 = new Note(0l,"","");
		assertTrue(note.equals(note2));
	}
	
	public void testIf2NotesAreNotEqualIfTheIdIsNotEqual()
	{
		Note note2 = new Note(1l,"","");
		assertFalse(note.equals(note2));
	}
	
	public void testIf2NotesAreNotEqualIf1IsNull()
	{
		Note note2 = null;
		assertFalse(note.equals(note2));
	}
	
	public void testIfToStringReturnsCorrectResult()
	{
		assertEquals("Note [id=0, title=, note=]",note.toString());
	}

}
