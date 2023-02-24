package com.example.model.dto.language

data class LanguageDto(
    val id: Int,
    val code: String,
    val name: String,
    var isSelected: Boolean = false
)