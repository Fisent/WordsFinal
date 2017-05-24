package lukzieniewicz.gmail.com.wordsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditWordActivity extends AppCompatActivity
{

    private Word current;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word);

        populateForm();
    }

    private void populateForm(){
        int index = getIntent().getIntExtra("index", 999);

        current = MainActivity.words.get(index);

        ((EditText) findViewById(R.id.english_edit_text)).setText(current.getEnglish());
        ((EditText) findViewById(R.id.polish_edit_text)).setText(current.getPolish());
        ((EditText) findViewById(R.id.category_edit_text)).setText(current.getCategory());
    }
}
