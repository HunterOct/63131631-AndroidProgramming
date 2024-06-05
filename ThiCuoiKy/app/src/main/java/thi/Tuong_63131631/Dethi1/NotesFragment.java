package thi.Tuong_63131631.Dethi1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class NotesFragment extends Fragment {

    ListView lv;
    ArrayList<Notes> mylist;
    SQLiteDatabase db;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);

        lv = rootView.findViewById(R.id.notesLayout);

        // Create or open the database
        db = getActivity().openOrCreateDatabase("QLNotes.db", getActivity().MODE_PRIVATE, null);

        // Create the table
        String sqlDeleteTableExist = "DROP TABLE IF EXISTS Notes;\n";
        String sqlCreateTable = "CREATE TABLE Notes(NoteId integer PRIMARY KEY, NoteName text, Description text);";

        // Execute the SQL statements
        db.execSQL(sqlDeleteTableExist);
        db.execSQL(sqlCreateTable);

        // Insert some data
        String sqlInsertTable1 = "INSERT INTO Notes VALUES(1, 'Ghi Chú 1', 'Đây là ghi chú 1');";
        String sqlInsertTable2 = "INSERT INTO Notes VALUES(2, 'Ghi Chú 2', 'Đây là ghi chú 2');";
        String sqlInsertTable3 = "INSERT INTO Notes VALUES(3, 'Ghi Chú 3', 'Đây là ghi chú 3');";
        String sqlInsertTable4 = "INSERT INTO Notes VALUES(4, 'Ghi Chú 4', 'Đây là ghi chú 4');";
        String sqlInsertTable5 = "INSERT INTO Notes VALUES(5, 'Ghi Chú 5', 'Đây là ghi chú 5');";
        String sqlInsertTable6 = "INSERT INTO Notes VALUES(6, 'Ghi Chú 6', 'Đây là ghi chú 6');";

        String sqlInsertTable7 = "INSERT INTO Notes VALUES(7, 'Ghi Chú 7', 'Đây là ghi chú 7');";

        String sqlInsertTable8 = "INSERT INTO Notes VALUES(8, 'Ghi Chú 8', 'Đây là ghi chú 8');";
        String sqlInsertTable9 = "INSERT INTO Notes VALUES(9, 'Ghi Chú 9', 'Đây là ghi chú 9');";

        String sqlInsertTable10 = "INSERT INTO Notes VALUES(10, 'Ghi Chú 10', 'Đây là ghi chú 10');";

        String sqlInsertTable11 = "INSERT INTO Notes VALUES(11, 'Ghi Chú 11', 'Đây là ghi chú 11');";

        String sqlInsertTable12 = "INSERT INTO Notes VALUES(12, 'Ghi Chú 12', 'Đây là ghi chú 12');";
        String sqlInsertTable13 = "INSERT INTO Notes VALUES(13, 'Ghi Chú 13', 'Đây là ghi chú 13');";
        String sqlInsertTable14 = "INSERT INTO Notes VALUES(14, 'Ghi Chú 14', 'Đây là ghi chú 14');";

        String sqlInsertTable15 = "INSERT INTO Notes VALUES(15, 'Ghi Chú 15', 'Đây là ghi chú 15');";


        db.execSQL(sqlInsertTable1);
        db.execSQL(sqlInsertTable2);
        db.execSQL(sqlInsertTable3);

        // Close the database to check
        db.close();

        // Open the database
        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLNotes.db", getActivity().MODE_PRIVATE, null);

        // Execute the select statement
        String sqlSelect = "Select * FROM Notes";
        Cursor cs = db.rawQuery(sqlSelect, null);

        // Process the result
        mylist = new ArrayList<Notes>();
        while (cs.moveToNext()) {
            int noteId = cs.getInt(0);
            String noteName = cs.getString(1);
            String description = cs.getString(2);

            // Create a note object and add it to the list
            Notes note = new Notes(noteId, noteName, description);
            mylist.add(note);
        }

        // Create an adapter and set it to the ListView
        NotesAdapter adapter = new NotesAdapter(getActivity(), mylist);
        lv.setAdapter(adapter);

        return rootView;
    }
}