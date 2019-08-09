package com.cismovil.avsesion01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cismovil.avsesion01.entity.Categoria;
import com.cismovil.avsesion01.entity.request.CategoriaRequest;
import com.cismovil.avsesion01.rest.HelperWs;
import com.cismovil.avsesion01.rest.MethodWs;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_obtener_todos)
    public void obtenerTodasCategorias() {
        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);
        Call<List<Categoria>> response = methodWs.listarCategorias();
        response.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    List<Categoria> listaCategoria = response.body();
                    recorrerListaCategoria(listaCategoria);

                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("ypinto", t.getMessage().toString());
            }
        });
    }

    private void recorrerListaCategoria(List<Categoria> listaCategoria) {
        for (Categoria c : listaCategoria) {
            imprimirCategoria(c);

        }
    }

    private void imprimirCategoria(Categoria c) {
        Log.i("ypinto", c.get_id());
        Log.i("ypinto", c.getDescripcion());
        Log.i("ypinto", c.getNombre());
        Log.i("ypinto", "" + c.get__v());
    }

    @OnClick(R.id.btn_obtener_categoria)
    public void obtenerCategoria() {
        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);

        Call<Categoria> response = methodWs.obtenerCategoria("57968f9d0e56580300ab7864");

        response.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                if (response.isSuccessful()) {
                    Categoria c = response.body();
                    imprimirCategoria(c);
                }
            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                Log.e("ypinto", t.getMessage().toString());
            }
        });
    }

    @OnClick(R.id.btn_grabar_categoria)
    public void registrarCategoria() {
        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);
        CategoriaRequest categoriaRequest = new CategoriaRequest();
        categoriaRequest.setTxt_name_categoria("Categoria Yojan");
        categoriaRequest.setText_desc_categoria("Descripcion Categoria Yojan");

        Call<List<Categoria>> response = methodWs.registrarCategoria(categoriaRequest);

        response.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    List<Categoria> listaCategoria = response.body();
                    recorrerListaCategoria(listaCategoria);
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("ypinto", t.getMessage().toString());
            }
        });
    }

    //5d4a3f57c758570400af56dc
    @OnClick(R.id.btn_update_categoria)
    public void actualizarCategoria() {
        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);
        CategoriaRequest request = new CategoriaRequest();
        request.setIdCategoria("5d4a3f57c758570400af56dc");
        request.setTxt_name_categoria("Categoria Yojan V2");
        request.setText_desc_categoria("Descripcion Categoria Yojan v2");
        Call<List<Categoria>> response = methodWs.actualizarCategoria(request);

        response.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    recorrerListaCategoria(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("ypinto", t.getMessage().toString());
            }
        });
    }

    @OnClick(R.id.btn_delete_categoria)
    public void eliminarCategoria() {
        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);
        Call<List<Categoria>> response = methodWs.eliminarCategoria("5d4a3f57c758570400af56dc");

        response.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    recorrerListaCategoria(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("ypinto", t.getMessage().toString());
            }
        });
    }
}
