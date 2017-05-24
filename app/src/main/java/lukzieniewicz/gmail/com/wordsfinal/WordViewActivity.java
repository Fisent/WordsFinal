package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class WordViewActivity extends Activity
{

    private Word current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_view);
        getActionBar().setDisplayHomeAsUpEnabled(true);

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
        current = w;
        eng.setText(w.getEnglish());
        pol.setText(w.getPolish());
    }

    public void onEditClick(View view){
        Intent i = new Intent(this, EditWordActivity.class);
        i.putExtra("index", MainActivity.words.indexOf(current));
        startActivity(i);
    }
}
