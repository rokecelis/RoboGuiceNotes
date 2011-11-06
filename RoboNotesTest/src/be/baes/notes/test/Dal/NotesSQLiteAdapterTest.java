package be.baes.notes.test.Dal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.RoboGuice;

import android.app.Activity;
import android.content.Context;
import be.baes.notes.Dal.NotesSQLiteAdapter;
import be.baes.notes.Dal.SQLiteHelper;

import com.google.inject.AbstractModule;
import com.google.inject.util.Modules;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class NotesSQLiteAdapterTest {

	protected Context context = new Activity();
	private SQLiteHelper helper = new SQLiteHelper(context, "applicationtestData");

	@Before
	public void setUp() throws Exception {
		RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new TestModule()));
	}

	public class TestModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(SQLiteHelper.class).toInstance(helper);
		}
	}

	@After
	public void tearDown() throws Exception {
		RoboGuice.util.reset();
	}

	@Test
	public void testCanInsertNote() {
		final NotesSQLiteAdapter notesSQLiteAdapter = RoboGuice.getInjector(context).getInstance(NotesSQLiteAdapter.class);
		Long rowId = notesSQLiteAdapter.createNote("testtitle", "testnote");
		assertEquals((Long)1l,rowId);
		/*Note note = notesSQLiteAdapter.fetchNote(rowId);
		assertEquals("testtitle", note.getTitle());
		assertEquals("testnote", note.getNote());
		assertEquals(rowId, note.getId());*/
	}

}
