package be.baes.notes.test.Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

import be.baes.notes.Model.Note;

@RunWith(RobolectricTestRunner.class)
public class NoteTest {

	private Note note;
	
	@Before
	public void setUp() throws Exception {
		note = new Note(0l,"","");
	}
	
	@Test
	public void testIfIdCanBeSetAndRetrieved()
	{
		note.setId(1l);
		assertEquals((Long)1l, note.getId());
	}
	
	@Test
	public void testIfTitleCanBeSetAndRetrieved()
	{
		note.setTitle("test");
		assertEquals("test", note.getTitle());
	}
	
	@Test
	public void testIfNoteCanBeSetAndRetrieved()
	{
		note.setNote("test");
		assertEquals("test", note.getNote());
	}
	
	@Test
	public void testIf2NotesAreEqualIfTheIdIsNotEqual()
	{
		Note note2 = new Note(0l,"","");
		assertTrue(note.equals(note2));
	}
	
	@Test
	public void testIf2NotesAreNotEqualIfTheIdIsNotEqual()
	{
		Note note2 = new Note(1l,"","");
		assertFalse(note.equals(note2));
	}
	
	@Test
	public void testIf2NotesAreNotEqualIf1IsNull()
	{
		Note note2 = null;
		assertFalse(note.equals(note2));
	}
	
	@Test
	public void testIfToStringReturnsCorrectResult()
	{
		assertEquals("Note [id=0, title=, note=]",note.toString());
	}

}
