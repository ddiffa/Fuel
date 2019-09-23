package com.example.fuel.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein

abstract class BaseFragment : Fragment(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    override val kodeinTrigger =KodeinTrigger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kodeinTrigger.trigger()
    }
}