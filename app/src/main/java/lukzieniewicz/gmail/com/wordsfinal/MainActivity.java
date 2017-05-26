package lukzieniewicz.gmail.com.wordsfinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity
{

    private static boolean changed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        //updateWords();


    }

    //zajebista funkcja, przechodzi po wszystkich widokach jak po drzewie i zmienia kolor tekstu. A, i okazuje się że prawie wszystko w androidzie dziedziczy po TextView, nawet Button
    public void changeFont(View view){
        try{
            if(view instanceof ViewGroup)
            {
                ViewGroup vg = (ViewGroup) view;

                for (int i = 0; i < vg.getChildCount(); i++)
                {
                    View vc = vg.getChildAt(i);
                    changeFont(vc);

                }
            }
            if(view instanceof TextView){
                TextView t = (TextView) view;
                t.setTextColor(Color.RED);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}