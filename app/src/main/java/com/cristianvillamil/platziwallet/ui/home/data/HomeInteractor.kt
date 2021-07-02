package com.cristianvillamil.platziwallet.ui.home.data

import android.os.Handler
import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract

class HomeInteractor {

    fun retrieveFavoriteTransferFromCache(responseCallback: HomeContract.OnResponseCallback){
        val items = ArrayList<FavoriteTransfer>()
        items.add(
            FavoriteTransfer(
                1,
                "Freddy Vega",
                456.000,
                "Hace 2h",
                "https://images.unsplash.com/photo-1581803118522-7b72a50f7e9f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Nestor Villamil",
                210.900,
                "Ayer",
                "https://images.unsplash.com/photo-1485528562718-2ae1c8419ae2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=481&q=80"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Fernando Ávila",
                456.000,
                "Hace 2h",
                "https://images.unsplash.com/photo-1506207803951-1ee93d7256ad?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Cristian Villamil",
                456.000,
                "Hace 2h",
                "https://images.unsplash.com/photo-1505247964246-1f0a90443c36?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Cristian Villamil",
                456.000,
                "Hace 2h",
                "https://images.unsplash.com/photo-1564564321837-a57b7070ac4f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=755&q=80"
            )
        )
        val runnable = Runnable {
            responseCallback.onResponse(items)
        }
        val handler = Handler()
        handler.postDelayed(runnable, 100)

        UserSingleton.getInstance().userName
    }
}