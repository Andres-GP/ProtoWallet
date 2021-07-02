package com.cristianvillamil.platziwallet.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_ERROR
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_INFO
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_SUCCESS
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.cristianvillamil.platziwallet.ui.observable.AvailableBalanceObservable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter =
        FavoriteTransferAdapter()

    private val availableBalanceObservable = AvailableBalanceObservable()

    private var homePresenter:HomeContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this)
        homePresenter?.retrieveFavoriteTransfers()
        /*circularProgress.setProgressWithAnimation(
                70f,
        1000,
        AccelerateDecelerateInterpolator(),
        500
        )*/
        Picasso
            .get()
            .load("https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80")
            .into(profilePhotoImageView)

        /*availableBalanceObservable.addObserver(object : Observer{
            override fun notifyChange(newValue: Double) {
                amountValueTextView.text = ("$ $newValue")
            }

        })*/
        homePresenter!!.getPercentageLiveData().observe(this, Observer<String>{ value ->
            //percentageText.text = value
        })

    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter

    }

    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeLoader.visibility = View.INVISIBLE
    }

    override fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfer)
        /*val dialogFactory = MessageFactory()
        context?.let {
            val errorDialog = dialogFactory.getDialog(it, TYPE_INFO)
            errorDialog.show()
        }*/

    }
}