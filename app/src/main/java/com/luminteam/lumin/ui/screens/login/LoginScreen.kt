package com.luminteam.lumin.ui.screens.login

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.firebase.auth.GoogleAuthProvider
import com.luminteam.lumin.SignInViewModel
import com.luminteam.lumin.ui.screens.login.components.LoginButton
import com.luminteam.lumin.ui.screens.login.components.LoginHeader
import com.luminteam.lumin.ui.screens.login.components.LoginTerms
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminTheme
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: SignInViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val tokenServer = "1014647136831-hqobcchp6vbhl0rpvfqtpfjmk5jb8bj2.apps.googleusercontent.com"
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts
            .StartActivityForResult()
    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)

        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            val serverAuthCode: String? = account.serverAuthCode

            if (serverAuthCode != null) {
                Log.d("Autenticacion", "Server Auth Code obtenido: $serverAuthCode")

                scope.launch {
                    viewModel.authenticateWithServerAuthCode(serverAuthCode)
                }


                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                viewModel.signInWithGoogleCredential(credential) {
                    // navegar a otra pantalla
                }
            }
        } catch (e: ApiException) {
            Log.d("Autenticacion", "Error de autenticacion: ${e.message}")
        }
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(LuminBackground)
            .fillMaxSize()
    ) {
        LoginHeader()
        Spacer(modifier = Modifier.height(28.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginButton() {
                val options = GoogleSignInOptions.Builder(
                    GoogleSignInOptions.DEFAULT_SIGN_IN
                )
                    // no estoy seguro
                    .requestIdToken(tokenServer)
                    .requestEmail()
                    .requestProfile()
                    .requestScopes(
                        Scope("https://www.googleapis.com/auth/user.birthday.read")
                    )
                    .requestServerAuthCode(tokenServer, true)
                    .build()

                val googleSignInClient = GoogleSignIn.getClient(context, options)

                launcher.launch(googleSignInClient.signInIntent)
            }
            Spacer(modifier = Modifier.height(12.dp))
            LoginTerms()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LoginScreenPreview() {
    LuminTheme {
        LoginScreen()
    }
}