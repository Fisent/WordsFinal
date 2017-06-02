package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

import lukzieniewicz.gmail.com.wordsfinal.WordsClasses.ListActivity;

public class DeleteAllActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_all);
    }

    public void onDeleteAllClick(View view){
        ListActivity.words = new LinkedList<>();
        onBackPressed();
    }
}
