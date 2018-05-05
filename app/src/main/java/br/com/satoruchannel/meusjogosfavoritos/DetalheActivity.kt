package br.com.satoruchannel.meusjogosfavoritos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import br.com.satoruchannel.meusjogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.activity_detalhe.*
import kotlinx.android.synthetic.main.meu_jogo_item.*

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)
        setSupportActionBar(toolbar)

        // Botão Voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val jogo = intent.getParcelableExtra<Jogo>("jogo")
        toolbar_layout.title = jogo.titulo

        ivBanner.setImageDrawable(ContextCompat.getDrawable(this, jogo.bannerId))

        tvDescricao.text = jogo.descricao

        fab.setOnClickListener { view ->
            try {
                val whatsAppMessage = "Olá meu jogo preferido é ${jogo.titulo}"// Replace with your message.
                val sendIntent = Intent()

//                // Mandar mensagem para apenas uma pessoa
//                val toNumber = "55119XXXXXXXX"
//                sendIntent.action = Intent.ACTION_VIEW
//                sendIntent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=whatsAppMessage")

                // Mandar mensagem para várias pessoas
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, whatsAppMessage)
                sendIntent.type = "text/plain"
                sendIntent.`package` = "com.whatsapp"


                startActivity(sendIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    // Programação do Botão Voltar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
