package pk.codebase.dynamiclistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    Button btn;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        btn = (Button) findViewById(R.id.btn);


        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (!(text.matches(""))) {
                    String result = editText.getText().toString();
                    editText.getText().clear();
                    arrayList.add(result);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = arrayList.get(position);
                arrayList.remove(item);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "YOu selected", Toast.LENGTH_SHORT);
            }
        });
    }
}
