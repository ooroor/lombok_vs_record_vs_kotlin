package net.barakiroth.lombok_vs_record_vs_kotlin

import io.swagger.oas.annotations.media.Schema

data class MyKotlinDto(
        @field:Schema(description = "Surrogate instance unique identifier", example = "10378465")
        var id: Int,
        @field:Schema(description = "The name of the thing", example = "Gageter")
        var name: String) {
}