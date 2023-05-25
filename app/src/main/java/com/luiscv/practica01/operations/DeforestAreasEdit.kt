package com.luiscv.practica01.operations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.luiscv.practica01.clases.ZonaDeforestada


//esta funcion ayudará a registrar las zonas deforestadas
@Composable
fun dialogEdit(showDialogDataRegister: MutableState<Boolean>, zonaDeforestada: ZonaDeforestada) {

    //campos
    var tfnombre by remember { mutableStateOf(zonaDeforestada.nombre) }
    var tffechaDeteccion by remember { mutableStateOf(zonaDeforestada.fechaDeteccion) }
    var tflatitud by remember { mutableStateOf(zonaDeforestada.latitud) }
    var tflongitud by remember { mutableStateOf(zonaDeforestada.longitud) }
    var tftamanioZD by remember { mutableStateOf(zonaDeforestada.tamanioZD.toString()) }
    var tfImagen by remember { mutableStateOf(zonaDeforestada.img.toString()) } //ver como imprimir una imagen
    var tfCausasZD by remember { mutableStateOf(zonaDeforestada.CausaZD) }
    var tfConsecuenciasZD by remember { mutableStateOf(zonaDeforestada.consecuenciaZD) }


    if(showDialogDataRegister.value){
        AlertDialog(
            onDismissRequest = { /*TODO*/ showDialogDataRegister.value = false },
            confirmButton = {
                TextButton(onClick = { /*TODO*/
                    //AQUI AGREGAMOS EL CODIGO PARA EDITAR
                    showDialogDataRegister.value = false
                }) {
                    Text(text = "Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { /*TODO*/ showDialogDataRegister.value = false }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Editar zona deforestada") },
            text = {
                Column() {
                    Text(text = "Edite los datos", modifier = Modifier.padding(bottom = 10.dp))
                    TextField(value = tfnombre,
                        onValueChange = { tfnombre = it }, placeholder = { Text(text = "Nombre") })
                    TextField(value = tffechaDeteccion,
                        onValueChange = { tffechaDeteccion = it }, placeholder = { Text(text = "Fecha detección") })
                    TextField(value = tflatitud,
                        onValueChange = { tflatitud = it }, placeholder = { Text(text = "Latitud") })
                    TextField(value = tflongitud,
                        onValueChange = { tflongitud = it }, placeholder = { Text(text = "Longitud") })
                    TextField(value = tftamanioZD,
                        onValueChange = { tftamanioZD = it }, placeholder = { Text(text = "Tamaño de Zona Deforestada") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    TextField(value = tfCausasZD,
                        onValueChange = { tfCausasZD = it }, placeholder = { Text(text = "Causa de Zona Deforestada") })
                    TextField(value = tfConsecuenciasZD,
                        onValueChange = { tfConsecuenciasZD = it }, placeholder = { Text(text = "Consecuencia de Zona Deforestada") })
                    TextField(value = tfImagen,
                        onValueChange = { tfImagen= it }, placeholder = { Text(text = "URL de Imagen") }) //de momento
                }
            }
        )
    }
}
