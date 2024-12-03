package com.admin.finalexamapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;  // Import ArrayList

public class ApetizerActivity extends Activity {
    // Use ArrayList to store selected items dynamically
    ArrayList<String> selectedItems = new ArrayList<>();// Use ArrayList to store selected items dynamically
    ArrayList<String> PriceofSelectedItem = new ArrayList<>();


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.appetizerpage_new2);

        // Initialize ImageView and CheckBox pairs
        setupToggle(R.id.set1, R.id.check1);
        setupToggle(R.id.set2, R.id.check2);
        setupToggle(R.id.set3, R.id.check3);
        setupToggle(R.id.set4, R.id.check4);
        setupToggle(R.id.set5, R.id.check5);
        setupToggle(R.id.set6, R.id.check6);
        setupToggle(R.id.set7, R.id.check7);

        // Initialize CheckBoxes
        CheckBox check1 = findViewById(R.id.check1);
        CheckBox check2 = findViewById(R.id.check2);
        CheckBox check3 = findViewById(R.id.check3);
        CheckBox check4 = findViewById(R.id.check4);
        CheckBox check5 = findViewById(R.id.check5);
        CheckBox check6 = findViewById(R.id.check6);
        CheckBox check7 = findViewById(R.id.check7);

        // Retrieve item names from resources
        String item1 = getString(R.string.Apet1);
        String item2 = getString(R.string.Apet2);
        String item3 = getString(R.string.Apet3);
        String item4 = getString(R.string.Apet4);
        String item5 = getString(R.string.Apet5);
        String item6 = getString(R.string.Apet6);
        String item7 = getString(R.string.Apet7);

        // Handle the "Add to Orders" button click
        Button addToOrdersButton = findViewById(R.id.addorderapet);
        addToOrdersButton.setOnClickListener(v -> {
            selectedItems.clear();  // Clear previous selections
            selectedItems.add("Appetizer");
            PriceofSelectedItem.clear();
            PriceofSelectedItem.add("Price"); // Add category name first

            CheckBox[] checkBoxes = {check1,check2, check3, check4, check5, check6, check7};
            String[] items = {item1,item2, item3, item4, item5, item6, item7};
            String[] prices = {"50","80","120","30","130","20","60"};


            for (int i = 0; i < checkBoxes.length; i++) {
                if (checkBoxes[i].isChecked()) {
                    selectedItems.add(items[i]);
                    PriceofSelectedItem.add(prices[i]);
                }
            }

            // Show confirmation toast
            Toast.makeText(ApetizerActivity.this, "Ordered Successfully", Toast.LENGTH_SHORT).show();

            // Pass the selected items to the SummaryActivity
            Intent newIntent = new Intent(ApetizerActivity.this, ConfirmedSplashActivity.class);
            newIntent.putStringArrayListExtra("selectedItems", selectedItems);
            newIntent.putStringArrayListExtra("Price", PriceofSelectedItem);
            startActivity(newIntent);
        });

        // Handle the "Go Back" button click
        Button goBackButton = findViewById(R.id.GObackapet);
        goBackButton.setOnClickListener(v -> {
            Intent backIntent = new Intent(ApetizerActivity.this, SelectionPage.class);
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