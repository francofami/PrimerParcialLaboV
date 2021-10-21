package com.example.primerparciallaboratoriov;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class EditarActivity extends AppCompatActivity implements IOnEditClick{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_editar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.menuEditar);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = super.getIntent().getExtras();

        Serializable producto = extras.getSerializable("producto");

        EditarController editarController = new EditarController((Producto) producto);
        EditarView editarView = new EditarView(this, (Producto) producto, editarController, this);

        editarController.setEditarView(editarView);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home) {

            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEditClick(Producto producto) {
        Log.d("", "Entre en onEditClick");
        Intent intent = new Intent();
        intent.putExtra("productoEditado", (Producto) producto);
        setResult(RESULT_OK, intent);
        finish();
    }

}
