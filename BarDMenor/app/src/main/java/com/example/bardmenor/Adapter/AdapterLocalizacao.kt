package com.example.bardmenor.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bardmenor.R
import com.example.bardmenor.model.Localizacao

class AdapterLocalizacao(private val context: Context, private val localizacoes: MutableList<Localizacao>): RecyclerView.Adapter<AdapterLocalizacao.LocalizacaoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalizacaoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.localizacoes_items,parent, false)
        val holder = LocalizacaoViewHolder(itemLista)
        return holder;
    }

    override fun onBindViewHolder(holder: LocalizacaoViewHolder, position: Int) {
        holder.foto.setImageResource(localizacoes[position].foto)
        holder.nome.text = localizacoes[position].nome
        holder.descricao.text = localizacoes[position].descricao
        holder.marcarloc.text = localizacoes[position].marcarloc
    }

    override fun getItemCount(): Int = localizacoes.size

    inner class LocalizacaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.fotoLocalizacao)
        val nome = itemView.findViewById<TextView>(R.id.nomeLocalizacao)
        val descricao = itemView.findViewById<TextView>(R.id.descricaoLocalizacao)
        val marcarloc = itemView.findViewById<TextView>(R.id.marcarLocalizacao)
    }
}