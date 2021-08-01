package com.example.varioscomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
 import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.varioscomposer.ui.theme.BorrrarrrrTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            BorrrarrrrTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   // columnas()
                    //boton()
                    val cal= calculo()
                    cal.calcula()

                }
            }
        }
    }
}


@Composable
fun boton() {
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember() {
        mutableStateOf(value = "" )
    }
    val scope= rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState

    ) {
        Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ){
                    TextField(
                        value = textFieldState,
                        label = {
                            Text(text = "Nombre")
                        },
                        onValueChange = {
                            textFieldState=it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()


                    )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(textFieldState)
                    }

                 }) {
                        Text(text = "Pulsar")

            }

        }
    }
}



@Composable
fun filas() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .border(border = BorderStroke(width = 2.dp, color = Color.Red))
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
    }

}


@Composable
fun columnas() {
    val scrollState = rememberScrollState()
    Column (modifier =
    Modifier
        .verticalScroll(state = scrollState)
        .fillMaxSize()
        .background(color = Color(0xFF606060))
    ){



        Image(painter = painterResource(id = R.drawable.nosferatu),
            contentDescription = null,
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillBounds)
        Column(modifier = Modifier

            .background(Color.Blue)
            .fillMaxWidth()
        ) {

            Text(text = "Nosferatu",  fontSize = 30.sp)
            for (i in 1..20) {
                Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

                Text(text = "Nosferatu"+i, fontSize = 20.sp)
            }
        }
        filas()


    }

}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BorrrarrrrTheme {
        //columnas()
        boton()
    }
}