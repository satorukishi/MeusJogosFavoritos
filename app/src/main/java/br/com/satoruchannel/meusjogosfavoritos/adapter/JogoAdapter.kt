package br.com.satoruchannel.meusjogosfavoritos.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.content.ContextCompat
import br.com.satoruchannel.meusjogosfavoritos.model.Jogo
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.satoruchannel.meusjogosfavoritos.R
import kotlinx.android.synthetic.main.meu_jogo_item.view.*

class JogoAdapter(val context: Context, val jogos:  List<Jogo>,
                  val listener: (Jogo) -> Unit,
                  val listenerDelete: (Jogo) -> Unit) : RecyclerView.Adapter<JogoAdapter.JogoViewHolder>() {
    // Implementar os métodos nessa ordem: getItemCount, onCreateViewHolder, onBindViewHolder

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JogoViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.meu_jogo_item, parent, false)

        return JogoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JogoViewHolder?, position: Int) {
        val jogo = jogos[position]
        holder?.let {
            holder.bindView(jogo, listener, listenerDelete)
        }
    }


    class JogoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("StringFormatMatches")
        fun bindView(jogo: Jogo, listener: (Jogo) -> Unit, listenerDelete: (Jogo) -> Unit) = with(itemView) {
            tvTitulo.text = jogo.titulo
            tvDescricao.text = jogo.descricao
            ivFoto.setImageDrawable(ContextCompat.getDrawable(context, jogo.fotoId))
            tvLancamento.text = context.getString(R.string.lancamento, jogo.anoLancamento)

            ivDelete.setOnClickListener {listenerDelete(jogo)}
            setOnClickListener { listener(jogo) }
        }
    }
}
