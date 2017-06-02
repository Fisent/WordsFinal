package lukzieniewicz.gmail.com.wordsfinal.CategoriesClasses;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import lukzieniewicz.gmail.com.wordsfinal.R;
import lukzieniewicz.gmail.com.wordsfinal.WordsClasses.ListActivity;

public class AddCategoryActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
    }

    public void onAddClick(View view){
        EditText name = (EditText) findViewById(R.id.category_name_edit_text);

        if(!name.getText().toString().equals("")){
            ListActivity.categories.add("name");
        }
    }
}
