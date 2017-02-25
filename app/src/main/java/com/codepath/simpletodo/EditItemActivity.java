package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private EditText etItem;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItem = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        String editText = intent.getStringExtra(MainActivity.EXTRA_STRING);
        position = intent.getIntExtra(MainActivity.EXTRA_POS,0);

        etItem.setText(editText);
    }

    public void onSaveItem(View view){
        String newItemText = etItem.getText().toString();
        Intent data = new Intent();
        data.putExtra(MainActivity.EXTRA_STRING, newItemText);
        data.putExtra(MainActivity.EXTRA_POS, position);
        setResult(RESULT_OK, data);
        finish();
    }
}
