package br.com.gustavofao.jsonapisample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.gustavofao.jsonapi.JSONApiConverter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import br.com.gustavofao.jsonapisample.V2.City;
import br.com.gustavofao.jsonapisample.V2.Conversation;
import br.com.gustavofao.jsonapisample.V2.Person;
import br.com.gustavofao.jsonapisample.V2.User;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONApiConverter api = new JSONApiConverter(
                City.class,
                User.class,
                Person.class,
                Conversation.class
        );

        InputStream is = getResources().openRawResource(R.raw.data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        } catch (Exception ex) {}

        String json = writer.toString();
        Log.d("JSONApi", String.format("Start json = %s", json));

        Conversation obj = ((Conversation) api.fromJson(json).getData(0));
        Log.d("JSONApi", String.format("ID = %s", obj.getPerson().getId()));
        Log.d("JSONApi", String.format("status = %s", obj.getPerson().getUserStatus().name()));

        Log.d("JSONApi", String.format("Back as json = %s", api.toJson(obj)));

//        Person p = new Person();
//        p.setId("id-01");
//        p.setName("Gustavo");
//        p.setFirstName("Gustavo");
//        p.setPseudo("faogustavo");
//        p.setCity("Santa Maria - RS, Brazil");
//        p.setEmail("faogustavo@gmail.com");
//
//        String jsonValue = api.toJson(p);
//        Log.d("JSONApi", jsonValue);
//
//        Person p2 = ((Person) api.fromJson(jsonValue).getData(0));
//        String jsonValue2 = api.toJson(p2);
//        Log.d("JSONApi", jsonValue2);

//        if (new User().equals(new User()))
//            Toast.makeText(MainActivity.this, "Equal", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(MainActivity.this, "Not equals", Toast.LENGTH_SHORT).show();

//        User u = new User();
//        City city = new City();
//
//        city.setId("123");
//        u.setCity(city);
//
//        Log.d("TAG", api.toJson(u));

//        InputStream is = getResources().openRawResource(R.raw.data);
//        Writer writer = new StringWriter();
//        char[] buffer = new char[1024];
//        try {
//            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            int n;
//            while ((n = reader.read(buffer)) != -1) {
//                writer.write(buffer, 0, n);
//            }
//            is.close();
//        } catch (Exception ex) {}
//
//        String json = writer.toString();
//        JSONApiObject obj = api.fromJson(json);
//        if (obj.hasErrors()) {
//            List<ErrorModel> errorList = obj.getErrors();
//            for (ErrorModel model : errorList) {
//                StringBuilder builder = new StringBuilder();
//                if (model.getSource() != null) {
//                    if (model.getSource().getPointer() != null) {
//                        builder.append(String.format("Pointer: %s - ", model.getSource().getPointer()));
//                    }
//
//                    if (model.getSource().getParameter() != null) {
//                        builder.append(String.format("Parameter: %s - ", model.getSource().getParameter()));
//                    }
//                }
//
//                if (model.getDetail() != null) {
//                    builder.append(String.format("Details: %s - ", model.getDetail()));
//                }
//
//                if (model.getTitle() != null) {
//                    builder.append(String.format("Title: %s - ", model.getTitle()));
//                }
//
//                if (model.getStatus() != null) {
//                    builder.append(String.format("Status: %s - ", model.getStatus()));
//                }
//
//                Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();
//            }
//        } else
//            Toast.makeText(MainActivity.this, "No Errors", Toast.LENGTH_SHORT).show();
    }

}
