package br.dev.profbrunolopes.trucouro.modelos

import java.util.Stack

class Baralho(private val embaralharCartas:Boolean = true) {

    private val pilhaCartas = Stack<Carta>()
    private val descarteCartas = Stack<Carta>()

    init{
        gerarCartasBaralho()
    }

    fun cartas():List<Carta> {
        return pilhaCartas.toList()
    }

    fun descarte():List<Carta>{
        return descarteCartas.toList()
    }

    fun embaralhar(){
        if (pilhaCartas.size != 40 && descarteCartas.size != 0) {
            pilhaCartas.addAll(descarteCartas)
            descarteCartas.clear()
        }

        pilhaCartas.shuffle()
    }

    fun retirarCartaTopo():Carta{
        if(pilhaCartas.size > 0){
            return pilhaCartas.pop()
        }

        throw Exception("Não existe cartas na pilha para serem retiradas")
    }

    fun adicionarCartaNoDescarte(carta: Carta){
        descarteCartas.add(carta)
    }

    private fun gerarCartasBaralho(){
        for(nome in NomeCarta.values())
            for(naipe in Naipe.values())
                pilhaCartas.add(Carta(nome, naipe))

        if(embaralharCartas) embaralhar()
    }

}