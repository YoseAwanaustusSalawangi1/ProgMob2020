package com.example.progmob2020.Network;

import com.example.progmob2020.Model.DefaultResult;
import com.example.progmob2020.Model.Dosen;
import com.example.progmob2020.Model.Mahasiswa;
import com.example.progmob2020.Model.Matkul;
import com.example.progmob2020.Model.User;


import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("api/progmob/mhs/{nim_progmob}")
    Call<List<Mahasiswa>> getMahasiswa(@Path("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("api/progmob/mhs/delete")
    Call<DefaultResult>delete_mhs(
            @Field("nim") String id,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/mhs/create")
    Call<DefaultResult> add_mhs(
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/mhs/update")
    Call<DefaultResult>update_mhs(
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("nim_cari") String nim_cari,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );

    @FormUrlEncoded
    @POST("api/progmob/login")
    Call<List<User>>login(
            @Field("nimnik") String nimnik,
            @Field("password") String password
    );

    @GET("api/progmob/dosen/{nim_progmob}")
    Call<List<Dosen>> getDosen(@Path("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("api/progmob/dosen/create")
    Call<DefaultResult> add_dsn(
            @Field("nama") String nama,
            @Field("nidn") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("gelar") String gelar,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/dosen/update")
    Call<DefaultResult>update_dsn(
            @Field("nama") String nama,
            @Field("nidn") String nidn,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("gelar") String gelar,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob,
            @Field("nidn_cari") String nidn_cari
    );
    @FormUrlEncoded
    @POST("api/progmob/dosen/delete")
    Call<DefaultResult>delete_dsn(
            @Field("nidn") String id,
            @Field("nim_progmob") String nim_progmob
    );

    @GET("api/progmob/matkul/{nim_progmob}")
    Call<List<Matkul>> getMatkul(@Path("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("api/progmob/matkul/create")
    Call<DefaultResult> add_mtkl(
            @Field("nama") String nama,
            @Field("kode") String kode,
            @Field("hari") String hari,
            @Field("sesi") String sesi,
            @Field("sks") String sks,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/matkul/update")
    Call<DefaultResult> update_mtkl(
            @Field("nama") String nama,
            @Field("kode") String kode,
            @Field("hari") String hari,
            @Field("sesi") String sesi,
            @Field("sks") String sks,
            @Field("kode_cari") String kode_cari,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/matkul/delete")
    Call<DefaultResult>delete_mtkl(
            @Field("kode") String id,
            @Field("nim_progmob") String nim_progmob
    );
}