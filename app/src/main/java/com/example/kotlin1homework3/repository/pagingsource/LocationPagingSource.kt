package com.example.kotlin1homework3.repository.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin1homework3.data.network.apiservices.LocationApiService
import com.example.kotlin1homework3.model.LocationModel
import retrofit2.HttpException
import java.io.IOException

private const val LOCATION_STARTING_PAGE_INDEX = 1

class LocationPagingSource(
    private val locationApiService: LocationApiService
) : PagingSource<Int, LocationModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
        val position = params.key ?: LOCATION_STARTING_PAGE_INDEX
        return try {
            val response = locationApiService?.fetchLocations(position)
            val nextPage = response?.info?.next
            val nextPageNumber = if (nextPage == null) {
                null
            } else {
                Uri.parse(response.info.next).getQueryParameter("page")?.toInt()
            }

            LoadResult.Page(
                data = response!!.results,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)

        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}