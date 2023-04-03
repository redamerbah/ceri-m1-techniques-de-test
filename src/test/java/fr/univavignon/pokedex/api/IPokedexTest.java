package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokedexTest {

    private IPokedex pokedex = Mockito.mock(IPokedex.class);
    List<Pokemon> listePokemon = new ArrayList<Pokemon>();

    @Before
    public void init() {
        Pokemon pokemon1 =new Pokemon(133, "Aquali", 186, 168, 260, 0, 0, 0, 0, 0);
        listePokemon.add(pokemon1);
        //IPokedex pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
	/*public void createPokedex() {


		System.out.println(pokedex.getPokemons());
	}*/
    public void getSize() {
        when(pokedex.size()).thenAnswer(new Answer<Integer>(){

            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                // TODO Auto-generated method stub
                return listePokemon.size();
            }

        });
        assertEquals(1, pokedex.size());
    }

    @Test
    public void addPokemon() {
        when(pokedex.addPokemon(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                // TODO Auto-generated method stub
                Object[] args = invocation.getArguments();
                Pokemon myPokemon = (Pokemon) args[0];
                listePokemon.add(myPokemon);
                return myPokemon.getIndex();
            }
        });
        int size1 = pokedex.size();
        Pokemon pokemonBulbi = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        int index = pokedex.addPokemon(pokemonBulbi);
        int size2 = pokedex.size();
        assertEquals(index, pokemonBulbi.getIndex());
        //assertEquals(size1+1, size2);

    }

    @Test
    public void getPokemon() {
        try {
            when(pokedex.getPokemon(anyInt())).thenAnswer(new Answer<Pokemon>() {
                @Override
                public Pokemon answer(InvocationOnMock invocation) throws Throwable {
                    // TODO Auto-generated method stub
                    Object[] args = invocation.getArguments();
                    int indexToFind = (int) args[0];
                    for (Pokemon pokemon : listePokemon) {
                        if(pokemon.getIndex() == indexToFind) {
                            return pokemon;
                        }
                    }
                    return null;
                }
            });

            Pokemon pokemon1 = pokedex.getPokemon(133);
            assertEquals(pokemon1.getIndex(), 133);
        } catch (PokedexException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void getPokemons() {
        when(pokedex.getPokemons()).thenReturn(listePokemon);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(pokemons.size(), 1);
    }

    @Test
    public void getPokemons2() {
        when(pokedex.getPokemons(any())).thenAnswer(new Answer<List<Pokemon>>() {

            @SuppressWarnings("unchecked")
            @Override
            public List<Pokemon> answer(InvocationOnMock invocation) throws Throwable {
                // TODO Auto-generated method stub
                Object[] args = invocation.getArguments();
                List<Pokemon> sortedList = listePokemon.stream().collect(Collectors.toList());
                Collections.sort(listePokemon, (Comparator<Pokemon>)args[0]);
                return sortedList;
            }
        });
        PokemonComparators pokemonComparator = PokemonComparators.INDEX;
        List<Pokemon> pokemons = pokedex.getPokemons(pokemonComparator);
        assertEquals(pokemons.size(), 1);
        assertEquals(pokemons.get(0).getIndex(), 133);
    }

}