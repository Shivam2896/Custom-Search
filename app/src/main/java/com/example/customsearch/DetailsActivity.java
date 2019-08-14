package com.example.customsearch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.customsearch.model.Item;

public class DetailsActivity extends AppCompatActivity {
    Item item;

    TextView titleHtml, snippetHtml, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.details);
        }

        item = getIntent().getParcelableExtra(Constants.KEY_DATA);

        titleHtml = findViewById(R.id.html_title);
        snippetHtml = findViewById(R.id.html_snippet);
        link = findViewById(R.id.link);

        if (!TextUtils.isEmpty(item.getHtmlTitle()))
            titleHtml.setText(Html.fromHtml(item.getHtmlTitle()));
        else titleHtml.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(item.getHtmlSnippet()))
            snippetHtml.setText(Html.fromHtml(item.getHtmlSnippet()));
        else snippetHtml.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(item.getLink())) {
            String text = item.getLink();
            SpannableString content = new SpannableString(text);
            content.setSpan(new UnderlineSpan(), 0, text.length(), 0);
            link.setText(content);

            link.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                startActivity(intent);
            });
        } else link.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
