package com.example.varioscomposer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class calculo {

    @Composable
    fun calcula() {
        val scaffoldState = rememberScaffoldState()
        // tenemos que añadir
        // import androidx.compose.runtime.*
        var textFieldStateA by remember() {
            mutableStateOf(value = "" )
        }
        var textFieldStateB by remember() {
            mutableStateOf(value = "" )
        }
        val scope= rememberCoroutineScope()

        var resultado by remember { mutableStateOf("Resultado") }

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
                    value = textFieldStateA,
                    label = {
                        Text(text = "Primer número")
                    },
                    onValueChange = {
                        textFieldStateA=it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()


                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = textFieldStateB,
                    label = {
                        Text(text = "Segundo número")
                    },
                    onValueChange = {
                        textFieldStateB=it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()


                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {
                        val suma=(textFieldStateA.toString().toInt()+textFieldStateB.toString().toInt()).toString()
                        resultado=suma
                        scaffoldState.snackbarHostState.showSnackbar(suma)

                    }

                }) {
                    Text(text = "Pulsar")

                }

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = resultado,
                    onValueChange = { },
                    readOnly=true,


                    maxLines = 2,

                    textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                                .padding(20.dp)

                )



            }
        }
    }
}