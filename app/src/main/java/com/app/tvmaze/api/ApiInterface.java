package com.app.tvmaze.api;

import com.app.tvmaze.model.TvMazeModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
	@GET("/shows/1/cast")
	Call<List<TvMazeModelItem>> getHeroList();
}
