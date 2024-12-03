package com.admin.finalexamapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SelectionPage extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.selection_page);
        Button Apet = findViewById(R.id.Appetizer);
        Button MainC = findViewById(R.id.mainC);
        Button Dinn = findViewById(R.id.Dinner);


        Apet.setOnClickListener(v -> {
            Intent intent = new Intent(SelectionPage.this, ApetizerActivity.class);
            startActivity(intent);
            finish();

        });
        MainC.setOnClickListener(v -> {

            Intent intent = new Intent(SelectionPage.this, MainCourseActivity.class);
            startActivity(intent);
            finish();
        });
        Dinn.setOnClickListener(v -> {
            Intent intent = new Intent(SelectionPage.this, DesertActivity.class);
            startActivity(intent);
            finish();
        });




    }
}
