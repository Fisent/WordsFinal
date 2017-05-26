package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

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
}
