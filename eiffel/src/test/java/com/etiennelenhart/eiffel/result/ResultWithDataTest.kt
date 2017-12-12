package com.etiennelenhart.eiffel.result

import com.etiennelenhart.eiffel.ErrorType
import com.etiennelenhart.eiffel.Status
import org.junit.Assert.assertEquals
import org.junit.Test

@Suppress("IllegalIdentifier")
class ResultWithDataTest {

    @Test
    fun `GIVEN ResultWithData Success with 'data' WHEN 'status' queried THEN 'success' is returned`() {
        val result = ResultWithData.Success("")

        val actual = result.status

        assertEquals(Status.SUCCESS, actual)
    }

    @Test
    fun `GIVEN ResultWithData Success with 'data' WHEN 'data' queried THEN 'data' is returned`() {
        val data = "data"
        val result = ResultWithData.Success(data)

        val actual = result.data

        assertEquals(data, actual)
    }

    @Test
    fun `GIVEN ResultWithData Pending with 'data' WHEN 'status' queried THEN 'pending' is returned`() {
        val result = ResultWithData.Pending("")

        val actual = result.status

        assertEquals(Status.PENDING, actual)
    }

    @Test
    fun `GIVEN ResultWithData Pending with 'data' WHEN 'data' queried THEN 'data' is returned`() {
        val data = "data"
        val result = ResultWithData.Pending(data)

        val actual = result.data

        assertEquals(data, actual)
    }

    @Test
    fun `GIVEN ResultWithData Error with 'default' WHEN 'status' queried THEN 'error' is returned`() {
        val result = ResultWithData.Error("")

        val actual = result.status

        assertEquals(Status.ERROR, actual)
    }

    @Test
    fun `GIVEN ResultWithData Error with 'default' WHEN 'data' queried THEN 'default' is returned`() {
        val default = "default"
        val result = ResultWithData.Error(default)

        val actual = result.data

        assertEquals(default, actual)
    }

    @Test
    fun `GIVEN ResultWithData Error with 'default' WHEN 'type' queried THEN 'unspecified' is returned`() {
        val result = ResultWithData.Error("")

        val actual = result.type

        assertEquals(ErrorType.Unspecified, actual)
    }

    @Test
    fun `GIVEN ResultWithData Error with 'default' and 'type' WHEN 'type' queried THEN 'type' is returned`() {
        val type = object : ErrorType {}
        val result = ResultWithData.Error("", type)

        val actual = result.type

        assertEquals(type, actual)
    }
}