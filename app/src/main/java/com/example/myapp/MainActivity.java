package com.example.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapp.Adapter.PokemonListAdapter;
import com.example.myapp.Common.Common;
import com.example.myapp.Model.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;


    Toolbar toolbar;


    BroadcastReceiver showDetail = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().toString().equals(Common.KEY_ENABLE_HOME))
            {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);

                Fragment detailFragment = PokemonDetail.getInstance();
                String num = intent.getStringExtra("num");
                int position = intent.getIntExtra("position",-1);
                Bundle bundle = new Bundle();
                bundle.putString("num",num);
                detailFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.list_pokemon_fragment,detailFragment);
                fragmentTransaction.addToBackStack("detail");
                fragmentTransaction.commit();

                Pokemon pokemon = Common.findPokemonByNum(num);
                toolbar.setTitle(pokemon.getName());
            }

        }
    };

    BroadcastReceiver showEvolution = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().toString().equals(Common.KEY_NUM_EVOLUTION))
            {

                Fragment detailFragment = PokemonDetail.getInstance();

                Bundle bundle = new Bundle();
                String num = intent.getStringExtra("num");
                bundle.putString("num",num);
                detailFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.remove(detailFragment);
                fragmentTransaction.replace(R.id.list_pokemon_fragment,detailFragment);
                fragmentTransaction.addToBackStack("detail");
                fragmentTransaction.commit();

                Pokemon pokemon = Common.findPokemonByNum(num);
                toolbar.setTitle(pokemon.getName());
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listv);
        String [] fragment_pokemon_list ={} ;
        arrayList = new ArrayList<>(Arrays.asList(fragment_pokemon_list));
        adapter = new ArrayAdapter<String>(this,R.layout.pokemon_list_item,R.id.txt_pokemon_name,arrayList);
        listView.setAdapter(adapter);
        txtInput = (EditText)findViewById(R.id.txtinput);
        Button btAdd = (Button)findViewById(R.id.btadd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem=txtInput.getText().toString();
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("POKEMON LIST");
        setSupportActionBar(toolbar);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(showDetail, new IntentFilter(Common.KEY_ENABLE_HOME));

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(showEvolution, new IntentFilter(Common.KEY_NUM_EVOLUTION));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                toolbar.setTitle("POKEMON LIST");

                getSupportFragmentManager().popBackStack("detail", FragmentManager.POP_BACK_STACK_INCLUSIVE);

                getSupportActionBar().setDisplayShowHomeEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                break;
            default:
                break;
        }
        return true;
    }
}
