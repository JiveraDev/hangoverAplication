package com.admin.finalexamapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;  // Import ArrayList
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.HashMap;
import android.widget.SimpleAdapter;
public class ConfirmedSplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmedsplash);

        Intent intent = getIntent();
        ArrayList<String> selectedItems = intent.getStringArrayListExtra("selectedItems");
        ArrayList<String> prices = intent.getStringArrayListExtra("Price");
        ListView selectedListView = findViewById(R.id.selectedlistView);

// Create a list to hold the combineddata
        ArrayList<HashMap<String, String>> combinedData = new ArrayList<>();

// Combine selectedItems and prices into a single list of HashMaps
        for (int i = 0; i < selectedItems.size(); i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("item", selectedItems.get(i));
            item.put("price", prices.get(i));
            combinedData.add(item);
        }

// Create a SimpleAdapter to display the combined data
        SimpleAdapter adapter = new SimpleAdapter(
                this,combinedData,
                R.layout.layoutlistview, // Your custom row layout
                new String[]{"item", "price"}, // Keys from the HashMap
                new int[]{R.id.text1, R.id.text2} // IDs of the TextViews in your layout
        );

        selectedListView.setAdapter(adapter);

        int totalValue = 0;
        ArrayList<Integer> priceIntegers = new ArrayList<>();
        for (int i = 1; i < prices.size(); i++) {
            try {
                int priceInt = Integer.parseInt(prices.get(i));  // Convert string to int
                priceIntegers.add(priceInt);  // Add the integer to the new list
                totalValue += priceInt;  // Add the value to the total
            } catch (NumberFormatException e) {
                // Handle the case where the price string is not a valid integer
                e.printStackTrace();  // You can log the error or handle it as needed
            }
        }
        TextView total = findViewById(R.id.totalPrice);
        total.setText(totalValue + "Php");


        Button ConfirmButton = findViewById(R.id.ConfirmButton);
        ConfirmButton.setOnClickListener(v ->  {

                // Create an Intent to navigate to another activity
                Intent iw3wntent = new Intent(ConfirmedSplashActivity.this, SelectionPage.class);
                // Start the next activity
                startActivity(iw3wntent);
                finish();




        });

    }
}

