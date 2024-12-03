package com.admin.finalexamapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainCourseActivity extends Activity {
    ArrayList<String> selectedItems = new ArrayList<>();// Use ArrayList to store selected items dynamically
    ArrayList<String> PriceofSelectedItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.maincourse_new);
        // Initialize ImageView and CheckBox pairs

        // Initialize ImageView and CheckBox pairs for 7 items
        setupToggle(R.id.mainset1, R.id.maincheck1);
        setupToggle(R.id.mainset2, R.id.maincheck2);
        setupToggle(R.id.mainset3, R.id.maincheck3);
        setupToggle(R.id.mainset4, R.id.maincheck4);
        setupToggle(R.id.mainset5, R.id.maincheck5);
        setupToggle(R.id.mainset6, R.id.maincheck6);
        setupToggle(R.id.mainset7, R.id.maincheck7);

        CheckBox check1 = findViewById(R.id.maincheck1);
        CheckBox check2 = findViewById(R.id.maincheck2);
        CheckBox check3 = findViewById(R.id.maincheck3);
        CheckBox check4 = findViewById(R.id.maincheck4);
        CheckBox check5 = findViewById(R.id.maincheck5);
        CheckBox check6 = findViewById(R.id.maincheck6);
        CheckBox check7 = findViewById(R.id.maincheck7);

        String item1 = getString(R.string.Mainc1);
        String item2 = getString(R.string.Mainc2);
        String item3 = getString(R.string.Mainc3);
        String item4 = getString(R.string.Mainc4);
        String item5 = getString(R.string.Mainc5);
        String item6 = getString(R.string.Mainc6);
        String item7 = getString(R.string.Mainc7);


        Button Plaxceorder = findViewById(R.id.addordermain);
         Plaxceorder.setOnClickListener(v -> {
             selectedItems.clear();  // Clear previous selections
             selectedItems.add("Main Course");
             PriceofSelectedItem.clear();
             PriceofSelectedItem.add("Price"); // Add category name first

             CheckBox[] checkBoxes = {check1,check2, check3, check4, check5, check6, check7};
             String[] items = {item1,item2, item3, item4, item5, item6, item7};
             String[] prices = {"250", "220", "300", "180", "230", "290", "270"};



             for (int i = 0; i < checkBoxes.length; i++) {
                 if (checkBoxes[i].isChecked()) {
                     selectedItems.add(items[i]);
                     PriceofSelectedItem.add(prices[i]);
                 }
             }

             // Show confirmation toast
             Toast.makeText(MainCourseActivity.this, "Ordered Successfully", Toast.LENGTH_SHORT).show();

             // Pass the selected items to the SummaryActivity
             Intent newIntent = new Intent(MainCourseActivity.this, ConfirmedSplashActivity.class);
             newIntent.putStringArrayListExtra("selectedItems", selectedItems);
             newIntent.putStringArrayListExtra("Price", PriceofSelectedItem);
             startActivity(newIntent);

         });
        Button mainback = findViewById(R.id.GObackmain);
        mainback.setOnClickListener(v -> {
            Intent backIntent = new Intent(MainCourseActivity.this, SelectionPage.class);
            startActivity(backIntent);
            finish();
            // Close the current activity
        });

    }
    // Method to set up ImageView-CheckBox toggle functionality
    private void setupToggle(int imageViewId, int checkBoxId) {
        ImageView imageView = findViewById(imageViewId);
        CheckBox checkBox = findViewById(checkBoxId);

        // Initially hide the CheckBox
        checkBox.setVisibility(View.GONE);

        // Set click listener to toggle visibility and state
        imageView.setOnClickListener(v -> {
            if (checkBox.getVisibility() == View.VISIBLE) {
                checkBox.setVisibility(View.GONE);
                checkBox.setChecked(false);
            } else {
                checkBox.setVisibility(View.VISIBLE);
                checkBox.setChecked(true);
            }
        });
    }
}