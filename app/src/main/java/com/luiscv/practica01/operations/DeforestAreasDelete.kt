package com.luiscv.practica01.operations

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun dialogDelete(showDialogDelete: MutableState<Boolean>){
    if (showDialogDelete.value){
        AlertDialog(
            onDismissRequest = { /*TODO*/ showDialogDelete.value = false },
            confirmButton = {
                TextButton(onClick = { /*TODO*/
                    //AQUI AGREGAMOS EL CODIGO PARA ELIMINAR
                    showDialogDelete.value = false
                }) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { /*TODO*/ showDialogDelete.value = false }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Eliminar") },
            text = { Text(text = "¿Esta seguro de eliminar esta zona deforestada?") }
        )
    }
}