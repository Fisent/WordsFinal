package lukzieniewicz.gmail.com.wordsfinal.CategoriesClasses;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import lukzieniewicz.gmail.com.wordsfinal.R;
import lukzieniewicz.gmail.com.wordsfinal.WordsClasses.ListActivity;

public class EditCategoryActivity extends Activity {

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);

        populate();
    }

    private void populate(){
        EditText name = (EditText) findViewById(R.id.category_name_edit_text);
        int index = getIntent().getIntExtra("index", 999);
        category = ListActivity.categories.get(index);
        name.setText(category);
    }
}
