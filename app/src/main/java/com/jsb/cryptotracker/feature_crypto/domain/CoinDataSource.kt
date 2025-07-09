package com.jsb.cryptotracker.feature_crypto.domain

import com.jsb.cryptotracker.feature_core.domain.util.NetworkError
import com.jsb.cryptotracker.feature_core.domain.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}