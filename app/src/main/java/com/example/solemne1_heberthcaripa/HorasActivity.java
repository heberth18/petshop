package com.example.solemne1_heberthcaripa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.solemne1_heberthcaripa.database.AdminSQLiteOpenHelper;

public class HorasActivity extends AppCompatActivity {

    private EditText codeTxt, horaTxt, mascotaTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horas);

        codeTxt = findViewById(R.id.txtCode);
        horaTxt = findViewById(R.id.txtHora);
        mascotaTxt = findViewById(R.id.txtMascota);
    }

    public void guardarHora(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "petshop", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = codeTxt.getText().toString();
        String hora = horaTxt.getText().toString();
        String mascota = mascotaTxt.getText().toString();

        if (!codigo.isEmpty() && !hora.isEmpty() && !mascota.isEmpty()) {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("hora", hora);
            cont.put("mascota", mascota);

            db.insert("horas", null, cont);
            db.close();
            clean();

        } else {
            Toast.makeText(getBaseContext(), "Los campos no pueden ir vacios", Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminarHora(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "petshop", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codeTxt.getText().toString();
        if (!codigo.isEmpty()) {

            db.delete("horas", "codigo="+codigo, null);
            Toast.makeText(getBaseContext(), "has eliminado la hora: "+codigo, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(), "El codigo no puede ir vacio", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarHora(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "petshop", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codeTxt.getText().toString();

        if (!codigo.isEmpty()) {
          Cursor file = db.rawQuery("SELECT hora, mascota FROM horas WHERE codigo="+codigo, null);
           if (file.moveToFirst()) {
               horaTxt.setText(file.getString(0));
               mascotaTxt.setText(file.getString(1));
           } else {
               Toast.makeText(getBaseContext(), "No hay horas asociadas", Toast.LENGTH_SHORT).show();

           }

        } else {
            Toast.makeText(getBaseContext(), "El codigo no puede ir vacio", Toast.LENGTH_SHORT).show();
        }

    }

    public void actualizarHora(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "petshop", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codeTxt.getText().toString();
        String hora = horaTxt.getText().toString();
        String mascota = mascotaTxt.getText().toString();

        if (!codigo.isEmpty() && !hora.isEmpty() && !mascota.isEmpty()) {
            ContentValues cont = new ContentValues();
            cont.put("hora", hora);
            cont.put("mascota", mascota);

            db.update("horas", cont, "codigo="+codigo, null);
            db.close();
            clean();

            Toast.makeText(getBaseContext(), "Hora actualizada correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(), "Los campos no pueden ir vacios", Toast.LENGTH_SHORT).show();
        }



    }

    public void clean(){
        codeTxt.setText("");
        horaTxt.setText("");
        mascotaTxt.setText("");
    }
}