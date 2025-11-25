package com.luminteam.lumin.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.luminteam.lumin.data.repository.LoginRepository
import com.luminteam.lumin.services.luminapi.dto.AuthCode
import com.luminteam.lumin.services.luminapi.repositories.authRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

val ktorClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        json()
    }
}

@Serializable
data class GoogleAuthRequest(
    val code: String // El serverAuthCode enviado por la app de Android
)

@Serializable
data class AuthResponse(
    val message: String,
)

class SignInViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val loading = MutableLiveData(false)

    fun authenticateWithServerAuthCode(serverAuthCode: String) {
        viewModelScope.launch {
            val loginResult = authRepository.postGoogleLogin(AuthCode(serverAuthCode))
            loginRepository.saveJWT(loginResult.token)
        }
    }


    companion object {
        fun provideFactory(repository: LoginRepository): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    SignInViewModel(repository)
                }
            }
    }
}