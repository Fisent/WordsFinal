package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
