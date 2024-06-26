package edu.uw.serrat.mediabrowser

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [PokemonDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class PokemonDetailFragment : Fragment() {
    // any private info I want to tie to this area goes here

    private var selectedPokemon: Int? = null
    private lateinit var viewModel: MainViewModel

    // update the private stuff here if I want to
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args:PokemonDetailFragmentArgs by navArgs()
        // do another call to get a pokemon object
        selectedPokemon = args.pokemonId
        selectedPokemon?.let{
            Log.v("my pokemon", it}
            viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            viewModel.pokemonData.value?.get(it)?.let { it1 -> Log.v("my pokemon", it1.toString()) }
        }
    }

    // here is where I should do a lot of the heavy lifting to make things happen
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.pokemon_detail_fragment, container, false)


        rootView.findViewById<TextView>(R.id.pokemon_name).text=selectedPokemon.toString()


        return rootView
    }
    fun getPokemon(v: View) {
        // todo: populate pokemon, name type ability, height, weight
        // and add shiny vs non shiny sprite

        // on clicking the ability:
        // navigate to an ability detail page, where we talk more about hte ability
        // as well as pokemon that may have the ability
        // from there people can navigate to other pokemon.
    }

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             