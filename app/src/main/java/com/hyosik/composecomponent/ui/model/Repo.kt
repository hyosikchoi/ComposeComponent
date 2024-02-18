package com.hyosik.composecomponent.ui.model

data class Repo(
    val id: Long,
    val name: String,
    val htmlUrl: String,
    val url: String,
    val gitUrl: String
)