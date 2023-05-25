package com.luiscv.practica01.operations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

//esta funcion ayudará a registrar las zonas deforestadas
@Composable
fun register(showDialogDataRegister: MutableState<Boolean>) {

    //campos
    var tfnombre by remember { mutableStateOf("") }
    var tffechaDeteccion by remember { mutableStateOf("") }
    var tflatitud by remember { mutableStateOf("") }
    var tflongitud by remember { mutableStateOf("") }
    var tftamanioZD by remember { mutableStateOf("") }
    var tfImagen by remember { mutableStateOf("") } //ver como imprimir una imagen
    var tfCausasZD by remember { mutableStateOf("") }
    var tfConsecuenciasZD by remember { mutableStateOf("") }


    if(showDialogDataRegister.value){
        AlertDialog(
            onDismissRequest = { /*TODO*/ showDialogDataRegister.value = false },
            confirmButton = {
                TextButton(onClick = { /*TODO*/
                    //AQUI AGREGAMOS EL CODIGO PARA REGISTRAR
                    showDialogDataRegister.value = false
                }) {
                    Text(text = "Registrar")
                }
            },
            dismissButton = {
                TextButton(onClick = { /*TODO*/ showDialogDataRegister.value = false }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Registrar zona deforestada")},
            text = {
                Column() {
                    Text(text = "Registre los datos", modifier = Modifier.padding(bottom = 10.dp))
                    TextField(value = tfnombre,
                        onValueChange = { tfnombre = it }, placeholder = { Text(text = "Nombre")})
                    TextField(value = tffechaDeteccion,
                        onValueChange = { tffechaDeteccion = it }, placeholder = { Text(text = "Fecha detección")})
                    TextField(value = tflatitud,
                        onValueChange = { tflatitud = it }, placeholder = { Text(text = "Latitud")})
                    TextField(value = tflongitud,
                        onValueChange = { tflongitud = it }, placeholder = { Text(text = "Longitud")})
                    TextField(value = tftamanioZD,
                        onValueChange = { tftamanioZD = it }, placeholder = { Text(text = "Tamaño de Zona Deforestada")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    TextField(value = tfCausasZD,
                        onValueChange = { tfCausasZD = it }, placeholder = { Text(text = "Causa de Zona Deforestada")})
                    TextField(value = tfConsecuenciasZD,
                        onValueChange = { tfConsecuenciasZD = it }, placeholder = { Text(text = "Consecuencia de Zona Deforestada")})
                    TextField(value = tfImagen,
                        onValueChange = { tfImagen= it }, placeholder = { Text(text = "URL de Imagen")}) //de momento
                }
            }
        )
    }
}
