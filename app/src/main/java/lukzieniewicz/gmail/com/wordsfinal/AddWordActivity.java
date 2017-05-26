package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddWordActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        getActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void onAddClick(View view){
        EditText eng = (EditText) findViewById(R.id.english_edit_text);
        EditText pol = (EditText) findViewById(R.id.polish_edit_text);

        if(true){
            Word w = new Word(eng.getText().toString(), pol.getText().toString());

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
