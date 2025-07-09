package com.jsb.cryptotracker.feature_crypto.data.mappers

import com.jsb.cryptotracker.feature_crypto.data.networking.dto.CoinDto
import com.jsb.cryptotracker.feature_crypto.data.networking.dto.CoinPriceDto
import com.jsb.cryptotracker.feature_crypto.domain.Coin
import com.jsb.cryptotracker.feature_crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}