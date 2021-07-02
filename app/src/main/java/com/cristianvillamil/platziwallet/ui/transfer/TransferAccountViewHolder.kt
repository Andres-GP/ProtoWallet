package com.cristianvillamil.platziwallet.ui.transfer

import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.squareup.picasso.Picasso

class TransferAccountViewHolder(
    private val view: View,
    private val onItemSelectedListener: OnItemSelected<TransferAccount>
) : RecyclerView.ViewHolder(view) {

    fun bindItem(transferAccount: TransferAccount) {
        view.setOnClickListener {
            onItemSelectedListener.onItemSelected(transferAccount)
        }
        if (transferAccount.isSelected) {
            view.findViewById<CardView>(R.id.transferRowContainer)
                .setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.primary))
        } else {
            view.findViewById<CardView>(R.id.transferRowContainer)
                .setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.divider))
        }
        Picasso
            .get()
            .load("https://images.unsplash.com/photo-1583195764036-6dc248ac07d9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=755&q=80")
            .into(view.findViewById<ImageView>(R.id.profilePhotoImageView))
    }

}