package com.example.bardmenor.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bardmenor.R
import com.example.bardmenor.model.CardapioItens

class AdapterCardapio (private val context: Context, private val CardapioItens: MutableList<CardapioItens>): RecyclerView.Adapter<AdapterCardapio.CardapioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardapioViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.cardapio_items,parent, false)
        val holder = CardapioViewHolder(itemLista)
        return holder;
    }

    override fun onBindViewHolder(holder: CardapioViewHolder, position: Int) {
        holder.foto.setImageResource(CardapioItens[position].foto)
        holder.nome.text = CardapioItens[position].nome
        holder.descricao.text = CardapioItens[position].descricao
        holder.preco.text = CardapioItens[position].marcarloc
    }

    override fun getItemCount(): Int = CardapioItens.size

    inner class CardapioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.fotoItem)
        val nome = itemView.findViewById<TextView>(R.id.nomeItem)
        val descricao = itemView.findViewById<TextView>(R.id.descItem)
        val preco = itemView.findViewById<TextView>(R.id.precoItem)
    }
}