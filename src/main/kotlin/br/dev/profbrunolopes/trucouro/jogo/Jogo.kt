package br.dev.profbrunolopes.trucouro.jogo

import br.dev.profbrunolopes.trucouro.modelos.*
import java.util.UUID
import kotlin.random.Random

private const val numeroMaximoJogadores = 4

class Jogo(
    val duplaA: Pair<Jogador, Jogador>,
    val duplaB: Pair<Jogador, Jogador>
) {

    var indiceProximo = Random.nextInt(4)
    var contadorRodada = 0
    val baralho = Baralho()
    var placarDeRodada = Pair(0, 0)
    val placarDePartida = Pair(0, 0)
    var manilha: Carta = Carta(NomeCarta.TRES, Naipe.PAUS)

    fun iniciarRodada() {

        distribuirCartas()

        retirarCartaManilha()

        val pontuacaoRodada = Pair(0,0)

        // Controla a pontuação da rodada (mostrar cartas)
        for (i in 0 until 3){

            // Contra a vez de cada uma das pessoas jogadoras
            for(j in 0 until 4){

                // Fazer a jogada

                // Verificar se é a maior carta da mesa

            }

            // Dar a pontuação a equipe que possui a maior carta na mesa
        }

        if(pontuacaoRodada.first > pontuacaoRodada.second){
            placarDeRodada = Pair(placarDeRodada.first + 1, placarDeRodada.second)
        } else {
            placarDeRodada = Pair(placarDeRodada.first, placarDeRodada.second + 1)
        }
        
        contadorRodada += 1

    }

    fun distribuirCartas() {
        for (i in 0 until 3) {
            duplaA.first.mao.adicionarCarta(baralho.retirarCartaTopo())
            duplaB.first.mao.adicionarCarta(baralho.retirarCartaTopo())
            duplaA.second.mao.adicionarCarta(baralho.retirarCartaTopo())
            duplaB.second.mao.adicionarCarta(baralho.retirarCartaTopo())
        }
    }

    fun retirarCartaManilha(){
        manilha = baralho.retirarCartaTopo()
    }

    fun proximoJogador():Jogador{
        indiceProximo = (indiceProximo + 1) % numeroMaximoJogadores
        return when(indiceProximo){
            0 -> duplaA.first
            1 -> duplaB.first
            2 -> duplaA.second
            else -> duplaB.second
        }
    }

}