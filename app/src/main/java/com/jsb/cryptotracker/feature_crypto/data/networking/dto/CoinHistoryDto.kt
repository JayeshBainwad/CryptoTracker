package com.jsb.cryptotracker.feature_crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinHistoryDto(
    val data: List<CoinPriceDto>
)
