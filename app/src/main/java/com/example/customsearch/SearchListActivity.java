package com.example.customsearch;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    //created new api keys
    private static String CX_KEY = "006920662228794587734:f4yen7_8ndm";
    private static String API_KEY = "AIzaSyCHB_YIt7CgxqeMx7RdG9XRs9EAVlOHv5Q";

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

        query = getIntent().getStringExtra(MainActivity.KEY_QUERY);

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progress_bar);
        topProgressBar = findViewById(R.id.top_progress_bar);
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
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
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

        Call<SearchResults> call = apiInterface.getSearchResults(query, CX_KEY, API_KEY, startIndex);
        call.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                loading = false;
                dismissProgressBar();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getItems() != null) {
                            items.addAll(response.body().getItems());
                            searchAdapter.notifyDataSetChanged();
                        }

                        if (response.body().getQueries().getNextPage() != null)
                            nextIndex = response.body().getQueries().getNextPage().get(0).getStartIndex();
                        else
                            nextIndex = 0;
                    }
                } else {
                    dismissProgressBar();
                    errorView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                dismissProgressBar();
                errorView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void dismissProgressBar() {
        topProgressBar.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }
}
