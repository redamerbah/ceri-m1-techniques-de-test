package fr.univavignon.pokedex.api;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;


public class IPokemonMetadataProviderTest {
    @Test
    public void AffichageTest() throws PokedexException {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);


        String name="Aquali";
        int attack=186;
        int defense = 168;
        int stamina = 260;

        PokemonMetadata pokemonMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals(name, pokemonMetadata.getName());
        assertEquals(attack,pokemonMetadata.getAttack());
        assertEquals(defense, pokemonMetadata.getDefense());
        assertEquals(stamina, pokemonMetadata.getStamina());
    }

}