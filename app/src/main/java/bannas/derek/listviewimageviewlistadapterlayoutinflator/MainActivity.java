package bannas.derek.listviewimageviewlistadapterlayoutinflator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a string array with which you populate the list
        String[] favouriteTVShows = {"Pushing Daisies", "Better Off Ted", "Twin Peaks", "Freaks and Geeks", "Orphan Black", "Walking Dead",
                "Breaking Bad", "The 400", "Alphas", "Life on Mars"};

//        // *******************************************************************************************************************
//         CODE FOR CUSTOM ADAPTER
        ListAdapter theAdapter = new MyAdapter(this, favouriteTVShows);
        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(theAdapter);

//        // *******************************************************************************************************************
//        // CODE FOR THE HARDER LISTVIEW EXAMPLE
//        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.textView1, favouriteTVShows);
//        ListView theListView = (ListView) findViewById(R.id.listView1);
//        theListView.setAdapter(theAdapter);

//        // *******************************************************************************************************************
//        // CODE FOR THE EASY LISTVIEW EXAMPLE
//        //
//        // Create an adapter to adapt the array to a list
//        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, favouriteTVShows);
//        // Create the list view
//        ListView theListView = (ListView) findViewById(R.id.textView1);
//        // Set the list view adapter
//        theListView.setAdapter(theAdapter);
//        // Catch any clicks on the ListView
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String tvShowPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));
                // Make a toast
                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
