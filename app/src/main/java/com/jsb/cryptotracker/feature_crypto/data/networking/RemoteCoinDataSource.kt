package com.jsb.cryptotracker.feature_crypto.data.networking

import com.jsb.cryptotracker.BuildConfig
import com.jsb.cryptotracker.feature_core.data.networking.constructUrl
import com.jsb.cryptotracker.feature_core.data.networking.safeCall
import com.jsb.cryptotracker.feature_core.domain.util.NetworkError
import com.jsb.cryptotracker.feature_core.domain.util.Result
import com.jsb.cryptotracker.feature_core.domain.util.map
import com.jsb.cryptotracker.feature_crypto.data.mappers.toCoin
import com.jsb.cryptotracker.feature_crypto.data.mappers.toCoinPrice
import com.jsb.cryptotracker.feature_crypto.data.networking.dto.CoinHistoryDto
import com.jsb.cryptotracker.feature_crypto.data.networking.dto.CoinsResponseDto
import com.jsb.cryptotracker.feature_crypto.domain.Coin
import com.jsb.cryptotracker.feature_crypto.domain.CoinDataSource
import com.jsb.cryptotracker.feature_crypto.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    val apiKey = BuildConfig.COINCAP_API_KEY

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            ){
                header("Authorization", "Bearer $apiKey")
            }
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                header("Authorization", "Bearer ${BuildConfig.COINCAP_API_KEY}")
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map { it.toCoinPrice() }
        }
    }
}