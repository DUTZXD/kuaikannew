package com.zxd.kuaikannew;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    private MutableLiveData<ArrayList<ManhuaEntity>> manhuaData = new MutableLiveData<>();

    public MutableLiveData<ArrayList<ManhuaEntity>> getManhuaData() {
        return manhuaData;
    }

    public void getUpdate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.kuaikanmanhua.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ManhuaService manhuaService = retrofit.create(ManhuaService.class);
        Call<ManhuaBean> call = manhuaService.getDailyUpdate();
        call.enqueue(new Callback<ManhuaBean>() {
            @Override
            public void onResponse(Call<ManhuaBean> call, Response<ManhuaBean> response) {
                ManhuaBean manhuaBean = response.body();
                Data data = manhuaBean.getData();
                ArrayList<ManhuaEntity> entityList = new ArrayList<>();
                for (Topics topic : data.getTopics()) {
                    ManhuaEntity entity = new ManhuaEntity();
                    entity.cover = topic.getCover_image_url();
                    entity.title = topic.getTitle();
                    entity.des = topic.getDescription();
                    entityList.add(entity);
                }
                manhuaData.postValue(entityList);
            }

            @Override
            public void onFailure(Call<ManhuaBean> call, Throwable t) {

            }
        });
    }
}
