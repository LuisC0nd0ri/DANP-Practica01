package com.luiscv.practica01.MyComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luiscv.practica01.clases.ZonaDeforestada

@Composable
fun DeforestAreasCard(
    zonaDeforestada: ZonaDeforestada,
    showDialogEdit: MutableState<Boolean>,
    showDialogDelete: MutableState<Boolean>
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {  }
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            modifier = Modifier
                .width(280.dp)
                .background(Color.LightGray)
                .padding(all = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //como las imagenes no son compatibles les pase el url
            MyImage(uno = zonaDeforestada.img)

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(160.dp)
            ) {
                Text(text = "Nombre: "+ zonaDeforestada.nombre)
                Text(text = "Fecha detección: "+ zonaDeforestada.fechaDeteccion)
            }


            Spacer(modifier = Modifier.width(10.dp))

            IconButton(onClick = { /* Todo: acción a realizar */ showDialogEdit.value = true }) {
                Icon(Icons.Filled.Edit, contentDescription = "Editar")
            }

            Spacer(modifier = Modifier.width(5.dp))

            IconButton(onClick = { /* Todo: acción a realizar */ showDialogDelete.value = true }) {
                Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
            }
        }

    }
}