package com.example.jsu.rockpaperscissors;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    public int playerScore = 0;
    public int computerScore = 0;
    public String playerWeapon = "";
    public String computerWeapon = "";
    public ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        list.add("Rock");
        list.add("Paper");
        list.add("Scissors");
    }

    public void rockButtonPressed(View v) {
        playerWeapon = list.get(0);
        TextView t = (TextView) findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: " + list.get(0));
        determineResults();
    }

    public void paperButtonPressed(View v) {
        playerWeapon = list.get(1);
        TextView t = (TextView) findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: " + list.get(1));
        determineResults();
    }

    public void scissorsButtonPressed(View v) {
        playerWeapon = list.get(2);
        TextView t = (TextView) findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: " + list.get(2));
        determineResults();
    }

    public void determineResults() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        computerWeapon = list.get(index);
        TextView cw = (TextView) findViewById(R.id.computerWeaponView);
        TextView sc = (TextView) findViewById(R.id.scoreView);
        TextView rv = (TextView) findViewById(R.id.resultsView);

        cw.setText("Computer's Weapon: " + computerWeapon);

        if(playerWeapon.equals(computerWeapon)) {
            rv.setText("Draw!");
        }

        if(playerWeapon.equals("Rock") && computerWeapon.equals("Scissors")) {
            rv.setText("Player wins ... Rock beats Scissors!");
            playerScore++;
        }

        if(playerWeapon.equals("Rock") && computerWeapon.equals("Paper")) {
            rv.setText("Computer wins ... Paper beats Rock!");
            computerScore++;
        }

        if(playerWeapon.equals("Paper") && computerWeapon.equals("Scissors")) {
            rv.setText("Computer wins ... Scissors beats Paper!");
            computerScore++;
        }

        if(playerWeapon.equals("Paper") && computerWeapon.equals("Rock")) {
            rv.setText("Player wins ... Paper beats Rock!");
            playerScore++;
        }

        if(playerWeapon.equals("Scissors") && computerWeapon.equals("Rock")) {
            rv.setText("Computer wins ... Rock beats Scissors!");
            computerScore++;
        }

        if(playerWeapon.equals("Scissors") && computerWeapon.equals("Paper")) {
            rv.setText("Player wins ... Scissors beats Paper!");
            playerScore++;
        }

        sc.setText("Player: " + playerScore + ", Computer: " + computerScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
