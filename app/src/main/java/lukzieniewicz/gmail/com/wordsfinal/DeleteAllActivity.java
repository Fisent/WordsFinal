package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.LinkedList;

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
