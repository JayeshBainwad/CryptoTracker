package com.jsb.cryptotracker.feature_crypto.presentation.coin_list

import com.jsb.cryptotracker.feature_core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}