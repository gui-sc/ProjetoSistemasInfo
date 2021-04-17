package com.guilherme.projetosistemasinfo.data

import android.text.TextUtils
import androidx.databinding.BaseObservable

class Pessoa(
    private var cod: Number,
    private var nome: String,
    private var cpf: String,
    private var end: String,
    private var tel: String,
    private var obs: String
) : BaseObservable() {

    val isDataValid: Boolean get() = (!TextUtils.isEmpty(getNome()) || !TextUtils.isEmpty(getCpf()))

    fun getCod(): Number {
        return cod;
    }

    fun setCod(cod: Number) {
        this.cod = cod;
    }

    fun getNome(): String {
        return nome
    }

    fun setNome(nome: String) {
        this.nome = nome;
    }

    fun getCpf(): String {
        return cpf;
    }

    fun setCpf(cpf: String) {
        this.cpf = cpf;
    }

    fun getEnd(): String {
        return end;
    }

    fun setEnd(end: String) {
        this.end = end;
    }

    fun getTel(): String {
        return tel;
    }

    fun setTel(tel: String) {
        this.tel = tel;
    }

    fun getObs(): String {
        return obs;
    }

    fun setObs(obs: String) {
        this.obs = obs;
    }

    override fun toString(): String {
        var texto: String = ""
        if(cod != 0){
            texto += "$cod\n$nome\n$cpf"
        }else{
            texto += "$nome\n$cpf"
        }
        if(!end.isEmpty()){
            texto += "\n$end"
        }
        if(!tel.isEmpty()){
            texto += "\n$tel"
        }
        if(!obs.isEmpty()){
            texto += "\n$obs"
        }

        return texto
    }

}
