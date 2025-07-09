package com.jsb.cryptotracker.di

import com.jsb.cryptotracker.feature_core.data.networking.HttpClientFactory
import com.jsb.cryptotracker.feature_crypto.data.networking.RemoteCoinDataSource
import com.jsb.cryptotracker.feature_crypto.domain.CoinDataSource
import com.jsb.cryptotracker.feature_crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}