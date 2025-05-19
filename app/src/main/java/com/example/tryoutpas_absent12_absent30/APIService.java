package com.example.tryoutpas_absent12_absent30;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getTeams();
    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamResponse> getAllTeams2();
}
