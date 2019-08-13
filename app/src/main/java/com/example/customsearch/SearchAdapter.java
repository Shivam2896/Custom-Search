package com.example.customsearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.customsearch.model.Item;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MainViewHolder> {
    final private Context context;
    final private List<Item> items;

    SearchAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_layout, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        String url = null;
        if (items.get(i).getPagemap() != null) {
            if (items.get(i).getPagemap().getCseThumbnail() != null) {
                url = items.get(i).getPagemap().getCseThumbnail().get(0).getSrc();
            }
            else if (items.get(i).getPagemap().getCseImage() != null)
                url = items.get(i).getPagemap().getCseImage().get(0).getSrc();
        }

        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(mainViewHolder.image);

        mainViewHolder.textView.setText(items.get(i).getSnippet());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView textView;

        MainViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
