package lukzieniewicz.gmail.com.wordsfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    private HashSet<Word> words;
    private boolean changed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        updateWords();
    }

    // connect to firebase and fetch data from there
    public void updateWords(){
        if(changed) {
            //tutaj będzie połączenie z bazą
            words = new HashSet<>();
        }
        changed = false;
    }

    public void addWord(Word w){
        words.add(w);
        changed = true;
    }
}
