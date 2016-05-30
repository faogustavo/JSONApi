package br.com.gustavofao.jsonapisample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.gustavofao.jsonapi.JSONApiConverter;
import com.gustavofao.jsonapi.Models.ErrorModel;
import com.gustavofao.jsonapi.Models.JSONApiObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.gustavofao.jsonapisample.V2.Authorization;
import br.com.gustavofao.jsonapisample.V2.City;
import br.com.gustavofao.jsonapisample.V2.Contact;
import br.com.gustavofao.jsonapisample.V2.Conversation;
import br.com.gustavofao.jsonapisample.V2.Financial;
import br.com.gustavofao.jsonapisample.V2.FinancialAccount;
import br.com.gustavofao.jsonapisample.V2.FinancialResume;
import br.com.gustavofao.jsonapisample.V2.Message;
import br.com.gustavofao.jsonapisample.V2.User;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONApiConverter api = new JSONApiConverter(
                Authorization.class,
                City.class,
                Contact.class,
                Conversation.class,
                Financial.class,
                FinancialAccount.class,
                FinancialResume.class,
                Message.class,
                User.class
        );

        if (new User().equals(new User()))
            Toast.makeText(MainActivity.this, "Equal", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Not equals", Toast.LENGTH_SHORT).show();

        Log.d("TAG", api.toJson(new User()));

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
