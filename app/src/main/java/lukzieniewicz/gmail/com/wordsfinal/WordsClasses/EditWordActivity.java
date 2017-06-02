package lukzieniewicz.gmail.com.wordsfinal.WordsClasses;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import lukzieniewicz.gmail.com.wordsfinal.R;

public class EditWordActivity extends Activity
{

    private Word current;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        populateForm();
    }

    private void populateForm(){
        int index = getIntent().getIntExtra("index", 999);

        current = ListActivity.words.get(index);

        ((EditText) findViewById(R.id.english_edit_text)).setText(current.getEnglish());
        ((EditText) findViewById(R.id.polish_edit_text)).setText(current.getPolish());
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

    public void onSaveClick(View view){
        EditText eng = (EditText) findViewById(R.id.english_edit_text);
        EditText pol = (EditText) findViewById(R.id.polish_edit_text);

        if(!pol.getText().toString().equals("") && !eng.getText().toString().equals("")){
            String e = eng.getText().toString();
            String p = pol.getText().toString();

            current.setEnglish(e);
            current.setPolish(p);

            Toast.makeText(this, "Zmieniono!", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }
}
