package br.dev.profbrunolopes.trucouro

import br.dev.profbrunolopes.trucouro.jogo.Jogo
import br.dev.profbrunolopes.trucouro.modelos.Jogador
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import java.util.UUID

class JogoTeste :FunSpec({

    test("Disatribuir cartas aos jogadores"){

        val jogador1 = Jogador(UUID.randomUUID().toString(), "Bruno")
        val jogador2 = Jogador(UUID.randomUUID().toString(), "Lissa")
        val jogador3 = Jogador(UUID.randomUUID().toString(), "Morganna")
        val jogador4 = Jogador(UUID.randomUUID().toString(), "Kastro")

        val equipe1 = Pair(jogador1, jogador2)
        val equipe2 = Pair(jogador3, jogador4)

        val jogo = Jogo(equipe1, equipe2)

        jogo.distribuirCartas()

        jogo.baralho.cartas().size.shouldBeEqualComparingTo(28)
        jogador1.mao.quantidateCartas().shouldBeEqualComparingTo(3)
        jogador2.mao.quantidateCartas().shouldBeEqualComparingTo(3)
        jogador3.mao.quantidateCartas().shouldBeEqualComparingTo(3)
        jogador4.mao.quantidateCartas().shouldBeEqualComparingTo(3)

    }

})