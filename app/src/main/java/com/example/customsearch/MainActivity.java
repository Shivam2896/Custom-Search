package com.example.customsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.customsearch.Constants.KEY_QUERY;

public class MainActivity extends AppCompatActivity {

    EditText searchText;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchText = findViewById(R.id.search_text);
        searchButton = findViewById(R.id.search_button);

        searchText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_search, 0);

        searchText.setOnTouchListener((v, event) -> {
            int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (searchText.getCompoundDrawables()[DRAWABLE_RIGHT] != null) {
                    if (event.getRawX() >= searchText.getRight() - searchText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width()) {
                        validate();
                    }
                }
            }
            return false;
        });

        searchButton.setOnClickListener(v -> {
            validate();
        });
    }

    private void validate() {
        if (TextUtils.isEmpty(searchText.getText()))
            searchText.setError(getResources().getString(R.string.search_query_error_msg));
        else {
            Intent intent = new Intent(MainActivity.this, SearchListActivity.class);
            intent.putExtra(KEY_QUERY, searchText.getText().toString());
            startActivity(intent);
        }
    }
}
