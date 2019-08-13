package com.example.customsearch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.customsearch.model.Item;

import net.cachapa.expandablelayout.ExpandableLayout;

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
        mainViewHolder.expandableLayout.collapse();
        mainViewHolder.arrow.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_arrow_drop_down));

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
        mainViewHolder.expandedText.setText(items.get(i).getSnippet());

        if (items.get(i).isExpanded()) {
            mainViewHolder.expandableLayout.expand();
            mainViewHolder.arrow.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_arrow_drop_up));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
        ImageView image, arrow;
        TextView textView, expandedText;
        ExpandableLayout expandableLayout;

        MainViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            arrow = itemView.findViewById(R.id.arrow);
            textView = itemView.findViewById(R.id.title);
            expandedText = itemView.findViewById(R.id.expanded_text);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            expandableLayout.setInterpolator(new OvershootInterpolator());
            expandableLayout.setOnExpansionUpdateListener(this);

            arrow.setOnClickListener(this);

            itemView.setOnClickListener( v-> {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(Constants.KEY_DATA, items.get(getAdapterPosition()));
                context.startActivity(intent);
            });
        }

        @Override
        public void onExpansionUpdate(float expansionFraction, int state) {

        }

        @Override
        public void onClick(View v) {
            items.get(getAdapterPosition()).setExpanded(!(items.get(getAdapterPosition()).isExpanded()));
            notifyItemChanged(getAdapterPosition());
        }
    }
}
