package com.raian.roomdatabasmvvmapp.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.raian.roomdatabasmvvmapp.ListFragmentDirections
import com.raian.roomdatabasmvvmapp.R
import com.raian.roomdatabasmvvmapp.UserViewModel
import com.raian.roomdatabasmvvmapp.model.User
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter (val context: Context, val viewModel: UserViewModel):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var userList = viewModel.readAllData.value
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val root = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(root)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentData = userList?.get(position)
        holder.itemView.name.setText("FirstName: ${currentData?.firstName}" )
        holder.itemView.email.setText("LastName: ${currentData?.lastName}")
        holder.itemView.age.setText("Age: ${currentData?.age.toString()}")

        holder.itemView.update.setOnClickListener{
            val action = currentData?.let { it1 ->
                ListFragmentDirections.actionListFragmentToUpdateFragment(
                    it1
                )
            }
            if (action != null) {
                Navigation.findNavController(holder.itemView.update).navigate(action)
            }
        }
        holder.itemView.delete.setOnClickListener{

            val builder = AlertDialog.Builder(context)
            builder.setMessage("Are you sure you want to Delete?")
                .setCancelable(true)
                .setPositiveButton("Yes") { dialog, id ->
                    if (currentData != null) {
                        viewModel.deleteUser(currentData)
                    }
                }
                .setNegativeButton("No") { dialog, id ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
//            if (currentData != null) {
//                viewModel.deleteUser(currentData)
//            }
        }

    }

    override fun getItemCount(): Int {
       return userList?.size ?: 0
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

}