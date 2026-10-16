package com.example.praticandocompose


import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.praticandocompose.ui.theme.PraticandoComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraticandoComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .safeDrawingPadding()
                    ) {
                        items(pokemonList) { pokemon ->
                            PokemonItem(pokemon = pokemon)

                        }
                    }
                }

            }

        }


    }

    data class PokemonData(
        val imageResId: Int,
        val pokemonId: String,
        val name: String,
        val pokemonType: String = "Normal",
    )

    val pokemonList = listOf(
        PokemonData(
            imageResId = R.drawable.pikachu,
            pokemonId = "001",
            name = "Pikachu",
            pokemonType = "Electric"
        ), PokemonData(
            imageResId = R.drawable.charmander,
            pokemonId = "004",
            name = "Charmander",
            pokemonType = "Fire"
        ), PokemonData(
            imageResId = R.drawable.bulbasaur,
            pokemonId = "002",
            name = "Bulbasaur",
            pokemonType = "Grass"

        ), PokemonData(
            imageResId = R.drawable.squirtle,
            pokemonId = "007",
            name = "Squirtle",
            pokemonType = "Water"

        ), PokemonData(
            imageResId = R.drawable.pikachu,
            pokemonId = "001",
            name = "Pikachu",
            pokemonType = "Electric"

        ), PokemonData(
            imageResId = R.drawable.charmander,
            pokemonId = "004",
            name = "Charmander",
            pokemonType = "Fire"

        )
    )


    @Composable
    fun PokemonItem(pokemon: PokemonData) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row() {
                Image(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(70.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = pokemon.imageResId),
                    contentDescription = pokemon.name
                )
                Column(
                    modifier = Modifier
                        .padding(1.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        modifier = Modifier.padding(1.dp),
                        text = pokemon.pokemonId,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier.padding(1.dp), text = pokemon.name, color = Color.Black
                    )
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .background(
                                Color.Green, shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(5.dp)
                                .align(Alignment.Center),
                            text = pokemon.pokemonType,
                            color = Color.Black


                        )
                    }
                }
            }

        }
    }
}

