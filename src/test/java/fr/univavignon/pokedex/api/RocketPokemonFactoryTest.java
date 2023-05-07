package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RocketPokemonFactoryTest {
    RocketPokemonFactory rocketPokemon;
    private RocketPokemonFactory pokemonFactory;
    Pokemon po1, po2, po3, po4, po5;


    @Before
    public void init() {
        rocketPokemon = new RocketPokemonFactory();
        po1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        po2 = new Pokemon(133, "MISSINGNO", 186, 168, 260, 2729, 202, 5000, 4, 100);
        po3 = rocketPokemon.createPokemon(-1, 1, 1, 1, 1);


    }



    @Test
    public void createPokemon() {

        // Test 1
        assertEquals(0, po1.getIndex());
        assertEquals("Bulbizarre", po1.getName());
        assertEquals(126, po1.getAttack());
        assertEquals(126, po1.getDefense());
        assertEquals(90, po1.getStamina());
        // Test Z
        assertEquals(133, po2.getIndex());
        assertEquals("MISSINGNO", po2.getName());
        assertEquals(186, po2.getAttack());
        assertEquals(168, po2.getDefense());
        assertEquals(260, po2.getStamina());
        // Test 3
        assertEquals("Ash's Pikachu", po3.getName());

    }












}
