package com.robby.dicoding_kotlin_project_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.robby.dicoding_kotlin_project_1.adapter.ClubAdapter
import com.robby.dicoding_kotlin_project_1.entity.Club
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private val clubAdapter: ClubAdapter = ClubAdapter {
        startActivity(intentFor<ClubDetail>(resources.getString(R.string.parcel_club) to it).singleTop())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        MainActivityUI().setContentView(this)
    }

    private fun initData() {
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_acm),
                R.drawable.img_acm,
                resources.getString(R.string.desc_acm)
            )
        )
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_arsenal),
                R.drawable.img_arsenal,
                resources.getString(R.string.desc_arsenal)
            )
        )
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_barca),
                R.drawable.img_barca,
                resources.getString(R.string.desc_barca)
            )
        )
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_chelsea),
                R.drawable.img_chelsea,
                resources.getString(R.string.desc_chelsea)
            )
        )
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_bayern_mu),
                R.drawable.img_bayern,
                resources.getString(R.string.desc_bayern_mu)
            )
        )
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_city),
                R.drawable.img_city,
                resources.getString(R.string.desc_city)
            )
        )
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_real),
                R.drawable.img_madrid,
                resources.getString(R.string.desc_real)
            )
        )
        clubAdapter.clubs.add(
            Club(
                resources.getString(R.string.club_mu),
                R.drawable.img_mu,
                resources.getString(R.string.desc_mu)
            )
        )
    }

    inner class MainActivityUI() : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            linearLayout {
                lparams(matchParent, matchParent) {
                    orientation = LinearLayout.VERTICAL
                    leftMargin = dip(dimen(R.dimen.layout_padding))
                    rightMargin = dip(dimen(R.dimen.layout_padding))
                }

                recyclerView {
                    adapter = clubAdapter
                    lparams(width = matchParent, height = matchParent) {
                        val orientation = LinearLayoutManager.VERTICAL
                        layoutManager = LinearLayoutManager(context)
                        val divider = DividerItemDecoration(context, orientation);
                        addItemDecoration(divider)
                        visibility = View.VISIBLE
                    }
                }
            }
        }

    }
}
