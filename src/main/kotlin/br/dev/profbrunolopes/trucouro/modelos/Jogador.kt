package br.dev.profbrunolopes.trucouro.modelos

data class Jogador(
    val id:String,
    val nome:String,
    val mao:Mao = Mao())
