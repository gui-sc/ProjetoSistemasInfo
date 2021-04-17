package com.guilherme.projetosistemasinfo.ui.login

import android.text.Editable
import androidx.lifecycle.ViewModel
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.guilherme.projetosistemasinfo.data.Pessoa
import com.guilherme.projetosistemasinfo.data.User

class LoginViewModel : ViewModel() {


    private val _currentScreen = MutableLiveData<Int>().apply {
        value = 0
    }

    val currentScreen: LiveData<Int> = _currentScreen
    fun trocarTela() {
        _currentScreen.value = 1
    }



    private val user: User

    init {
        this.user = User("", "")
    }

    val userTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setUser(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    fun onLoginClicked(v: View) {
        if (user.isDataValid) {
            trocarTela()
        }
    }

    //MAIN VIEW MODEL

    private var pessoa: Pessoa
    private val _list = MutableLiveData<List<Pessoa>>().apply {
        value = emptyList()
    }
    val list: LiveData<List<Pessoa>> = _list


    private val _adicionou = MutableLiveData<Boolean>().apply {
        value = true
    }
    val adicionou: LiveData<Boolean> = _adicionou


    private val _listaVisivel = MutableLiveData<Boolean>().apply {
        value = false
    }
    val listaVisivel: LiveData<Boolean> = _listaVisivel


    init {
        this.pessoa = Pessoa(0, "", "", "", "", "")
    }

    val codTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(!s.toString().isEmpty()){
                pessoa.setCod(s.toString().toInt())}
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }
    val nomeTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                pessoa.setNome(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    val cpfTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                pessoa.setCpf(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    val endTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                pessoa.setEnd(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    val telTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                pessoa.setTel(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    val obsTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                pessoa.setObs(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    fun onClickButton(v: View) {
        if (!this.pessoa.getNome().isEmpty() && !this.pessoa.getCpf().isEmpty()) {
            val pes:Pessoa = this.pessoa
            this.pessoa = Pessoa(0,"","","","","")
            _list.value = _list.value!!.plus(pes)
        }else{
            _adicionou.value = false
            _adicionou.value = true
        }
    }

    fun onListaClick(v: View){
        _listaVisivel.value = !_listaVisivel.value!!
    }


}