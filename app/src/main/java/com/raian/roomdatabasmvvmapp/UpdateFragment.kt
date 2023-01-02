package com.raian.roomdatabasmvvmapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.raian.roomdatabasmvvmapp.model.User
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.list_item.*

class UpdateFragment : Fragment() {
    lateinit var viewModel : UserViewModel
    val args: UpdateFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val user = args.user
        firstname_et.setText(user.firstName)
        lastname_et.setText(user.lastName)
        age_et.setText(user.age.toString())

        update_button.setOnClickListener {
            val firstName = firstname_et.text.toString()
            val lastName = lastname_et.text.toString()
            val age= age_et.text.toString()
            val user = User(user.id,firstName,lastName,age.toInt())
            viewModel.updateUser(user)

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

    }



}