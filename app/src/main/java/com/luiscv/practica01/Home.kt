package com.luiscv.practica01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luiscv.practica01.MyComponents.DeforestAreasCard
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
        modifier = Modifier.height(500.dp)  //muy importante
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
    //Card
    DeforestAreasCard(zonaDeforestada, showDialogEdit, showDialogDelete)

    //editar zona deforestada
    dialogEdit(showDialogEdit, zonaDeforestada)
    //eliminar zona deforestada
    dialogDelete(showDialogDelete)
}