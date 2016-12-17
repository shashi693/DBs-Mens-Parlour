package com.avenueinfotech.dbmensparlour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UpdateActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        button = (Button) findViewById(R.id.button);
        ituo();

    }

    private void ituo() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oppoint = new Intent(UpdateActivity.this, BookActivity.class);
                startActivity(oppoint);
            }
        });
    }


}
