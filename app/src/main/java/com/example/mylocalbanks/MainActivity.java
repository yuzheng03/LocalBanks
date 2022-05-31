package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView dbs;
    TextView ocbc;
    TextView uob;
    String wordClicked = "";
    TextView tvdbs;
    TextView tvocbc;
    TextView tvuob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.textViewdbs);
        ocbc = findViewById(R.id.textViewocbc);
        uob = findViewById(R.id.textViewuob);
        tvdbs = findViewById(R.id.textViewdbs);
        tvocbc = findViewById(R.id.textViewocbc);
        tvuob = findViewById(R.id.textViewuob);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    //to use the context menu, need to implement onCreateContextMenu()
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        if (v == dbs) {
            wordClicked = "dbs";
        } else if (v == ocbc) {
            wordClicked = "ocbc";
        } else if (v == uob) {
            wordClicked = "uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intent);
            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18001111111"));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com.sg"));
                startActivity(intent);;
            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
                startActivity(intent);
            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18002222121"));
                startActivity(intentCall);
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //inflate the menu;this adds the option to action bar
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    //implemented to perform the language translation (below codes)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.englishSelection) {
            tvdbs.setText("DBS ");
            tvocbc.setText("OCBC ");
            tvuob.setText("UOB ");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvdbs.setText("星展银行");
            tvocbc.setText("华侨银行 ");
            tvuob.setText("大华银行");
            return true;
        } else {
            Toast.makeText(MainActivity.this, "Error translation", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}





