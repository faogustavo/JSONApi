package br.com.gustavofao.jsonapisample.Service;

import java.util.List;

import br.com.gustavofao.jsonapisample.Model.teste01.Professional;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ProfessionalService {

    @Headers({"Content-Type: application/json", "Authorization: Token token=\"fXfHEJoS56EzhmagFiwA3J66\", email=\"gustavo_valvassori@outlook.com\""})
    @GET("v2/professionals/search")
    Call<List<Professional>> getProfessionals(
            @Query("page[number]") int pageNumber,
            @Query("page[size]") int pageSize,
            @Query("search[query]") String query
    );

}
