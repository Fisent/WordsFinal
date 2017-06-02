package lukzieniewicz.gmail.com.wordsfinal.WordsClasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import lukzieniewicz.gmail.com.wordsfinal.CategoriesClasses.AddCategoryActivity;
import lukzieniewicz.gmail.com.wordsfinal.CategoriesClasses.CategoryListActivity;
import lukzieniewicz.gmail.com.wordsfinal.DeleteAllActivity;
import lukzieniewicz.gmail.com.wordsfinal.R;

public class ListActivity extends Activity
{

    public static LinkedList<Word> words;
    public static LinkedList<String> categories;

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    }

    @Override
    protected void onStart(){
        super.onStart();

        if(words == null || categories == null){
            boolean b = load();
            if(!b){
                words = new LinkedList<Word>();
                categories = new LinkedList<String>();
            }
        }

        save();

        setList();
    }

    @Override
    protected void onStop(){
        super.onStop();
        save();
    }


    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_word_item:
                Intent i = new Intent(this, AddWordActivity.class);
                startActivity(i);
                return true;
            case R.id.delete_all_menu_item:
                Intent i2 = new Intent(this, DeleteAllActivity.class);
                startActivity(i2);
                return true;
            case R.id.category_menu_item:
                Intent i3 = new Intent(this, CategoryListActivity.class);
                startActivity(i3);
                return true;
        }
        return super.onMenuItemSelected(featureId, item);
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

    public void setList(){
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), WordViewActivity.class);
                i.putExtra("number", position);
                startActivity(i);
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getBaseContext(), EditWordActivity.class);
                intent.putExtra("index", i);
                startActivity(intent);
                return true;
            }
        });

        adapter = new ArrayAdapter<Word>(this, android.R.layout.simple_list_item_1, words);
        System.out.println("dupa" + words);
        list.setAdapter(adapter);
    }


    private boolean save(){
        try {
            FileOutputStream fos = this.openFileOutput("words_save", this.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(words);
            os.writeObject(categories);
            os.close();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean load(){
        try{
            FileInputStream fis = this.openFileInput("words_save");
            ObjectInputStream is = new ObjectInputStream(fis);
            words = (LinkedList<Word>) is.readObject();
            categories = (LinkedList<String>) is.readObject();
            is.close();
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    public void onDeleteAllClick(View view){
        startActivity(new Intent(this, DeleteAllActivity.class));
    }

    public void onAddWordClick(){
        startActivity(new Intent(this, AddWordActivity.class));
    }
}
