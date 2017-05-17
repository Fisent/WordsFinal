package lukzieniewicz.gmail.com.wordsfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    public static LinkedList<Word> words;
    private boolean changed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        updateWords();
    }

    // connect to firebase and fetch data there
    public void updateWords(){
        if(changed) {
            //tutaj będzie połączenie z bazą
            words = new LinkedList<Word>();
            words.add(new Word("chair", "krzeslo"));
        }
        changed = false;

    }

    public void addWord(Word w){
        words.add(w);
        changed = true;
    }

    //temporary
    public void onWordClick(View view){
        Intent i = new Intent(this, WordViewActivity.class);
        i.putExtra("number",0);
        startActivity(i);
    }
}
