package cl.stgoneira.learning.android.navegacioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.buildAnnotatedString
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navController) {
                NavHost(navController = navController, startDestination = "inicio") {
                    composable("inicio") { UIInicio() }
                    composable("uno") { UIUno() }
                    composable("dos"){ UIDos() }
                }
            }
        }
    }
}

val LocalNavController = compositionLocalOf<NavController> { error("No se ha proporcionado NavController") }

@Composable
fun UIInicio() {
    val navController = LocalNavController.current
    ClickableText(text = buildAnnotatedString { append("Inicio")  }, onClick = {
        navController.navigate("uno")
    })
}

@Composable
fun UIUno() {
    val navController = LocalNavController.current
    ClickableText(text = buildAnnotatedString { append("Uno")  }, onClick = {
        navController.navigate("dos")
    })
}

@Composable
fun UIDos() {
    Text("Dos")
}
