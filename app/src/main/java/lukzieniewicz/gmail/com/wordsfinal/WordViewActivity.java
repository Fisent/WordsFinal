package lukzieniewicz.gmail.com.wordsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class WordViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setLabels();
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

    public void setLabels(){
        Intent i = getIntent();
        int index = i.getExtras().getInt("number");

        TextView eng = (TextView) findViewById(R.id.english_detail_label);
        TextView pol = (TextView) findViewById(R.id.polish_detail_label);

        Word w = MainActivity.words.get(index);

        eng.setText(w.getEnglish());
        pol.setText(w.getPolish());
    }
}
