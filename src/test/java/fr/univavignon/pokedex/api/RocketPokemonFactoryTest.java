package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RocketPokemonFactoryTest {
    RocketPokemonFactory rocketPokemon;
    Pokemon po1, po2, po3, po4, po5;


    @Before
    public void init() {
        rocketPokemon = new RocketPokemonFactory();
        po1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    }


    @Test
    public void createPokemon() {


        assertEquals(0, po1.getIndex());
        assertEquals("Bulbizarre", po1.getName());
        assertEquals(126, po1.getAttack());
        assertEquals(126, po1.getDefense());
        assertEquals(90, po1.getStamina());

    }











}
