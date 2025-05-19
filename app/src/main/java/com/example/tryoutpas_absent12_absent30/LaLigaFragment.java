package com.example.tryoutpas_absent12_absent30;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LaLigaFragment extends Fragment {

    private RecyclerView recyclerView;
    private TeamAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_la_liga, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadTeams();
        return view;
    }

    private void loadTeams(){
        ApiClient.getClient()
                .create(APIService.class)
                .getAllTeams2()
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<com.example.tryoutpas_absent12_absent30.TeamResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<Team> teams = response.body().getTeams();
                            adapter = new TeamAdapter(getContext(), teams);
                            recyclerView.setAdapter(adapter);
                        } else {
                            Toast.makeText(getContext(), "Gagal memuat tim", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
