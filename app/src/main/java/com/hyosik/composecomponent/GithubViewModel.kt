package com.hyosik.composecomponent

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyosik.composecomponent.ui.model.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
//    private val githubService: GithubService
) : ViewModel() {

    val repos = mutableStateListOf<Repo>()

    fun getRepos() {
        repos.clear()
        viewModelScope.launch {
//            val result = githubService.listRepos(user = "dalinaum")
//            repos.addAll(result)
        }
    }

}