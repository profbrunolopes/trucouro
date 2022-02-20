package br.dev.profbrunolopes.trucouro.modelos

class Mao() {

    private var quantidade = 0
    private val cartas = Array<Carta?>(3) { null }

    fun adicionarCarta(carta:Carta){
        if(quantidade < 3){
            cartas[quantidade] = carta
            quantidade += 1
        }
    }

    fun usarCarta(indice:Int):Carta{
        if(cartas[indice] != null){
            quantidade -= 1
            val carta = cartas[indice]!!
            cartas[indice] = null
            return carta
        }

        throw Exception("A carta do indice especificado já foi utilizada.")

    }

    fun quantidateCartas():Int{
        return quantidade
    }

}