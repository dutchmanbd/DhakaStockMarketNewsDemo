package com.zxdmjr.dhakastockmarketnewsdemo.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayout
import com.zxdmjr.dhakastockmarketnewsdemo.R
import com.zxdmjr.dhakastockmarketnewsdemo.databinding.ActivityMainBinding
import com.zxdmjr.dhakastockmarketnewsdemo.internal.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    private val navController by lazy {
        findNavController(binding.navHostMainFragment.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = getString(R.string.txt_title)
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { selectedTab ->
                    when (selectedTab.position) {
                        0 -> {
                            navigateToTodayFragment()
                        }
                        1 -> {
                            navigateToLastSevenDaysFragment()
                        }
                        2 -> {
                            navigateToNewsFragment()
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun navigateToTodayFragment() {
        navController.navigate(R.id.todayNewsFragment)
    }

    private fun navigateToLastSevenDaysFragment() {
        navController.navigate(R.id.lastSevenDaysFragment)
    }

    private fun navigateToNewsFragment() {
        navController.navigate(R.id.newsFragment)
    }
}