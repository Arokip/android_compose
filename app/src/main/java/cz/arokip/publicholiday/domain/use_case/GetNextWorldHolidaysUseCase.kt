package cz.arokip.publicholiday.domain.use_case

import cz.arokip.publicholiday.common.Resource
import cz.arokip.publicholiday.data.remote.dto.PublicHolidayDto
import cz.arokip.publicholiday.data.remote.dto.toCountry
import cz.arokip.publicholiday.data.remote.dto.toPublicHoliday
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.PublicHoliday
import cz.arokip.publicholiday.domain.repository.PublicHolidaysRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNextWorldHolidaysUseCase @Inject constructor(
    private val repository: PublicHolidaysRepository,
) {
    operator fun invoke(): Flow<Resource<List<PublicHoliday>>> = flow {
        try {
            emit(Resource.Loading())
            val nextHolidays = repository.getNextWorldHolidays()
            emit(Resource.Success(nextHolidays.map { it.toPublicHoliday() }))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected HTTP error occurred."))
        } catch (e: IOException) {
            println(e)
            emit(Resource.Error("Couldn't reach server. Check your internet connection. (${e.localizedMessage})"))
        }
    }
}