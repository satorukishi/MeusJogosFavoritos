package br.com.satoruchannel.meusjogosfavoritos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.satoruchannel.meusjogosfavoritos.adapter.JogoAdapter
import br.com.satoruchannel.meusjogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        rvJogos.adapter = JogoAdapter(this, getJogos(), {
            val intentDetalhe = Intent(this, DetalheActivity::class.java)

            intentDetalhe.putExtra("jogo", it)

            startActivity(intentDetalhe)
        }, {
            // Chamar WebService que deleta o item
            // Recarregar a lista
        })
        rvJogos.layoutManager = LinearLayoutManager(this)
    }

    fun getJogos() : List<Jogo> {
        return listOf(Jogo(getString(R.string.titulo_super_mario_odyssey),
                                getString(R.string.descricao_super_mario_odyssey),
                                2017,
                                R.drawable.super_mario_odyssey,
                                R.drawable.super_mario_odyssey_detalhe))
    }
}
