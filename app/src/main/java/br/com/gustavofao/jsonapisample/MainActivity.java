package br.com.gustavofao.jsonapisample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.gustavofao.jsonapi.JSONApiConverter;
import com.gustavofao.jsonapi.Models.JSONApiObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import br.com.gustavofao.jsonapisample.V2.Authorization;
import br.com.gustavofao.jsonapisample.V2.City;
import br.com.gustavofao.jsonapisample.V2.Contact;
import br.com.gustavofao.jsonapisample.V2.Conversation;
import br.com.gustavofao.jsonapisample.V2.Deal;
import br.com.gustavofao.jsonapisample.V2.Financial;
import br.com.gustavofao.jsonapisample.V2.FinancialAccount;
import br.com.gustavofao.jsonapisample.V2.FinancialResume;
import br.com.gustavofao.jsonapisample.V2.Message;
import br.com.gustavofao.jsonapisample.V2.Session;
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
                Deal.class,
                Financial.class,
                FinancialAccount.class,
                FinancialResume.class,
                Message.class,
                Session.class,
                User.class
        );


//        Session session = new Session();
//        session.setUid("uid123");
//        session.setDeviceId("device_id123");
//
//        Map<String, Object> info = new HashMap<>();
//        info.put("name", "Nome do vivente");
//        info.put("email", "email@vivente.com.br");
//        session.setInfo(info);
//
//        Log.d("ToJsonWithMap", api.toJson(session));

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
        JSONApiObject obj = api.fromJson(json);
        Session con = ((Session) obj.getData(0));
        Log.d("BackToJSON", api.toJson(con));
    }

}
