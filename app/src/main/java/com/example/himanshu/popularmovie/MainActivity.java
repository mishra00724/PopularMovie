package com.example.himanshu.popularmovie;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    AlertDialog sortMenu;
    String choice=null;
    public static List<Movies> list=new ArrayList<>();

    public static MoviesAdapter moviesAdapter;

    public static ArrayList<String> images;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choice="popular";
        recyclerView=findViewById(R.id.rv_Movies);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        moviesAdapter =new MoviesAdapter(this,list);
        recyclerView.setAdapter(moviesAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        new FetchMoviesAsync().execute(choice);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.sortby){

            AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
            View view=getLayoutInflater().inflate(R.layout.alertbox,null);
            builder.setView(view);
            builder.setNeutralButton("Cancel",this);
            sortMenu=builder.create();
            sortMenu.setTitle("Sort");
            //sortMenu.setCancelable(false);

            sortMenu.show();


        }
        return super.onOptionsItemSelected(item);
    }



    public void menuItemOnClick(View view){
        boolean checker=((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.item1:
                Toast.makeText(MainActivity.this,"item number="+view.getId(),Toast.LENGTH_SHORT);
                choice = "popular";
                break;

            case R.id.item2:
                Toast.makeText(MainActivity.this,"item number="+view.getId(),Toast.LENGTH_SHORT);
                choice="top_rated";
                break;
        }



    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case DialogInterface.BUTTON_NEUTRAL:
                break;
            }
        }
    }

