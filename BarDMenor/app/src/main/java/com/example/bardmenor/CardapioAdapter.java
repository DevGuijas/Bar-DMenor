package com.example.bardmenor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bardmenor.model.CardapioItens;

import java.util.List;

public class CardapioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<SectionItem> sectionItemList;

    public CardapioAdapter(List<SectionItem> sectionItemList) {
        this.sectionItemList = sectionItemList;
    }

    @Override
    public int getItemViewType(int position) {
        return sectionItemList.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SectionItem.TYPE_SECTION) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_header, parent, false);
            return new SectionViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardapio_item, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SectionViewHolder) {
            ((SectionViewHolder) holder).bind(sectionItemList.get(position).getSectionTitle());
        } else if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).bind(sectionItemList.get(position).getItem());
        }
    }

    @Override
    public int getItemCount() {
        return sectionItemList.size();
    }

    // ViewHolder para seção
    static class SectionViewHolder extends RecyclerView.ViewHolder {
        private TextView sectionTitle;

        public SectionViewHolder(View itemView) {
            super(itemView);
            sectionTitle = itemView.findViewById(R.id.section_title);
        }

        public void bind(String title) {
            sectionTitle.setText(title);
        }
    }

    // ViewHolder para item normal
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemName, itemDesc, itemPrice;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemDesc = itemView.findViewById(R.id.item_desc);
            itemPrice = itemView.findViewById(R.id.item_price);
        }

        public void bind(CardapioItens item) {
            itemImage.setImageResource(item.getFoto());
            itemName.setText(item.getNome());
            itemDesc.setText(item.getDescricao());
            itemPrice.setText(item.getMarcarloc());
        }
    }
}

