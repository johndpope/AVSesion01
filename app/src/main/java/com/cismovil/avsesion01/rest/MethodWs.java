package com.cismovil.avsesion01.rest;

import com.cismovil.avsesion01.entity.Categoria;
import com.cismovil.avsesion01.entity.request.CategoriaRequest;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MethodWs {

    @GET("categoria")
    @Headers("Content-Type:application/json")
    Call<List<Categoria>> listarCategorias();

    @GET("categoria/{idCategoria}")
    @Headers("Content-Type:application/json")
    Call<Categoria> obtenerCategoria(@Path("idCategoria") String idCategoria);

    @POST("categoria")
    @Headers("Content-Type:application/json")
    Call<List<Categoria>> registrarCategoria(@Body CategoriaRequest request);

    @PUT("categoria")
    @Headers("Content-Type:application/json")
    Call<List<Categoria>> actualizarCategoria(@Body CategoriaRequest request);

    @PUT("categoria/{idCategoria}")
    @Headers("Content-Type:application/json")
    Call<List<Categoria>> eliminarCategoria(@Path("idCategoria") String idCategoria);


}
