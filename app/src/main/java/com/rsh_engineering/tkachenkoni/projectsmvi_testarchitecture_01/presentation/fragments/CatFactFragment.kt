package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.App
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.R
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state.CatFactAction
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state.CatFactState
import com.ww.roxie.BaseViewModel

//import com.ww.roxie.BaseViewModel
import kotlinx.android.synthetic.main.fragment_cat_fact.*
import androidx.core.view.isVisible as isVisible


class CatFactFragment : Fragment() {

    private lateinit var viewModel: BaseViewModel<CatFactAction, CatFactState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cat_fact, container, false)
    }

    companion object {
        fun newInstance() = CatFactFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = App.getAppDi().catFactViewModel

        viewModel.observableState.observe(this, Observer { state ->
            state?.let {
                renderState(it)
            }
        })

        getFactButton.setOnClickListener {
            viewModel.dispatch(CatFactAction.GetFactButtonClicked)
        }
    }

    private fun renderState(state: CatFactState) {
        with(state) {
            if (fact.isNotEmpty()) {
                catFactView.text = fact
            }

            progressBar.isVisible = activity
            getFactButton.isEnabled = !activity
            errorView.isVisible = displayError



        }
    }
}