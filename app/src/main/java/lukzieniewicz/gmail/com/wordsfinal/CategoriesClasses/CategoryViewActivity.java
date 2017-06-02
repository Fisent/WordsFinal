package lukzieniewicz.gmail.com.wordsfinal.CategoriesClasses;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import lukzieniewicz.gmail.com.wordsfinal.R;
import lukzieniewicz.gmail.com.wordsfinal.WordsClasses.ListActivity;

public class CategoryViewActivity extends Activity {

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        populate();
    }

    private void populate(){
        TextView name = (TextView) findViewById(R.id.category_name_label);
        int index = getIntent().getIntExtra("index", 999);
        category = ListActivity.categories.get(index);
        name.setText(category);
    }
}
