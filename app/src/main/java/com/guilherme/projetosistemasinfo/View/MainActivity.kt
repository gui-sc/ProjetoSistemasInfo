package com.guilherme.projetosistemasinfo.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.guilherme.projetosistemasinfo.R
import com.guilherme.projetosistemasinfo.data.Pessoa
import com.guilherme.projetosistemasinfo.databinding.LoginFragmentBinding
import com.guilherme.projetosistemasinfo.ui.login.LoginViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activityMainBinding =
            DataBindingUtil.setContentView<LoginFragmentBinding>(this, R.layout.login_fragment)
        activityMainBinding.viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val layMain: LinearLayout = findViewById(R.id.main)
        val textCod: EditText = findViewById(R.id.cod)
        val textNome: EditText = findViewById(R.id.nome)
        val textCpf: EditText = findViewById(R.id.cpf)
        val textEnd: EditText = findViewById(R.id.end)
        val textTel: EditText = findViewById(R.id.tel)
        val textObs: EditText = findViewById(R.id.obs)
        val btnLista: Button = findViewById(R.id.lista)
        val layLogin: ConstraintLayout = findViewById(R.id.login)
        val rv: ListView = findViewById(R.id.rv_list)
        val layLista: LinearLayout = findViewById(R.id.listaContainer)
        val layCadastro: LinearLayout = findViewById(R.id.cadastro)
        val list: List<Pessoa> = ArrayList()
        val progressBar:ProgressBar = findViewById(R.id.progress_circular)
        var adapter: ArrayAdapter<Pessoa> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        rv.adapter = adapter
        viewModel.currentScreen.observe(this, Observer { screen ->
            when (screen) {
                1 -> {
                    progressBar.visibility = View.VISIBLE
                    layMain.visibility = View.VISIBLE
                    layLogin.visibility = View.GONE
                    progressBar.visibility = View.INVISIBLE
                }
            }
        })

        viewModel.list.observe(this, Observer { a ->
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, a)
            rv.adapter = adapter
            textCod.setText("")
            textNome.setText("")
            textCpf.setText("")
            textEnd.setText("")
            textObs.setText("")
            textTel.setText("")
        })

        viewModel.adicionou.observe(this, Observer { adic ->
            if (!adic) {
                Toast.makeText(this, "Nome e CPF são obrigatórios", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.listaVisivel.observe(this, Observer { visivel ->
            if (visivel) {
                layLista.visibility = View.VISIBLE
                layCadastro.visibility = View.GONE
            } else {
                layLista.visibility = View.GONE
                layCadastro.visibility = View.VISIBLE
            }
        })
    }


}