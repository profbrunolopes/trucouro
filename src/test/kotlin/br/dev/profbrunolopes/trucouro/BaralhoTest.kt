package br.dev.profbrunolopes.trucouro

import br.dev.profbrunolopes.trucouro.modelos.Baralho
import br.dev.profbrunolopes.trucouro.modelos.Mao
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe

class BaralhoTest:FunSpec({

    test("Criação um baralho para truco paulista"){
        val baralho = Baralho()
        baralho.cartas().count().shouldBeEqualComparingTo(40)
    }

    test("Retirar uma mao de três cartas") {
        val baralho = Baralho()
        val mao = Mao()

        mao.adicionarCarta(baralho.retirarCartaTopo())
        mao.adicionarCarta(baralho.retirarCartaTopo())
        mao.adicionarCarta(baralho.retirarCartaTopo())

        baralho.cartas().count().shouldBeEqualComparingTo(37)
        mao.quantidateCartas().shouldBeEqualComparingTo(3)
    }

    test("Retirar uma mao de três cartas e coloca-las no descarte") {
        val baralho = Baralho()
        val mao = Mao()

        mao.adicionarCarta(baralho.retirarCartaTopo())
        mao.adicionarCarta(baralho.retirarCartaTopo())
        mao.adicionarCarta(baralho.retirarCartaTopo())

        baralho.adicionarCartaNoDescarte(mao.usarCarta(0))
        baralho.adicionarCartaNoDescarte(mao.usarCarta(1))
        baralho.adicionarCartaNoDescarte(mao.usarCarta(2))

        baralho.cartas().count().shouldBeEqualComparingTo(37)
        baralho.descarte().count().shouldBeEqualComparingTo(3)
        mao.quantidateCartas().shouldBeEqualComparingTo(0)

    }

    test("Retirar uma carta da pílha de cartas") {
        val baralho = Baralho()
        val carta = baralho.cartas().last()

        val cartaRetirada = baralho.retirarCartaTopo()

        baralho.cartas().count().shouldBeEqualComparingTo(39)
        (carta == cartaRetirada).shouldBe(true)
    }

    test("Utilizar uma carta já usada anteriormetne da mao"){
        val baralho = Baralho()
        val mao = Mao()

        mao.adicionarCarta(baralho.retirarCartaTopo())
        mao.adicionarCarta(baralho.retirarCartaTopo())
        mao.adicionarCarta(baralho.retirarCartaTopo())

        mao.usarCarta(0)

        shouldThrow<Exception> {
            mao.usarCarta(0)
        }

    }

})