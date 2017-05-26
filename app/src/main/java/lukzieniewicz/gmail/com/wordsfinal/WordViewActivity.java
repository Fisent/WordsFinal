package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_word_view, menu);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_delete_item:
                ListActivity.words.remove(current);
                onBackPressed();
                return true;
            case R.id.menu_edit_item:
                Intent i = new Intent(this, EditWordActivity.class);
                i.putExtra("index", ListActivity.words.indexOf(current));
                startActivity(i);
                return true;
        }

        return super.onMenuItemSelected(featureId, item);
    }

    public void setLabels(){
        Intent i = getIntent();
        int index = i.getExtras().getInt("number");

        TextView eng = (TextView) findViewById(R.id.english_detail_label);
        TextView pol = (TextView) findViewById(R.id.polish_detail_label);
        TextView lvl = (TextView) findViewById(R.id.level_detail_label);

        Word w = ListActivity.words.get(index);
        current = w;
        eng.setText(w.getEnglish());
        pol.setText(w.getPolish());
        lvl.setText(w.getLevel() + "");
    }

    public void onEditClick(View view){
        Intent i = new Intent(this, EditWordActivity.class);
        i.putExtra("index", ListActivity.words.indexOf(current));
        startActivity(i);
    }

    public void onUpClick(View view){
        current.levelUp();
        setLabels();
        Toast.makeText(this, "Zwiększono poziom", Toast.LENGTH_SHORT);
    }

    public void onDownClick(View view){
        current.levelDown();
        setLabels();
        Toast.makeText(this, "Zmniejszono poziom", Toast.LENGTH_SHORT);
    }

    public void onDeleteClick(View view){
        ListActivity.words.remove(current);
        onBackPressed();
    }
}
