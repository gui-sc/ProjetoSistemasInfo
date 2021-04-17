package com.guilherme.projetosistemasinfo.data

import androidx.databinding.BaseObservable

class User(
    private var user: String,
    private var password: String
) : BaseObservable() {
    val isDataValid: Boolean get() = (getUser() == "SISTEMA" || getPassword() == "candidato123")

    fun getUser(): String {
        return user;
    }

    fun setUser(user: String) {
        this.user = user;
    }

    fun getPassword(): String {
        return password;
    }

    fun setPassword(password: String) {
        this.password = password;
    }
}