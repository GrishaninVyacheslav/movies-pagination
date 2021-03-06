package io.github.grishaninvyacheslav.theatre_movies_pagination.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.theatre_movies_pagination.ui.screens.IScreens
import org.koin.android.ext.android.inject

abstract class BaseFragment<Binding : ViewBinding>(
    private val bindingFactory: (inflater: LayoutInflater, parent: ViewGroup?, attachToParent: Boolean) -> Binding
) : Fragment() {
    protected val router: Router by inject()
    protected val screens: IScreens by inject()

    private var _binding: Binding? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = bindingFactory(inflater, container, false).also { _binding = it }.root
}