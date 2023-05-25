package com.luiscv.practica01.clases

data class ZonaDeforestada(
    val nombre: String,
    val fechaDeteccion: String,
    val latitud: String,
    val longitud: String,
    val tamanioZD: Double,
    val CausaZD: String,
    val consecuenciaZD: String,
    var img: String
    )