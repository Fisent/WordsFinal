package lukzieniewicz.gmail.com.wordsfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddWordActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
    }

    public void onAddClick(View view){
        EditText eng = (EditText) findViewById(R.id.english_edit_text);
        EditText pol = (EditText) findViewById(R.id.polish_edit_text);

        if(!eng.getText().toString().equals("") && !pol.getText().toString().equals("")){
            Word w = new Word(eng.getText().toString(), pol.getText().toString());

            MainActivity.addWord(w);

            eng.setText("");
            pol.setText("");
        }


    }
}
