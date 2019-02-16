package br.com.thaislima.jokenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val GELO = 1
    val AGUA = 2
    val TERRA = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivGelo.setOnClickListener {
            realizarJogada(GELO)

        }

        ivAgua.setOnClickListener {
            realizarJogada(AGUA)

        }

        ivTerra.setOnClickListener {
            realizarJogada(TERRA)
        }
    }

    fun configuraImagemDaJogada(jogada: Int, imageView: ImageView){
        when(jogada) {
            TERRA-> configuraImagem(R.drawable.clefairy, imageView)
            AGUA->  configuraImagem(R.drawable.wartortle, imageView)
            GELO->  configuraImagem(R.drawable.dewong, imageView)

        }
    }

    fun configuraImagem(resourceID: Int, imageView: ImageView){
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resourceID))
    }

    fun realizarJogada (jogadaUsuario : Int) {
        val jogadaAdversario = Random().nextInt(3) + 1

        configuraImagemDaJogada(jogadaUsuario, ivVoce)
        configuraImagemDaJogada(jogadaAdversario, ivAndroid)
        when (jogadaUsuario) {
            TERRA-> {
                when (jogadaAdversario){
                    TERRA -> (empate())
                    AGUA -> (vitoria())
                    GELO -> (derrota())
                }
            }

            GELO-> {
                when (jogadaAdversario) {
                    TERRA -> (vitoria())
                    AGUA -> (derrota())
                    GELO -> (empate())
                }
            }

            AGUA-> {
                when(jogadaAdversario) {
                    TERRA -> (derrota())
                    AGUA -> (empate())
                    GELO-> (derrota())
            }
        }
    }
}


    fun vitoria() {
        tvResultado.text = "Você venceu!! Aí sim, rapaz!!"
    }

    fun empate(){
        tvResultado.text = "Você empatou, poxa."
    }

    fun derrota(){
        tvResultado.text = "É amigo. Não foi dessa vez."
    }
}
