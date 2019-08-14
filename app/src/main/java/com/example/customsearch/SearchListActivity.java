package com.example.customsearch;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.customsearch.api.ApiClient;
import com.example.customsearch.api.ApiInterface;
import com.example.customsearch.model.Item;
import com.example.customsearch.model.SearchResults;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchListActivity extends AppCompatActivity {
    private String query;


    RecyclerView recyclerView;
    ProgressBar progressBar, topProgressBar;
    TextView errorView;

    LinearLayoutManager linearLayoutManager;
    SearchAdapter searchAdapter;
    List<Item> items = new ArrayList<>();

    private boolean loading = true;
    private int nextIndex = 0;
    private int startIndex = 1;
    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.search);
        }

        query = getIntent().getStringExtra(Constants.KEY_QUERY);

        recyclerView = findViewById(R.id.recyclerview);
        topProgressBar = findViewById(R.id.top_progress_bar);
        progressBar = findViewById(R.id.progress_bar);
        errorView = findViewById(R.id.error_view);

        setAdapter();
        getData();

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();

                    if (!loading && nextIndex > 0) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            startIndex = nextIndex;
                            getData();
                        }
                    }
                }
            }
        });
    }

    private void setAdapter() {
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        searchAdapter = new SearchAdapter(this, items);
        recyclerView.setAdapter(searchAdapter);
    }

    private void getData() {
        loading = true;
        if (startIndex == 1)
            topProgressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.VISIBLE);

        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<SearchResults> call = apiInterface.getSearchResults(query, Constants.CX_KEY, Constants.API_KEY, startIndex);
        call.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                loading = false;
                dismissProgressBar();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getItems() != null) {
                            if (response.body().getItems().size() > 0) {

                                items.addAll(response.body().getItems());
                                searchAdapter.notifyDataSetChanged();
                            } else {
                                errorView.setVisibility(View.VISIBLE);
                                errorView.setText(R.string.no_results);
                            }
                        } else {
                            errorView.setVisibility(View.VISIBLE);
                            errorView.setText(R.string.no_results);
                        }

                        if (response.body().getQueries().getNextPage() != null)
                            nextIndex = response.body().getQueries().getNextPage().get(0).getStartIndex();
                        else
                            nextIndex = 0;
                    }
                } else {
                    dismissProgressBar();
                    errorView.setVisibility(View.VISIBLE);
                    errorView.setText(R.string.api_error_msg);
                }
            }

            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                dismissProgressBar();
                errorView.setVisibility(View.VISIBLE);
                errorView.setText(R.string.api_error_msg);
            }
        });
    }

    private void dismissProgressBar() {
        topProgressBar.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
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
