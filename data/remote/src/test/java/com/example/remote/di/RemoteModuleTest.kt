package com.example.remote.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.framework.base.app.NetworkConfig
import com.example.framework.network.interceptor.HttpRequestInterceptor
import com.example.testutils.BuildConfig
import com.example.testutils.TestRobolectric
import com.google.common.truth.Truth
import io.mockk.mockk
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert
import org.junit.Test

class RemoteModuleTest : TestRobolectric() {

    private lateinit var remoteModule: RemoteModule
    private lateinit var networkConfig: NetworkConfig

    override fun onCreate() {
        super.onCreate()
        networkConfig = object : NetworkConfig() {
            override fun baseUrl(): String = BuildConfig.BASE_URL
            override fun timeOut(): Long = 30L
            override fun isDev(): Boolean = true
        }
        remoteModule = RemoteModule()
    }

    @Test
    fun verifyBaseUrl() {
        val baseUrl = remoteModule.provideBaseUrl(networkConfig)
        Assert.assertEquals(baseUrl, BuildConfig.BASE_URL)
    }

    @Test
    fun verifyProvideHttpLoggingInterceptor() {
        val interceptor = remoteModule.provideHttpLoggingInterceptor(networkConfig)
        Assert.assertEquals(HttpLoggingInterceptor.Level.BODY, interceptor.level)
    }

    @Test
    fun verifyProvideHttpRequestInterceptor() {
        val interceptor = remoteModule.provideHttpRequestInterceptor()
        Truth.assertThat(interceptor).isInstanceOf(HttpRequestInterceptor::class.java)
    }

    @Test
    fun verifyProvideOkHttpClient() {
        val loggingInterceptor = mockk<HttpLoggingInterceptor>()
        val chuckerInterceptor = mockk<ChuckerInterceptor>()
        val httpRequestInterceptor = mockk<HttpRequestInterceptor>()
        val httpClient = remoteModule.provideOkHttpClient(
            context,
            loggingInterceptor,
            chuckerInterceptor,
            httpRequestInterceptor
        )

        Assert.assertEquals(3, httpClient.interceptors.size)
        Assert.assertEquals(loggingInterceptor, httpClient.interceptors.first())
        Assert.assertEquals(httpRequestInterceptor, httpClient.interceptors.last())
    }

    /*@Test
    fun verifyProvideCharacterService() {
        val baseUrl = remoteModule.provideBaseUrl(networkConfig)
        val httpClient = mockk<OkHttpClient>()
        val moshi = mockk<Moshi>()
        val retrofit = mockk<Retrofit>()
        val service = mockk<CharacterService>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<CharacterService>(any()) } returns service

        remoteModule.provideCharacterService(baseUrl, httpClient, moshi)

        verify { retrofit.create(capture(serviceClassCaptor)) }
        Assert.assertEquals(CharacterService::class.java, serviceClassCaptor.captured)
    }

    @Test
    fun verifyProvideEpisodeService() {
        val baseUrl = remoteModule.provideBaseUrl(networkConfig)
        val httpClient = mockk<OkHttpClient>()
        val moshi = mockk<Moshi>()
        val retrofit = mockk<Retrofit>()
        val service = mockk<EpisodeService>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<EpisodeService>(any()) } returns service

        remoteModule.provideEpisodeService(baseUrl, httpClient, moshi)

        verify { retrofit.create(capture(serviceClassCaptor)) }
        Assert.assertEquals(EpisodeService::class.java, serviceClassCaptor.captured)
    }*/
}