package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import lukzieniewicz.gmail.com.wordsfinal.JavaClasses.Word;

public class AddWordActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        System.out.println("debugaaa: " + ListActivity.categories.toString());

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ListActivity.categories));
    }

    public void onAddClick(View view){
        EditText eng = (EditText) findViewById(R.id.english_edit_text);
        EditText pol = (EditText) findViewById(R.id.polish_edit_text);
        Spinner cat = (Spinner) findViewById(R.id.spinner);

        if(true){
            Word w = new Word(eng.getText().toString(), pol.getText().toString(), (String) cat.getSelectedItem());

            ListActivity.words.add(w);

            eng.setText("");
            pol.setText("");

            Toast.makeText(this, "Dodano!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
