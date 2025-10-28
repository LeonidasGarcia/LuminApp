package com.luminteam.lumin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

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

class SignInViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun signInWithGoogleCredential(credential: AuthCredential, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("Autenticacion", "Firebase signInWithCredential: Success")
                            home()
                        }
                    }
                    .addOnFailureListener {
                        Log.d("Autenticacion", "Fallo al loguear con google")
                    }
            } catch (ex: Exception) {
                Log.d("Excepcion", "Excepcion  al loguear con google" + "${ex.localizedMessage}")
            }
        }

    suspend fun authenticateWithServerAuthCode(serverAuthCode: String) {
        val requestBody = GoogleAuthRequest(serverAuthCode)

        try {
            val response = ktorClient.post("http://10.0.2.2:3000/auth/google-login") {
                contentType(io.ktor.http.ContentType.Application.Json)
                setBody(requestBody)
            }

            if (response.status.isSuccess()) {
                Log.d("Autenticacion", "Response: ${response.body<AuthResponse>()}")
            } else {
                val errorBody = response.body<String>() // Puedes leer el cuerpo del error
                throw Exception("Fallo en el backend: ${response.status.value} - $errorBody")
            }

        } catch (e: Exception) {
            // Manejar fallos de red o excepciones lanzadas por Ktor
            Log.d("Autenticacion", "No se pudo conectar al servidor: ${e.message}")
        }
    }
}