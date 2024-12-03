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

public class DesertActivity extends Activity {
    ArrayList<String> selectedItems = new ArrayList<>();// Use ArrayList to store selected items dynamically
    ArrayList<String> PriceofSelectedItem = new ArrayList<>();

    @Override
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.desert_new);
        // Set up the toggle functionality for all 7 desserts
        setupToggle(R.id.dessertset1, R.id.dessertcheck1);
        setupToggle(R.id.dessertset2, R.id.dessertcheck2);
        setupToggle(R.id.dessertset3, R.id.dessertcheck3);
        setupToggle(R.id.dessertset4, R.id.dessertcheck4);
        setupToggle(R.id.dessertset5, R.id.dessertcheck5);
        setupToggle(R.id.dessertset6, R.id.dessertcheck6);
        setupToggle(R.id.dessertset7, R.id.dessertcheck7);


        CheckBox check1 = findViewById(R.id.dessertcheck1);
        CheckBox check2 = findViewById(R.id.dessertcheck2);
        CheckBox check3 = findViewById(R.id.dessertcheck3);
        CheckBox check4 = findViewById(R.id.dessertcheck4);
        CheckBox check5 = findViewById(R.id.dessertcheck5);
        CheckBox check6 = findViewById(R.id.dessertcheck6);
        CheckBox check7 = findViewById(R.id.dessertcheck7);

        String item1 = getString(R.string.dessert1);
        String item2 = getString(R.string.dessert2);
        String item3 = getString(R.string.dessert3);
        String item4 = getString(R.string.dessert4);
        String item5 = getString(R.string.dessert5);
        String item6 = getString(R.string.dessert6);
        String item7 = getString(R.string.dessert7);



        Button Plaxceorder = findViewById(R.id.placeorderdessert);
        Plaxceorder.setOnClickListener(v -> {
            selectedItems.clear();  // Clear previous selections
            selectedItems.add("Dessert");
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
            Toast.makeText(DesertActivity.this, "Ordered Successfully", Toast.LENGTH_SHORT).show();

            // Pass the selected items to the SummaryActivity
            Intent newIntent = new Intent(DesertActivity.this, ConfirmedSplashActivity.class);
            newIntent.putStringArrayListExtra("selectedItems", selectedItems);
            newIntent.putStringArrayListExtra("Price", PriceofSelectedItem);
            startActivity(newIntent);

        });
        Button gobalc = findViewById(R.id.gobackdesertcvmnbfvcn);
        gobalc.setOnClickListener(v -> {
            Intent backIntent = new Intent(DesertActivity.this, SelectionPage.class);
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
