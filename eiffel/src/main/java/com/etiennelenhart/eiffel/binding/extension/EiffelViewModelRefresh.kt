package com.etiennelenhart.eiffel.binding.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.etiennelenhart.eiffel.action.Action
import com.etiennelenhart.eiffel.binding.BindingState
import com.etiennelenhart.eiffel.state.State
import com.etiennelenhart.eiffel.viewmodel.EiffelViewModel

/**
 * Used to observe an [EiffelViewModel]'s state from a [LifecycleOwner] like [FragmentActivity] or [Fragment] and
 * simultaneously refresh a [BindingState].
 *
 * @param[owner] [LifecycleOwner] that controls observation.
 * @param[bindingState] [BindingState] to refresh with a newly emitted state.
 * @param[onChanged] Optional lambda expression that is called with a newly emitted state.
 */
fun <S : State, A : Action> EiffelViewModel<S, A>.observeState(owner: LifecycleOwner, bindingState: BindingState<S>, onChanged: (newState: S) -> Unit = {}) {
    observeState(owner) {
        bindingState.refresh(it)
        onChanged(it)
    }
}
