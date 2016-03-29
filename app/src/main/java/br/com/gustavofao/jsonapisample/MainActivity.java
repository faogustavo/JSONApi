package br.com.gustavofao.jsonapisample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gustavofao.jsonapi.JSONApiConverter;
import com.gustavofao.jsonapi.Models.JSONApiObject;
import com.gustavofao.jsonapi.Models.JSONList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.gustavofao.jsonapisample.Model.teste01.AllTypes;
import br.com.gustavofao.jsonapisample.Model.teste02.Article;
import br.com.gustavofao.jsonapisample.Model.teste02.Person;
import br.com.gustavofao.jsonapisample.Model.teste02.Comment;
import br.com.gustavofao.jsonapisample.Model.teste01.Post;
import br.com.gustavofao.jsonapisample.Model.teste01.Professional;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test02();
    }

    void test01() {
        JSONApiConverter api = new JSONApiConverter(Post.class, Professional.class, AllTypes.class);

        Professional prof = new Professional();
        prof.setAbout("About");
        prof.setActivity_humanized("Activity Humanized");
        prof.setActivity_list(Arrays.asList(new String[]{"Activity 1", "Activity 2"}));
        prof.setCity_id(1111);
        prof.setCnpj("1231311231");
        try {
            prof.setCreated_at(api.parseDate("2016-03-24T09:44:26+0200"));
            prof.setUpdated_at(api.parseDate("2016-03-24T09:44:26+0300"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        prof.setEmail("email@teste.com");
        prof.setFavorited(false);
        prof.setId("15");
        prof.setLatitude(154.545654);
        prof.setLongitude(151.45641);
        prof.setName("Gustavo Fão Valvassori");
        prof.setNegative_votes_count(0);
        prof.setPositive_votes_count(0);
        prof.setPhone("phone");
        prof.setPhoto("photo");

        AllTypes allTypes = new AllTypes();
        allTypes.setmBoolean(false);
        allTypes.setmDouble(15.256);
        allTypes.setmFloat(15.256f);
        allTypes.setId("ID");
        allTypes.setmInteger(20);
        allTypes.setmLong(155558l);
        allTypes.setmChar('G');
        allTypes.setmList(Arrays.asList(new Integer[]{3, 7, 10, 12, 4, 14}));
        allTypes.setProfessional(prof);

        Log.d("Debug", api.toJson(allTypes));


        JSONList<Post> posts = new JSONList<>();
        posts.add(Post.newInstance("id1", "title1", "content1", prof));
        posts.add(Post.newInstance("id2", "title2", "content2"));
        posts.add(Post.newInstance("id3", "title3", "content3", prof));
        posts.add(Post.newInstance("id4", "title4", "content4"));
        posts.add(Post.newInstance("id5", "title5", "content5", prof));

        Log.d("Debug", api.toJson(posts));

        String postsString =  api.toJson(posts);
        String allTypesString = api.toJson(allTypes);

        JSONApiObject obj0 = api.fromJson(postsString);
        if (obj0.getData().size() > 0) {
            Post post = (Post) obj0.getData().get(0);
            Log.e("Size", ":" + obj0.getData().size());
            Log.e("Post 0", post.getTitle());
        }

        JSONApiObject obj1 = api.fromJson(allTypesString);
        if (obj1.getData().size() > 0) {
            AllTypes res = (AllTypes) obj1.getData().get(0);
            Log.e("Teste", "" + res.getmList().size());
        }
    }

    void test02() {
        JSONApiConverter api = new JSONApiConverter(Article.class, Comment.class, Person.class);

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
        if (obj.getData().size() > 0) {
            Article article = (Article) obj.getData(0);
            Log.i("Article title:", article.getTitle());

            if (article.getComments().getLinks() != null) {
                Log.i("Comments:", article.getComments().getLinks().getRelated());
                Comment comment = article.getComments().get(0);
            } else {
                Log.e("Comments:", "Links are empty");
            }

            if (article.getPerson().getLinks() != null) {
                Log.i("Person:", article.getPerson().getLinks().getSelf());
            } else {
                Log.e("Person:", "Links are empty");
            }

            if (obj.getLinks() != null && obj.getLinks().getNext() != null) {
                Log.i("ProxPag", obj.getLinks().getNext());
            }

            String backToJsonArticle = api.toJson(article);
            Log.d("Article To Json", backToJsonArticle);
        }

        String backToJson = api.toJson(obj.getData());
        Log.d("BackJson", backToJson);
    }

}
