package lukzieniewicz.gmail.com.wordsfinal.CategoriesClasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import lukzieniewicz.gmail.com.wordsfinal.R;
import lukzieniewicz.gmail.com.wordsfinal.WordsClasses.ListActivity;

public class CategoryListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        populate();
    }

    private void populate(){
        ListView list  = (ListView) findViewById(R.id.category_list_view);
        list.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListActivity.categories));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), CategoryViewActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), EditCategoryActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);

                return true;
            }
        });
    }
}
