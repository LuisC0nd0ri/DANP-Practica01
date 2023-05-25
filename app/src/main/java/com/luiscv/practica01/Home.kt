package com.luiscv.practica01

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luiscv.practica01.MyComponents.MyImage
import com.luiscv.practica01.clases.ZonaDeforestada
import com.luiscv.practica01.operations.dialogDelete
import com.luiscv.practica01.operations.dialogEdit
import com.luiscv.practica01.operations.register
import com.luiscv.practica01.test.listaZD

//funcion donde va la lista de items: zonas deforestadas
@Composable
fun home(){
    //dialogos
    var showDialogDataRegister:MutableState<Boolean> =
        remember { mutableStateOf(false) }
    //scroll
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        //Text(text = "Hello $name!")
        Text(
            text = "Lista de zonas deforestadas",
            modifier = Modifier.padding(bottom = 20.dp)
        )

        //val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            //aqui van los items
            MisZonasDeforestadas(listaZD)
        }

        Button(
            onClick = { /*TODO*/
                        showDialogDataRegister.value = true
                      },
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Registrar")
        }
    }

    //funcion para registrar
    register(showDialogDataRegister)

}

@Composable
fun MisZonasDeforestadas(
    listaZD: List<ZonaDeforestada>){

    LazyColumn(
        modifier = Modifier.height(515.dp)  //muy importante
    ) {
        items(listaZD){ zonaDeforestada ->
            ItemZonaDeforestada(zonaDeforestada)
        }
    }
}

@Composable
fun ItemZonaDeforestada(zonaDeforestada: ZonaDeforestada){

    //dialogos
    var showDialogDelete: MutableState<Boolean>
        = remember { mutableStateOf(false) }

    var showDialogEdit: MutableState<Boolean>
            = remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Column() {

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .width(280.dp)
                    .padding(start = 10.dp)
                    .background(Color.LightGray)
                    .padding(all = 10.dp)
            ) {

                //como las imagenes no son compatibles les pase el url
                MyImage(uno = zonaDeforestada.img)

                Column(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = "Nombre: "+ zonaDeforestada.nombre)
                    Text(text = "Fecha detección: "+ zonaDeforestada.fechaDeteccion)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
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

    //editar zona deforestada
    dialogEdit(showDialogEdit, zonaDeforestada)
    //eliminar zona deforestada
    dialogDelete(showDialogDelete)
    
}