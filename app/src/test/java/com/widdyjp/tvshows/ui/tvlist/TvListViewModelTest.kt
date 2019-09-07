package com.widdyjp.tvshows.ui.tvlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.model.getDummyTvShows
import com.widdyjp.tvshows.data.repository.TvShowRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class TvListViewModelTest {
    private lateinit var viewModel: TvListViewModel
    private val tvShowRepository = mock(TvShowRepository::class.java)

    @Before
    fun setUp() {
        viewModel = TvListViewModel(tvShowRepository)
    }

    @Test
    fun getTvShows() {
        val dummyData = getDummyTvShows()

        val tvShows = MutableLiveData<List<TvModel>>()
        tvShows.value = dummyData

        `when`(tvShowRepository.getTvShows()).thenReturn(tvShows)

        val observer = mock(Observer::class.java)

        viewModel.getTvShows().observeForever(observer as Observer<in List<TvModel>>)

        verify(observer).onChanged(dummyData)
    }
}